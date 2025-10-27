package com.donacionesLt.entities;

public class Formulario {
private int id;
private String nombre; 
private String apellido;
private String correo;
private int monto;

public Formulario(){

}

public Formulario(int id, String nombre, String apellido, String correo, int monto){
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.correo = correo;
    this.monto = monto;
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
public String getApellido(){
    return apellido;
}
public void setApellido(String apellido){
    this.apellido = apellido;
}
public String getCorreo(){
    return correo;
}
public void setCorreo(String correo){
    this.correo = correo;
}
public int getMonto(){
    return monto;
}
public void setMonto(int monto){
    this.monto = monto;
}

}
