package com.example.biblioteca_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.biblioteca_application.service.LibroService;

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

}
