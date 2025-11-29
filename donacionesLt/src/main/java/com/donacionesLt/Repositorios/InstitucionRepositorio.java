package com.donacionesLt.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.donacionesLt.entities.Institucion;


@Repository
public interface InstitucionRepositorio extends JpaRepository<Institucion,Integer>{


}
