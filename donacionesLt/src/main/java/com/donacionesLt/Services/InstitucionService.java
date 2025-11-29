package com.donacionesLt.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donacionesLt.Repositorios.InstitucionRepositorio;
import com.donacionesLt.entities.Institucion;



@Service
public class InstitucionService {

    @Autowired
    private InstitucionRepositorio institucionRepositorio;

    public List<Institucion>getInstituciones(){
        return institucionRepositorio.findAll();
    }
        




}
