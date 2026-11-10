package com.egc.models;

public class MaxSizeException extends RuntimeException{
    public MaxSizeException(String ms){
        super(ms);
    }
    public MaxSizeException(){
        super("Capacidade Máxima Excedida.");
    }
}