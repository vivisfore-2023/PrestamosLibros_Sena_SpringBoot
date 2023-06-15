$(document).ready(function() {

var formLibro=document.getElementById('envioLibro');

      formLibro.addEventListener('submit',function(e){
      e.preventDefault();

      var libro=new FormData(formLibro);
      alert(libro.get('titulo'));
      let datos ={
                         "isbn": libro.get('isbn'),
                         "titulo": libro.get('titulo'),
                         "autor": libro.get('autor'),
                         "editorial": libro.get('editorial'),
                         "no_pag": libro.get('pages'),
                         "imagen":null
                 }
      let datosEnvio = JSON.stringify(datos);
              $.ajax({
                  url: "http://localhost:8080/InsertaLibro",
                  type: "POST",
                  data: datosEnvio,
                  contentType: "application/JSON",
                  datatype: JSON,
                  success: function(respuesta) {
                      console.log(respuesta);
                      alert(respuesta)
                  }
              });

});
/*

{
        "isbn": "Isbn101",
        "titulo": "Prueba con Imagen",
        "autor": "Viviana Forero",
        "editorial": "Sena",
        "no_pag": 100,
        "imagen":null
}
$('#boton').on('click', function() {

        let datos = {
            mid: parseInt($('#id').val()),
            nobre: $('#nombre').val(),
            pais: $('#pais').val(),
            fecha: $('#fecha').val(),
            correo: $('#correo').val()
        }
        let datosEnvio = JSON.stringify(datos);
        $.ajax({
            url: "http://localhost:8080/AgregarUsuario",
            type: "POST",
            data: datosEnvio,
            contentType: "application/JSON",
            datatype: JSON,
            success: function(respuesta) {
                console.log(respuesta);
                alert(respuesta)

            }
        })

    });*/

});