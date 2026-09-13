package com.example.biblioteca_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.biblioteca_application.entity.Libro;
import com.example.biblioteca_application.service.LibroService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping("/")
    public String listarLibros(Model model) { // "Model model" modelo con el que vamos a pasar a la vista la lista de
                                              // libros
        model.addAttribute("libros", libroService.findAllLibros()); // añadimos al modelo un objeto con nombre "libros"
                                                                    // el objeto será todos los libros de la bbdd
        return "/listaLibros"; // retonamos el nombre de la vista a la que le enviamos el Modelo
    }

    @GetMapping("/create") // "/create" la URL que nos lleva a la vista "createLibro"
    public String registrarNuevoLibro() {
        return "/createLibro"; // retonamos el nombre de la vista a la que nos envía cuando entramos en /create
    }

    @PostMapping("/guardarLibro")
    public String guardarLibro(Libro libro) {
        libroService.saveLibro(libro);
        return "redirect:/";
    }

    // ********** UPDATE **********
    // creo un nuevo endpoint
    // mapea una nueva vista y le pasa mediante la URL el id del libro a actualizar
    @GetMapping("/actualizarLibro/{id}") // "/actualizarLibro/{id}" la URL que nos lleva a la vista "actualizarLibro"
    public String actualizarLibro(@PathVariable Long id, Model model) { // Model model es lo que le pasamos a la vista
                                                                        // un Modelo que será el libro
        Libro libro = libroService.findLibroById(id).get();
        model.addAttribute("libro", libro);
        return "/vistaActualizarLibro";
    }

    // creo un nuevo endpoint
    @PostMapping("/actualizarLibro")
    public String actualizarLibro(@RequestParam("idLibro") Long id, Libro libro) {
        libroService.updateLibro(id, libro);
        return "redirect:/";
    }

}
