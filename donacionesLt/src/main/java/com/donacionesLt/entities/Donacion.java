package com.donacionesLt.entities;

public class Donacion {
private int id; 
private int monto; 

public Donacion(){

}
public Donacion(int id, int monto){
    this.id = id;
    this.monto = monto;
}

public int getId(){
    return id;
}
public void setId(int id){
    this.id = id;
}

public int getMonto(){
    return monto;
}

public void setMonto(int monto){
    this.monto = monto;
}



}




