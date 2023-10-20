package com.booster.proyectoAPI.Repository;

import com.booster.proyectoAPI.Entidades.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPeliculaRepository extends JpaRepository<Pelicula, Long> {

}
