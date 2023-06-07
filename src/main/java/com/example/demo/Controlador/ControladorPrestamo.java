package com.example.demo.Controlador;

import com.example.demo.Entidad.Prestamo;
import com.example.demo.Servicio.ServicioPrestamo;
import org.primefaces.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class ControladorPrestamo {

    private ServicioPrestamo servicio;

    public ControladorPrestamo(ServicioPrestamo servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/listarPrestamos")
    public List<Prestamo> listarPrestamo(){
        return servicio.listarPrestamo();
    }

    @PostMapping("/agregarPrestamo/{est}/{lib}")
    public String guardaPrestamo(@PathVariable("est") String doc,@PathVariable("lib") String isbn ){
        return servicio.agregarPrestamo(doc,isbn);
    }


    @GetMapping("/detallePrestamos")
    public List<Map<String, Object>> datosPrestamo(){
        List<Object[]> lista=servicio.datosPrestamo();
        List<Map<String, Object>> json=new ArrayList<Map<String, Object>>();
        for(Object[] objects: lista){
            Map<String, Object> datos= new HashMap<>();
            datos.put("id_prestamo",objects[0]);
            datos.put("fecha",objects[1]);
            datos.put("nombre",objects[2]);
            datos.put("apellido",objects[3]);
            datos.put("titulo",objects[4]);
            datos.put("autor",objects[5]);
            json.add(datos);
        }


        for(Map<String, Object> j : json){
            System.out.println(j);
        }
        return json;

    }

    @GetMapping("/detallePrestamosEstudiante/{est}")
    public List<Map<String, Object>> estudiantePrestamo(@PathVariable("est") String est) {
        List<Object[]> lista = servicio.estudiantePrestamo(est);
        List<Map<String, Object>> json = new ArrayList<Map<String, Object>>();
        for (Object[] objects : lista) {
            Map<String, Object> datos = new HashMap<>();
            datos.put("id_prestamo", objects[0]);
            datos.put("fecha", objects[1]);
            datos.put("nombre", objects[2]);
            datos.put("apellido", objects[3]);
            datos.put("titulo", objects[4]);
            datos.put("autor", objects[5]);
            json.add(datos);
        }


        for (Map<String, Object> j : json) {
            System.out.println(j);
        }
        return json;
    }

}
