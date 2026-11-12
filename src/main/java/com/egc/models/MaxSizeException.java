package com.egc.models;

public class MaxSizeException extends RuntimeException{
    public MaxSizeException(String ms){
        super(ms);
    }
    public MaxSizeException(double maxSize, double actStorage){
        this("Capacidade Máxima Excedida.\n[ Capacidade Atual: " + actStorage + " / " + maxSize + " ]");
    }
}