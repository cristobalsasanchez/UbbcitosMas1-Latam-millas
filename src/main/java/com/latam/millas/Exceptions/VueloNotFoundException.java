package com.latam.millas.Exceptions;

public class VueloNotFoundException extends Exception {

    public VueloNotFoundException(){
    }

    public VueloNotFoundException(String msg){
        super(msg);
    }
}
