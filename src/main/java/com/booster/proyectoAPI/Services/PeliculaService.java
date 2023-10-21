package com.booster.proyectoAPI.Services;

import com.booster.proyectoAPI.Entidades.DTO.PeliculaDTO;
import com.booster.proyectoAPI.Entidades.Pelicula;
import com.booster.proyectoAPI.Repository.IPeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;
@Service
public class PeliculaService implements IPeliculaService{
    @Autowired
    IPeliculaRepository iPeliculaRepository;

    @Override //Obtiene una lista de todas las peliculas
    @GetMapping("/pelicula")
    public List<Pelicula> getPeliculas() {
        List<Pelicula> peliculas = new ArrayList<>();
        //Pelicula pelicula1 = new Pelicula(1L,"Rango",120,"Drama");
        //peliculas.add(pelicula1);
        peliculas = iPeliculaRepository.findAll();
        return peliculas;
    }

    @Override //Obtiene una pelicula por Id
    @GetMapping("/pelicula/{id}")
    public Pelicula getPeliculaById(Long id) {
        Pelicula pelicula1 = new Pelicula();
        pelicula1 = iPeliculaRepository.findById(id).orElse(null);
        return pelicula1;
    }

    @Override //Inserta una pelicula a la BD
    @PostMapping("/pelicula")
    public Pelicula insertPelicula(Pelicula pelicula) {
        return iPeliculaRepository.save(pelicula);
    }

    @Override
    @DeleteMapping("/pelicula/{id}")
    public PeliculaDTO deletePelicula(Long id) {
        Pelicula pelicula = iPeliculaRepository.findById(id).orElse(null);
        PeliculaDTO peliculaDTO = new PeliculaDTO();
        peliculaDTO.setId(pelicula.getId());
        peliculaDTO.setNombre(pelicula.getNombre());
        peliculaDTO.setGenero(pelicula.getGenero());
        peliculaDTO.setDuracion(pelicula.getDuracion());

        iPeliculaRepository.delete(pelicula);
        return peliculaDTO;
    }

    @Override
    @PutMapping("/pelicula")
    public PeliculaDTO updatePelicula(PeliculaDTO peliculaDTO) {
        Pelicula pelicula = iPeliculaRepository.findById(peliculaDTO.getId()).orElse(null);
        pelicula.setGenero(peliculaDTO.getGenero());
        pelicula.setDuracion(peliculaDTO.getDuracion());
        pelicula.setNombre(peliculaDTO.getNombre());

        iPeliculaRepository.save(pelicula);
        return peliculaDTO;
    }


}
