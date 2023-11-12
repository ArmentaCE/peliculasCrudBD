package com.booster.proyectoAPI.controller;

import com.booster.proyectoAPI.Entidades.DTO.PeliculaDTO;
import com.booster.proyectoAPI.Entidades.Pelicula;
import com.booster.proyectoAPI.Exceptions.EmptyErrorException;
import com.booster.proyectoAPI.Exceptions.NotFoudErrorException;
import com.booster.proyectoAPI.Services.IPeliculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/peliculas/v0")
public class PeliculaController {

    @Autowired
    IPeliculaService PeliculaService;

    //Método para obtener el listado de todas las peliculas sin el manejo de excepciones
    /*@GetMapping("/pelicula")
    public List<Pelicula> getPeliculas(){
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas = PeliculaService.getPeliculas();
        return peliculas;
    }*/

    @GetMapping("/pelicula")
    public List<Pelicula> getPeliculas(){
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas = PeliculaService.getPeliculas();
        /*if (peliculas.size() == 0){
            System.out.println("Empty");
        }*/
        return peliculas;
    }

    //Método que busca una pélicula por id que funciona sin el manejo de excepciones
    /*@GetMapping("/pelicula/{id}")
    public Pelicula getPeliculaById(@PathVariable Long id){
        return PeliculaService.getPeliculaById(id);
    }*/

    //Método que busca una pélicula por id que funciona con el manejo de excepciones
    @GetMapping("/pelicula/{id}")
    public Pelicula getPeliculaById(@PathVariable Long id){
        if (PeliculaService.getPeliculaById(id) == null){
            throw new NotFoudErrorException("Movie by id not found","Error-456",HttpStatus.NOT_FOUND);
        }
        return PeliculaService.getPeliculaById(id);
    }

    //Método para agreagar una pelicua que funciona sin el manejo de excepciones
    /*@PostMapping("/pelicula")
    public Pelicula insertPelicula(@RequestBody Pelicula pelicula){
        return PeliculaService.insertPelicula(pelicula);
    }*/

    //Método para agreagar una pelicua que funciona con el manejo de excepciones
    @PostMapping("/pelicula")
    public Pelicula insertPelicula(@Valid @RequestBody Pelicula pelicula, BindingResult result){
        if (result.hasErrors()) {
            throw new EmptyErrorException("List of validations errors to insert a new movie","Error-123", HttpStatus.BAD_REQUEST, result);
        }
        return PeliculaService.insertPelicula(pelicula);
    }

    //Método que elimina una pelicua que funciona sin el manejo de excepciones
    /*@DeleteMapping("/pelicula/{id}")
    public PeliculaDTO deletePelicula(@PathVariable Long id){
        return PeliculaService.deletePelicula(id);
    }*/

    //Método que elimina una pelicua que funciona con el manejo de excepciones
    @DeleteMapping("/pelicula/{id}")
    public PeliculaDTO deletePelicula(@PathVariable Long id){
        if (PeliculaService.getPeliculaById(id) == null) {
            throw new NotFoudErrorException("Movie id not found to delete","Error-456",HttpStatus.NOT_FOUND);
        }
        return PeliculaService.deletePelicula(id);
    }

    //Método que actualiza una pelicula, funcina sin el manejo de excepciones
    /*@PutMapping("/pelicula")
    public PeliculaDTO updatePelicula(@RequestBody PeliculaDTO peliculaDTO){
        return PeliculaService.updatePelicula(peliculaDTO);
    }*/

    //Método que actualiza una pelicula, funcina sin el manejo de excepciones
    @PutMapping("/pelicula")
    public PeliculaDTO updatePelicula(@Valid @RequestBody PeliculaDTO peliculaDTO, BindingResult result){
        if (result.hasErrors()){
            throw new EmptyErrorException("List of validations errors to update a movie","Error-123", HttpStatus.BAD_REQUEST, result);
        }
        return PeliculaService.updatePelicula(peliculaDTO);
    }

}
