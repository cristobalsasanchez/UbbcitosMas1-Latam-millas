package com.latam.millas.Exceptions;

public class VueloAlreadyExistException extends Exception {

    public VueloAlreadyExistException(){

    }

    public VueloAlreadyExistException(String msg){
        super(msg);
    }
}
