package com.booster.proyectoAPI.Services;

import com.booster.proyectoAPI.Entidades.DTO.PeliculaDTO;
import com.booster.proyectoAPI.Entidades.Pelicula;
//import com.booster.proyectoAPI.Exceptions.NotFoundExceptionPersonal;
import com.booster.proyectoAPI.Repository.IPeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
@Service
public class PeliculaService implements IPeliculaService{
    @Autowired
    IPeliculaRepository iPeliculaRepository;

    @Override //Obtiene una lista de todas las peliculas
    public List<Pelicula> getPeliculas() {
        List<Pelicula> peliculas = new ArrayList<>();
        //Pelicula pelicula1 = new Pelicula(1L,"Rango",120,"Drama");
        //peliculas.add(pelicula1);
        peliculas = iPeliculaRepository.findAll();
        return peliculas;
    }

    /*@Override //Obtiene una pelicula por Id
    public Pelicula getPeliculaById(Long id) {
        Pelicula pelicula1 = new Pelicula();
        pelicula1 = iPeliculaRepository.findById(id).orElse(null);
        return pelicula1;
    }*/


    /*@Override //Obtiene una pelicula por Id
    public Pelicula getPeliculaById(Long id) throws NotFoundExceptionPersonal {
        Pelicula pelicula1 = new Pelicula();
        pelicula1 = iPeliculaRepository.findById(id).orElse(null);
        if (pelicula1 == null){
            throw new NotFoundExceptionPersonal("Movie by Id not found");
        }
        return pelicula1;
    }*/

    @Override //Obtiene una pelicula por Id
    public Pelicula getPeliculaById(Long id){
        Pelicula pelicula1 = new Pelicula();
        pelicula1 = iPeliculaRepository.findById(id).orElse(null);
        return pelicula1;
    }


    @Override //Inserta una pelicula a la BD
    public Pelicula insertPelicula(Pelicula pelicula) {
        return iPeliculaRepository.save(pelicula);
    }

    @Override //Borra una pelicula por Id
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

    @Override //Actualiza una pelicula por Id
    public PeliculaDTO updatePelicula(PeliculaDTO peliculaDTO) {
        Pelicula pelicula = iPeliculaRepository.findById(peliculaDTO.getId()).orElse(null);
        pelicula.setGenero(peliculaDTO.getGenero());
        pelicula.setDuracion(peliculaDTO.getDuracion());
        pelicula.setNombre(peliculaDTO.getNombre());
        iPeliculaRepository.save(pelicula);
        return peliculaDTO;
    }
}
