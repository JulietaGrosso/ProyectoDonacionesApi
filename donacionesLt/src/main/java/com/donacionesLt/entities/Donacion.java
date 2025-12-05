package com.donacionesLt.entities;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="donacion")
public class Donacion {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(name = "nombre")
private String nombre; 
@Column(name = "apellido")
private String apellido;
@Column(name = "correo")
private String correo;
@Column(name = "monto")
private int monto;
@Column(name = "pagado")
private boolean pagado;
@Column(name = "uuid")
private String uuid;
@Column(name = "fecha")
private Date fechaPago;

public Donacion(){

}

public Donacion(int id, String nombre, String apellido, String correo, int monto, boolean pagado){
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.correo = correo;
    this.monto = monto;
    this.pagado = pagado;
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

    public boolean isPagado() {
        return this.pagado;
    }

    public boolean getPagado() {
        return this.pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


    public Date getFechaPago() {
        return this.fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }




}
