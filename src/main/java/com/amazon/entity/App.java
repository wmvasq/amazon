package com.amazon.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "apps")
public class App {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nombre;
  private int categoria;
  private String dev;
  private int calificacion;
  private double precio;
  private String imagen;
  private String url;
  private boolean instalado;
  private String descripcion;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "appid")
  private List<Comentario> comentarios = new ArrayList<>();

  public App() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getCategoria() {
    return categoria;
  }

  public void setCategoria(int categoria) {
    this.categoria = categoria;
  }

  public String getDev() {
    return dev;
  }

  public void setDev(String dev) {
    this.dev = dev;
  }

  public int getCalificacion() {
    return calificacion;
  }

  public void setCalificacion(int calificacion) {
    this.calificacion = calificacion;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public String getImagen() {
    return imagen;
  }

  public void setImagen(String imagen) {
    this.imagen = imagen;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public boolean isInstalado() {
    return instalado;
  }

  public void setInstalado(boolean instalado) {
    this.instalado = instalado;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public List<Comentario> getComentarios() {
    return comentarios;
  }

  public void setComentarios(List<Comentario> comentarios) {
    this.comentarios = comentarios;
  }
}
