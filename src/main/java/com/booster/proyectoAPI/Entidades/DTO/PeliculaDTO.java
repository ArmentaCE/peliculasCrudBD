package com.booster.proyectoAPI.Entidades.DTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class PeliculaDTO implements Serializable {
    private Long Id;
    @NotNull(message = "Name can't be null")
    @NotEmpty(message = "Name can't be empty")
    private String Nombre;
    private int Duracion;
    @NotNull( message = "Gender can't be null")
    @NotEmpty(message = "Gender can't be empty")
    private String Genero;

    public PeliculaDTO() {

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
}
