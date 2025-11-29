package com.donacionesLt.Repositorios;


import org.springframework.data.jpa.repository.JpaRepository;

import com.donacionesLt.entities.Donacion;

public interface DonacionRepositorio extends JpaRepository<Donacion,Integer>{

}
