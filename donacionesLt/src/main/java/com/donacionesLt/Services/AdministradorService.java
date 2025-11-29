package com.donacionesLt.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donacionesLt.Repositorios.AdministradorRepositorio;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepositorio administradorRepositorio; 

    
}
