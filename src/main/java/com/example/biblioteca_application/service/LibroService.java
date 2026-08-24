package com.example.biblioteca_application.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.biblioteca_application.entity.Libro;
import com.example.biblioteca_application.repository.LibroRepository;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> findAllLibros() {
        return libroRepository.findAll();
    }

    public Optional<Libro> findLibroById(Long idLibro) {
        return libroRepository.findById(idLibro);
    }

    Libro saveLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    void updateLibro(Long idLibro, Libro libro) {
        Libro libroBD = findLibroById(idLibro).get();
        libroBD.setTitulo(libro.getTitulo());
        libroBD.setAutor(libro.getAutor());
        libroBD.setIsbn(libro.getIsbn());

        libroRepository.save(libroBD);
    }

    void deleteLibroById(Long idLibro) {
        libroRepository.deleteById(idLibro);
    }

}
