package com.amazon.controller;

import com.amazon.entity.App;
import com.amazon.entity.Categoria;
import com.amazon.repository.AppRepository;
import com.amazon.repository.CategoriaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
  public List<Categoria> getCategorias() {
    return categoriaRepository.findAll();
  }

  @GetMapping("/apps")
  public List<App> getApps(@RequestParam(required = false) Long categoria) {
    if (categoria != null) return appRepository.findByCategoria(
      categoria.intValue()
    );
    //todas las apps
    return appRepository.findAll();
  }

  @PutMapping("/apps/{id}/calificacion")
  public ResponseEntity<String> updateAppCalificacion(
    @PathVariable Long id,
    @RequestParam(required = false, defaultValue = "0") int calificacion
  ) {
    if (calificacion < 1 || calificacion > 5) return ResponseEntity
      .badRequest()
      .body("La calificación debe ser un numero entre 1 y 5 ");

    Optional<App> optionalApp = appRepository.findById(id);

    if (optionalApp.isPresent()) {
      App app = optionalApp.get();
      app.setCalificacion(calificacion);
      appRepository.save(app);
      return ResponseEntity.ok("Calificación actualizada exitosamente.");
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
