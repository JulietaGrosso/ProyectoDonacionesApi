package com.donacionesLt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donacionesLt.Services.InstitucionService;
import com.donacionesLt.entities.Institucion;

@RestController
@RequestMapping("institucion")
public class InstitucionController {

    @Autowired
    private InstitucionService institucionService;

    @GetMapping("inst")
    public ResponseEntity<?> getInstitucion(){
        List<Institucion>instituciones = institucionService.getInstituciones();
        return ResponseEntity.ok(instituciones);
        
    }

    






}