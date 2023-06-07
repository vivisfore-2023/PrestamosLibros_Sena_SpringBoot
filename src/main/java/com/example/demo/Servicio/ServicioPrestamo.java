package com.example.demo.Servicio;

import com.example.demo.Entidad.Estudiante;
import com.example.demo.Entidad.Libro;
import com.example.demo.Entidad.Prestamo;
import com.example.demo.Repositorio.repoEstudiante;
import com.example.demo.Repositorio.repoLibro;
import com.example.demo.Repositorio.repoPrestamo;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioPrestamo {

    private repoPrestamo repositorio;
    private repoEstudiante repoEst;
    private repoLibro repoLib;

    public ServicioPrestamo(repoPrestamo repositorio, repoEstudiante repoEst, repoLibro repoLib) {
        this.repositorio = repositorio;
        this.repoEst = repoEst;
        this.repoLib = repoLib;
    }

    public List<Prestamo> listarPrestamo(){
        return repositorio.findAll();
    }


    public String agregarPrestamo(String est,String lib){

        Prestamo p= new Prestamo();
        Estudiante Est= repoEst.findById(est).get();
        Libro Lib= repoLib.findById(lib).get();
        if(repoEst.findById(est).isPresent() && repoLib.findById(lib).isPresent()){
            p.setEstudiante(Est);
            p.setLibro(Lib);
            repositorio.save(p);
            return "Prestamo Registrado";
        }
        else return "El Estudiante y/o Libro no existen.";

   }

   public List<Object[]> datosPrestamo(){
        return repositorio.findDatosPrestamo();
}

    public List<Object[]> estudiantePrestamo(String est){
        return repositorio.findEstudiantePrestamo(est);
    }
}
