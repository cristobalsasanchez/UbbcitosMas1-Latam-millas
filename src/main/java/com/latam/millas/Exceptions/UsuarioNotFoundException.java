package com.latam.millas.Exceptions;

public class UsuarioNotFoundException extends Exception {

    public UsuarioNotFoundException(){

    }

    public UsuarioNotFoundException(String msg){
        super(msg);
    }
}
