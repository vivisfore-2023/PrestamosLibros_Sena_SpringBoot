package com.example.demo.Repositorio;

import com.example.demo.Entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface usuarioRepositorio extends JpaRepository<Usuario,String> {

   Usuario findByEmail(String email);
}
