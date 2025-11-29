package com.donacionesLt.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class DonacionDto {

    private int id;
    private String nombre; 
    private String apellido;
    private String correo;
    private int monto;
    private boolean pagado;




    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getMonto() {
        return this.monto;
    }

    public void setMonto(int monto) {
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

   


}
