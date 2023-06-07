package com.example.demo.Repositorio;

import com.example.demo.Entidad.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repoLibro extends JpaRepository<Libro, String> {
}
