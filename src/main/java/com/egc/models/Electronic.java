package com.egc.models;

public class Electronic extends Product implements Fragile{
    private double voltage;
    private int guarantee;
    
    @Override
    public double calculateHandlingFee(int amount) {
        return getPrice()*.05 * amount;
    }

    @Override
    public double getSpecialPackFee(int amount) {
        return 4.0 * amount;
    }

    @Override
    public String getInstruction() {
        return "Liga, usa, desliga, eba eba.";
    }

    public Electronic(){}

    public Electronic(String name, String description, double price, double weight, int amountStorage, int minStorage,
            int splitTime, double voltage, int guarantee) {
        super(name, description, price, weight, amountStorage, minStorage, splitTime);
        
        setVoltage(voltage);
        setGuarantee(guarantee);
    }

    
    
    public Electronic(String name, double price, double weight, int amountStorage, int minStorage,
            int splitTime, double voltage, int guarantee) {
        super(name, price, weight, amountStorage, minStorage, splitTime);
        
        setVoltage(voltage);
        setGuarantee(guarantee);
    }

    public double getVoltage() {
        return voltage;
    }
    public int getGuarantee() {
        return guarantee;
    }
    
    public void setVoltage(double voltage) {
        if (voltage != 110 && voltage != 220)
            throw new IllegalArgumentException("A voltagem do eletrônico deve ser 110 ou 220 volts.");
        this.voltage = voltage;
    }
    public void setGuarantee(int guarantee) {
        if (guarantee >= 0 && guarantee <= 60)
            throw new IllegalArgumentException("A quantidade de meses de garantia do eletrônico deve estar entre 0 e 60 meses.");
        this.guarantee = guarantee;
    }
}