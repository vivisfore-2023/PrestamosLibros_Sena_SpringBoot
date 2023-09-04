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

/*import { createClient } from '@supabase/supabase-js';

const supabaseUrl = 'https://ufcbzyemarifjeahojdj.supabase.co';
const supabaseKey = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InVmY2J6eWVtYXJpZmplYWhvamRqIiwicm9sZSI6ImFub24iLCJpYXQiOjE2ODc3ODM1OTUsImV4cCI6MjAwMzM1OTU5NX0.kP0HADbhutMyTWNJlMlKPkper53RbuippHhOOmbrTLY';

const supabase = createClient(supabaseUrl, supabaseKey);*/

/*/
formLibro.addEventListener('submit',function(e){
      e.preventDefault();
alert("Aquiiiii")
var libro=new FormData(formLibro);
      alert(libro.get('img'));
const fileInput = document.getElementById('img');

fileInput.addEventListener('change', async (e) => {
  const file = e.target.files[0];
  const { data, error } = await supabase.storage
    .from('imagenes') // Reemplaza con el nombre de tu bucket en Supabase
    .upload('prueba', file); // Reemplaza con la carpeta en la que deseas guardar la imagen

  if (error) {
    console.error(error);
  } else {
    console.log('Imagen cargada exitosamente:', data.Key);

});

*/
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