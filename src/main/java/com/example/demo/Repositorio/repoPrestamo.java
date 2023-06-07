package com.example.demo.Repositorio;

import com.example.demo.Entidad.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface repoPrestamo extends JpaRepository<Prestamo, Integer> {

@Query(value="select p.id_prestamo, p.fecha, e.nombre, e.apellido, l.titulo, l.autor from prestamo as p inner join estudiante as e on p.documento = e.documento inner join libro as l on p.isbn = l.isbn", nativeQuery = true)
    List<Object[]> findDatosPrestamo();

    @Query(value="select p.id_prestamo, p.fecha, e.nombre, e.apellido, l.titulo, l.autor from prestamo as p inner join estudiante as e on p.documento = e.documento inner join libro as l on p.isbn = l.isbn where p.documento= :est", nativeQuery = true)
    List<Object[]> findEstudiantePrestamo(String est);
}
