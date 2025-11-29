package com.donacionesLt.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donacionesLt.Repositorios.DonacionRepositorio;
import com.donacionesLt.controllers.DonacionController;
import com.donacionesLt.dtos.DonacionDto;
import com.donacionesLt.entities.Donacion;

@Service
public class DonacionService {

    @Autowired
    private DonacionRepositorio donacionRepositorio;

    public Donacion guardarDonacion(DonacionDto donacionDto){
        Donacion donacion = new Donacion();
        donacion.setNombre(donacionDto.getNombre());
        donacion.setApellido(donacionDto.getApellido());
        donacion.setCorreo(donacionDto.getCorreo());
        donacion.setMonto(donacionDto.getMonto());
        donacion.setPagado(donacionDto.getPagado());
        return donacionRepositorio.save(donacion);

    }
}
