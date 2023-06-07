package com.example.demo.Servicio;

import com.example.demo.Entidad.Estudiante;
import com.example.demo.Repositorio.repoEstudiante;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEstudiante {

    private repoEstudiante repositorio;

    public ServicioEstudiante(repoEstudiante repositorio) {
        this.repositorio = repositorio;
    }

    public List<Estudiante> listarEstudiantes(){
        return repositorio.findAll();
    }
}
