$(document).ready(function() {

//Carga Select con Estudiantes
let listaEst = document.querySelector('#est')
        listaEst.innerHTML = ''
        $.ajax({
            url: "http://localhost:8080/listarEstudiantes",
            type: "GET",
            datatype: "JSON",
            success: function(respuesta) {
                console.log(respuesta)
                Object.values(respuesta).forEach(Estudiantes => {
                    listaEst.innerHTML += '<option value="' +Estudiantes["documento"] +'">'
                    + Estudiantes["nombre"] +' '+ Estudiantes["apellido"]+'</option>';
                });
            }

        });
//Carga Select con Libros
let listaLib = document.querySelector('#lib')
        listaLib.innerHTML = ''
        $.ajax({
            url: "http://localhost:8080/listarLibros",
            type: "GET",
            success: function(respuesta) {
                console.log(respuesta)
               Object.values(respuesta).forEach(Libros =>  {
                    listaLib.innerHTML += '<option value="' + Libros["isbn"] +'">'
                    +  Libros["titulo"] +' - '+  Libros["autor"] +'</option>';
                });
            }

        });

//Insertar Prestamo
    $('#enviar').on('click', function() {
        let estudiante = $('#est option:selected').val();
        alert(estudiante);
        let libro = $('#lib option:selected').val();
        alert(libro);
        $.ajax({
            url: "localhost:8080/agregarPrestamo/" +estudiante+ "/"+libro,
            type: "POST",
            contentType:"application/JSON",
            datatype: JSON,
            success: function(respuesta) {
            alert(respuesta);
            }
        });

    });


});
