package com.booster.proyectoAPI.Entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "peliculas")
@Getter
@Setter
public class Pelicula {

    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Nombre;
    private int Duracion;
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
