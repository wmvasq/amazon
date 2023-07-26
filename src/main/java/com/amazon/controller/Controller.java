package com.amazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.entity.Categoria;
import com.amazon.repository.CategoriaRepository;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class Controller {


    @GetMapping("/saludo")
    public String saludo(){
        return "hola mundo";
    }
        @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/categorias")
    public List<Categoria> getUsers() {
        return categoriaRepository.findAll();
    }
}
