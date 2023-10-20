package com.booster.proyectoAPI.Services;

import com.booster.proyectoAPI.Entidades.Pelicula;
import com.booster.proyectoAPI.Repository.IPeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
@Service
public class PeliculaService implements IPeliculaService{
    @Autowired
    IPeliculaRepository iPeliculaRepository;

    @Override
    @GetMapping("/pelicula")
    public List<Pelicula> getPeliculas() {
        List<Pelicula> peliculas = new ArrayList<>();
        //Pelicula pelicula1 = new Pelicula(1L,"Rango",120,"Drama");
        //peliculas.add(pelicula1);
        peliculas = iPeliculaRepository.findAll();
        return peliculas;
    }

    @Override
    @GetMapping("/pelicula/{id}")
    public Pelicula getPeliculaById(Long id) {
        Pelicula pelicula1 = new Pelicula();
        pelicula1 = iPeliculaRepository.findById(id).orElse(null);
        return pelicula1;
    }

    @Override
    @PostMapping("/pelicula")
    public Pelicula insertPelicula(Pelicula pelicula) {
        return iPeliculaRepository.save(pelicula);
    }


}
