package com.example.demo.Controlador;

import com.example.demo.Entidad.Estudiante;
import com.example.demo.Servicio.ServicioEstudiante;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class ControladorEstudiante {

    private ServicioEstudiante servicio;

    public ControladorEstudiante(ServicioEstudiante servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/listarEstudiantes")
    public List<Estudiante> listarEstudiantes(){
        return servicio.listarEstudiantes();
    }
}
