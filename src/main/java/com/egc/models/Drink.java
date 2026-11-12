package com.egc.models;

public class Drink extends PerishableProduct implements Fragile{
    private double volume, storageTemp;
    private boolean isAlcoholic;
    
    @Override
    public double calculateHandlingFee(int amount) {
        return getPrice()*.03 * amount;
    }

    @Override
    public double getSpecialPackFee(int amount) {
        return 4 * amount;
    }

    @Override
    public String getInstruction() {
        return "Beba. rsrsrs";
    }
    
    public Drink(){}

    public Drink(String name, String description, double price, double weight, int amountStorage, int minStorage,
            int splitTime, double volume, double storageTemp, boolean isAlcoholic) {
        
        super(name, description, price, weight, amountStorage, minStorage, splitTime);
        
        setVolume(volume);
        setStorageTemp(storageTemp);
        setAlcoholic(isAlcoholic);
    }

    public Drink(String name, double price, double weight, int amountStorage, int minStorage, int splitTime,
        double volume, double storageTemp, boolean isAlcoholic) {
     
        super(name, price, weight, amountStorage, minStorage, splitTime);
        
        setVolume(volume);
        setStorageTemp(storageTemp);
        setAlcoholic(isAlcoholic);
    }

    public double getVolume() {
        return volume;
    }

    public double getStorageTemp() {
        return storageTemp;
    }

    public boolean isAlcoholic() {
        return isAlcoholic;
    }

    public void setVolume(double volume) {
        if (volume < 0)
            throw new IllegalArgumentException("O volume da bebida não pode ser menor que 0.");
        this.volume = volume;
    }

    public void setStorageTemp(double storageTemp) {
        this.storageTemp = storageTemp;
    }

    public void setAlcoholic(boolean isAlcoholic) {
        this.isAlcoholic = isAlcoholic;
    }

    
    
}