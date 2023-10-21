package com.booster.proyectoAPI.controller;

import com.booster.proyectoAPI.Entidades.DTO.PeliculaDTO;
import com.booster.proyectoAPI.Entidades.Pelicula;
import com.booster.proyectoAPI.Services.IPeliculaService;
import com.booster.proyectoAPI.Services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/peliculas/v0")
public class PeliculaController {

    @Autowired
    IPeliculaService PeliculaService;
    @GetMapping("/pelicula")
    public List<Pelicula> getPeliculas(){
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas = PeliculaService.getPeliculas();
        return peliculas;
    }

    @GetMapping("/pelicula/{id}")
    public Pelicula getPeliculaById(@PathVariable Long id){
        return PeliculaService.getPeliculaById(id);
    }

    @PostMapping("/pelicula")
    public Pelicula insertPelicula(@RequestBody Pelicula pelicula){
        return PeliculaService.insertPelicula(pelicula);
    }

    @DeleteMapping("/pelicula/{id}")
    public PeliculaDTO deletePelicula(@PathVariable Long id){
        return PeliculaService.deletePelicula(id);
    }

    @PutMapping("/pelicula")
    public PeliculaDTO updatePelicula(@RequestBody PeliculaDTO peliculaDTO){
        return PeliculaService.updatePelicula(peliculaDTO);
    }

}
