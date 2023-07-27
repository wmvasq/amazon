package com.amazon.controller;

import com.amazon.entity.App;
import com.amazon.entity.Categoria;
import com.amazon.repository.AppRepository;
import com.amazon.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class Controller {

  @GetMapping("/saludo")
  public String saludo() {
    return "hola mundo";
  }

  @Autowired
  private CategoriaRepository categoriaRepository;

  @Autowired
  private AppRepository appRepository;

  @GetMapping("/categorias")
  public List<Categoria> getUsers() {
    return categoriaRepository.findAll();
  }

  @GetMapping("/apps")
  public List<App> getApps(@RequestParam(required = false) Long categoria) {
    if(categoria!=null)
    return appRepository.findByCategoria(categoria.intValue());
    //todas las apps
    return appRepository.findAll();
  }
}
