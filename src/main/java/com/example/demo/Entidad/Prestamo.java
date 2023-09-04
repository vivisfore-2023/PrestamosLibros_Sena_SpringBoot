package com.example.demo.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="prestamo")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_prestamo;

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="documento", referencedColumnName = "documento", nullable = false)
    @JsonIgnore
    public Estudiante estudiante;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="isbn", referencedColumnName = "isbn", nullable = false)
    @JsonIgnore
    public Libro libro;

    @PrePersist
    public void fechaActual(){

        this.fecha= new Date();
    }



    public Prestamo(Integer id_prestamo, Date fecha, Estudiante estudiante, Libro libro) {
        this.id_prestamo = id_prestamo;
        this.fecha = fecha;
        this.estudiante = estudiante;
        this.libro = libro;
    }



    public Prestamo() {
    }

    public Integer getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(Integer id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "id_prestamo=" + id_prestamo +
                ", fecha=" + fecha +
                ", estudiante=" + estudiante.getNombre() +
                ", libro=" + libro.getTitulo() +
                '}';
    }
}
