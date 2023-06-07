package com.example.demo.Controlador;

import com.example.demo.Entidad.Libro;
import com.example.demo.Servicio.ServicioLibro;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
