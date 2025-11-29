package com.donacionesLt.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donacionesLt.Services.AdministradorService;
import com.donacionesLt.entities.Administrador;

@RestController
@RequestMapping("admin")
public class AdministradorController{

  private AdministradorService administradorService;

  @GetMapping("login")
  public String helloController(){
    return "hola";
  }

  private List<Administrador> listaDonaciones = new ArrayList<Administrador>(); 


}
