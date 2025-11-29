package com.donacionesLt.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="institucion")
public class Institucion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "private_token")
    private String privateToken;
    @Column(name = "public_token")
    private String publicToken;


    public Institucion() {
    }
    
    public Institucion(int id, String nombre, String imagen, String privateToken, String publicToken){
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.privateToken = privateToken;
        this.publicToken = publicToken;
    }
    
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

    public String getImagen() {
        return this.imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getPrivateToken() {
        return this.privateToken;
    }

    public void setPrivateToken(String privateToken) {
        this.privateToken = privateToken;
    }

    public String getPublicToken() {
        return this.publicToken;
    }

    public void setPublicToken(String publicToken) {
        this.publicToken = publicToken;
    }




}

