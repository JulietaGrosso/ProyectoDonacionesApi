package com.donacionesLt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donacionesLt.Services.DonacionService;
import com.donacionesLt.dtos.DonacionDto;
import com.donacionesLt.entities.LinkPago;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;

@RestController
@RequestMapping("donacion")
public class DonacionController {

    @Autowired
    private DonacionService donacionService;

    @PostMapping
    public ResponseEntity<LinkPago> postDonacion(@RequestBody DonacionDto donaciondto) throws MPException, MPApiException{
        
        String link = donacionService.guardarDonacion(donaciondto);
        LinkPago linkPago = new LinkPago(link);
        return ResponseEntity.ok().body(linkPago);
    }


}
