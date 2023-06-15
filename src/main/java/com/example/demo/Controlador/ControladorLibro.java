package com.example.demo.Controlador;

import com.example.demo.Entidad.Libro;
import com.example.demo.Servicio.ServicioLibro;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestPart;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class ControladorLibro {

    private ServicioLibro servicio;

    public ControladorLibro(ServicioLibro servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/listarLibros")
    public List<Libro> listarLibros(){
        return servicio.listarLibros();
    }

    @PostMapping("/InsertaLibro")
    public String guardarLibro(@RequestBody Libro libro){
        return servicio.guardar(libro);
    }

    @PostMapping("/GuardarImagen/{isbn}") //Metodo para subir imagen
    public String guardarImagen(@PathVariable("isbn") String isbn, @RequestParam("file") MultipartFile imagen){

        if(!imagen.isEmpty()){
            Path directorio= Paths.get("src//main//resources//static/imagenes");
            String ruta= directorio.toFile().getAbsolutePath();
            if(servicio.buscarLibro(isbn)!=null){
                Libro libro=servicio.buscarLibro(isbn);
                try {
                    byte[] bytesImage= imagen.getBytes();
                    Path rutaCompleta = Paths.get(ruta+"//"+isbn+"_"+imagen.getOriginalFilename());
                    Files.write(rutaCompleta,bytesImage);
                    libro.setImagen(libro.getIsbn()+"_"+imagen.getOriginalFilename());
                    servicio.actualizar(libro);
                }catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }else{
                return "Libro no existe, para agregar imagen";
            }

        }
        //https://www.youtube.com/watch?v=h5YW-_xgmlo&t=419s
        //https://www.youtube.com/watch?v=df67kmObW7M
        return "Proceso Terminado";
    }
/*
    @PostMapping("/subirArchivo")
    public String uploadFile(@RequestPart("file") MultipartFile file) {
        RestTemplate restTemplate = new RestTemplate();

        try {
            // Configurar encabezados
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            headers.set("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Inh0dHRlamh0cGpic3hpamhlcmFrIiwicm9sZSI6ImFub24iLCJpYXQiOjE2ODIzNTAyNzMsImV4cCI6MTk5NzkyNjI3M30.uKHhPTBDtdT8qWQ1P0W6cF2AaJYHXwTF0HKw2Yy3k7I");

            // Configurar la solicitud
            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("file", new ByteArrayResource(file.getBytes()));
            org.springframework.http.HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

            // Realizar la solicitud POST a Supabase Storage
            ResponseEntity<String> response = restTemplate.exchange(
                    "https://xtttejhtpjbsxijherak.supabase.co/storage/v1/object/public/prueba449/imagenes",
                    HttpMethod.POST,
                    (org.springframework.http.HttpEntity<?>) requestEntity,
                    String.class
            );

            // Devolver la respuesta
            return response.getBody();
        } catch (IOException e) {
            e.printStackTrace();
            // Manejar el error como desees
        }

        return "Error al cargar el archivo";
    }*/
}
