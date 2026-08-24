package com.example.biblioteca_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.biblioteca_application.entity.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    // "JpaRepository <Libro, Long>" Jpa necesita dos argumentos, el primero es la
    // entidad el segundo es el tipo de dato de su llave primaria

}
