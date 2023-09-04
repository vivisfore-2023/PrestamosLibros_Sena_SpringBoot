package com.example.demo.Servicio;

import com.example.demo.Entidad.Libro;
import com.example.demo.Repositorio.repoLibro;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ServicioLibro {

    private repoLibro repositorio;

    public ServicioLibro(repoLibro repositorio) {
        this.repositorio = repositorio;
    }

    public List<Libro> listarLibros(){
        return repositorio.findAll();
    }

    public Libro buscarLibro(String isbn){
        return repositorio.findById(isbn).get();
    }

    public String guardar(Libro libro){
        if(repositorio.findById(libro.getIsbn()).isPresent()){
            return "El Libro ya se encuentra registrado";
        }else{
            repositorio.save(libro);
           // guardarImagen(libro.getIsbn(),imagen);
            return libro.getIsbn();
        }
    }

    public String guardarImagen(String isbn,MultipartFile imagen){

        if(!imagen.isEmpty()){
            Path directorio= Paths.get("src//main//resources//static/imagenes");
            String ruta= directorio.toFile().getAbsolutePath();
                Libro libro=buscarLibro(isbn);
                try {
                    byte[] bytesImage= imagen.getBytes();
                    Path rutaCompleta = Paths.get(ruta+"//"+isbn+"_"+imagen.getOriginalFilename());
                    Files.write(rutaCompleta,bytesImage);
                    libro.setImagen(libro.getIsbn()+"_"+imagen.getOriginalFilename());
                    return actualizar(libro);
                }catch (IOException e) {
                    throw new RuntimeException(e);
                }
        }else return "No se adjunto imagen";
    }

    public String actualizar(Libro libro){
        if(repositorio.findById(libro.getIsbn()).isPresent()){
            repositorio.save(libro);
            return "Actualización ok";
        }else{
            return "El libro no existe en el sistema.";
        }
    }
}
