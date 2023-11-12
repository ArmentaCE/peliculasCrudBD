package com.booster.proyectoAPI;

import com.booster.proyectoAPI.Entidades.Pelicula;
import com.booster.proyectoAPI.Exceptions.NotFoundExceptionPersonal;
import com.booster.proyectoAPI.Repository.IPeliculaRepository;
import com.booster.proyectoAPI.Services.PeliculaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockReset;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class PeliculaServiceTest {
    @InjectMocks
    PeliculaService peliculaService;

    @Mock
    IPeliculaRepository iPeliculaRepository;

    Pelicula pelicula;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        Pelicula pelicula = new Pelicula(1l,"Rambo",120,"Accion");
    }

    @Test
    void testGetPeliculaById(){
        when(iPeliculaRepository.findById(1L)).thenReturn(Optional.ofNullable(pelicula));
        Pelicula peliculaActual = peliculaService.getPeliculaById(1L) ;
        assertEquals(pelicula, peliculaActual);
    }

    @Test
    void testGetAllPeliculas(){
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(pelicula);
        when(peliculaService.getPeliculas()).thenReturn(peliculas);
        assertNotNull(peliculaService.getPeliculas());
    }



}
