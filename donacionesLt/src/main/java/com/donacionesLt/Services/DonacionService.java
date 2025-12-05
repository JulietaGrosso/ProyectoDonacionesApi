package com.donacionesLt.Services;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donacionesLt.Repositorios.DonacionRepositorio;
import com.donacionesLt.dtos.DonacionDto;
import com.donacionesLt.entities.Donacion;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;

@Service
public class DonacionService {

    @Autowired
    private DonacionRepositorio donacionRepositorio;

    @Autowired
    private MercadoPagoService mercadoPagoService;

    public String guardarDonacion(DonacionDto donacionDto) throws MPException, MPApiException{
        Donacion donacion = new Donacion();
        donacion.setNombre(donacionDto.getNombre());
        donacion.setApellido(donacionDto.getApellido());
        donacion.setCorreo(donacionDto.getCorreo());
        donacion.setMonto(donacionDto.getMonto());
        donacion.setPagado(donacionDto.getPagado());

        UUID uuid = UUID.randomUUID();
        donacion.setUuid(uuid.toString());
        String linkDePago = mercadoPagoService.generatePaymentUrl(uuid.toString(), donacion.getMonto(), donacionDto.getIdInstitucion());

        return linkDePago;

    }
}
