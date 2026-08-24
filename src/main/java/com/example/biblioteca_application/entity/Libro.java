package com.example.biblioteca_application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // indica que esta clase se mapea a una BBDD
@Data // genera automaticamente getters, setters...
@AllArgsConstructor // genera automaticamente un constructor con argumentos
@NoArgsConstructor // genera automaticamente un constructor sin argumentos
@Builder // es un patrón de diseño para construir las clases
@Table(name = "libros") // nombre con el que se mapea esta Clase a la BBDD

public class Libro {

    @Id // indica que este atributo "pokemonId" es la Clave primaria de la Tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) // para que genera automaticamente el id, cada Pokemon tiene uno
                                                        // único y la base de datos se encarga de asignarlo.
    private Long idLibro;
    private String titulo;
    private String autor;
    private String isbn;
}
