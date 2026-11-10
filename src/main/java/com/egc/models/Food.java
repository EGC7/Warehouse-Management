package com.egc.models;

public class Food extends PerishableProduct{

    private String category;
    private boolean isOrganic;
    
    @Override
    public double calculateHandlingFee() {
        return getPrice()*.02;
    }
    
    public Food(){}
    
    public Food(String name, String description, double price, double weight,
            int amountStorage, int minStorage, int splitTime,
            String category, boolean isOrganic) {
        
        super(name, description, price, weight, amountStorage, minStorage, splitTime);
        
        setCategory(category);
        setOrganic(isOrganic);

    }
    
    public Food(String name, double price, double weight, int amountStorage, int minStorage, int splitTime,
            String category, boolean isOrganic) {
                
        super(name, price, weight, amountStorage, minStorage, splitTime);
        
        setCategory(category);
        setOrganic(isOrganic);
    }

    public String getCategory() {
        return category;
    }
    public boolean isOrganic() {
        return isOrganic;
    }
    
    public void setCategory(String category) {
        if (category == null || category.trim().isEmpty() || category.trim().length() < 5 )
            throw new IllegalArgumentException("A categoria do alimento deve ter pelo menos 5 Caracteres.");
        this.category = category;
    }
    public void setOrganic(boolean isOrganic) {
        this.isOrganic = isOrganic;
    }

    @Override
    public String toString(){
        return super.toString() + "\nCategoria: " + category + " | Orgânico: " + (isOrganic ? "Sim" : "Não");
        
    }

    
}