package com.example.demo.Servicio;

import com.example.demo.Entidad.Libro;
import com.example.demo.Repositorio.repoLibro;
import org.springframework.stereotype.Service;

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
            return libro.getIsbn();
        }
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
