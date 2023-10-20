package com.booster.proyectoAPI.Services;

import com.booster.proyectoAPI.Entidades.Pelicula;

import java.util.List;

public interface IPeliculaService {
    List<Pelicula> getPeliculas();

    Pelicula getPeliculaById(Long id);

    Pelicula insertPelicula(Pelicula pelicula);
}
