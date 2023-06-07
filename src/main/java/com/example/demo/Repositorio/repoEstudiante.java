package com.example.demo.Repositorio;

import com.example.demo.Entidad.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repoEstudiante extends JpaRepository<Estudiante, String> {
}
