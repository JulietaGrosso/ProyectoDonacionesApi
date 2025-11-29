package com.donacionesLt.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="administrador")
public class Administrador {
@Id   
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(name = "nombre")
private String nombre;
@Column(name = "correo")
private String correo;
@Column(name = "contrasena")
private String contrasena; 

public Administrador(){

}
public Administrador(int id, String nombre, String correo, String contrasena){
    this.id = id; 
    this.nombre = nombre;
    this.correo = correo;
    this.contrasena = contrasena;
}

public int getId(){
    return id;
}
public void setId(int id){
    this.id = id;
}
public String getNombre(){
    return nombre;
}
public void setNombre(String nombre){
    this.nombre = nombre;
}
public String getCorreo(){
    return correo;
}
public void setCorreo(String correo){
    this.correo = correo;
}
public String getContrasena(){
    return contrasena;
}
public void setContrasena(String contrasena){
    this.contrasena = contrasena;
}


//En este caso el administrador puede ver los registros de las donaciones.
//Get: para obtener la lista. 


}
