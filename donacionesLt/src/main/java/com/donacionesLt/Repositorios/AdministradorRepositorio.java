package com.donacionesLt.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.donacionesLt.entities.Administrador;

@Repository
public interface AdministradorRepositorio extends JpaRepository<Administrador,Integer>{
        
}
