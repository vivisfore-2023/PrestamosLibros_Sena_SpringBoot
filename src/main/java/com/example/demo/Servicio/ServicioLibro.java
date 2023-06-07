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
}
