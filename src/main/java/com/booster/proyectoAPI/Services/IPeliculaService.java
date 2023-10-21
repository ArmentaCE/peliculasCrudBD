package com.booster.proyectoAPI.Services;

import com.booster.proyectoAPI.Entidades.DTO.PeliculaDTO;
import com.booster.proyectoAPI.Entidades.Pelicula;
import org.apache.juli.logging.Log;

import java.util.List;

public interface IPeliculaService {
    List<Pelicula> getPeliculas();

    Pelicula getPeliculaById(Long id);

    Pelicula insertPelicula(Pelicula pelicula);

    PeliculaDTO deletePelicula(Long id);

    PeliculaDTO updatePelicula(PeliculaDTO peliculaDTO);

}
