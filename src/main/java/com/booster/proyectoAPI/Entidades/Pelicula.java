package com.booster.proyectoAPI.Entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "peliculas")
public class Pelicula {

    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotNull(message = "Name can't be null")
    @NotEmpty(message = "Name can't be empty")
    private String Nombre;

    private int Duracion;
    @NotNull( message = "Gender can't be null")
    @NotEmpty(message = "Gender can't be empty")
    private String Genero;

    //CONSTRUCTOR

    public Pelicula() {

    }

    public Pelicula(Long id, String nombre, int duracion, String genero) {
        Id = id;
        Nombre = nombre;
        Duracion = duracion;
        Genero = genero;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getDuracion() {
        return Duracion;
    }

    public void setDuracion(int duracion) {
        Duracion = duracion;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    //TO STRING
    @Override
    public String toString() {
        return "Pelicula{" +
                "Id=" + Id +
                ", Nombre='" + Nombre + '\'' +
                ", Duracion=" + Duracion +
                ", Genero='" + Genero + '\'' +
                '}';
    }
}
