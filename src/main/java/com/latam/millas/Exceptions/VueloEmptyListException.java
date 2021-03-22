package com.latam.millas.Exceptions;

public class VueloEmptyListException extends Exception {

    public VueloEmptyListException(){

    }

    public VueloEmptyListException(String msg){
        super(msg);
    }
}
