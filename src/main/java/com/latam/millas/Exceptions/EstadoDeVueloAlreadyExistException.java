package com.latam.millas.Exceptions;

public class EstadoDeVueloAlreadyExistException extends Exception {

    public EstadoDeVueloAlreadyExistException() {
    }

    public EstadoDeVueloAlreadyExistException(String msg){
        super(msg);
    }
}
