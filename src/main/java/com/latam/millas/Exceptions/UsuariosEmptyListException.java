package com.latam.millas.Exceptions;

public class UsuariosEmptyListException extends Exception {

    public UsuariosEmptyListException(){

    }

    public UsuariosEmptyListException(String msg){
        super(msg);
    }
}
