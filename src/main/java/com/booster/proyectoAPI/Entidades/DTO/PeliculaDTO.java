package com.booster.proyectoAPI.Entidades.DTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PeliculaDTO implements Serializable {
    private Long Id;
    private String Nombre;
    private int Duracion;
    private String Genero;

    public PeliculaDTO() {

    }
}
