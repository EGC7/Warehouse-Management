package com.egc.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class PerishableProduct extends Product { // TODO: Adicionar forma de destacar verificando validade. [RN04] 

    private LocalDate expirationDate;
    private double storageTemp;

    public PerishableProduct() {}

    public PerishableProduct(String name, String description, double price, double weight, int amountStorage,
            int minStorage, int splitTime) {
        super(name, description, price, weight, amountStorage, minStorage, splitTime);

        setExpirationDate(expirationDate);
        setStorageTemp(storageTemp);
    }

    public PerishableProduct(String name, double price, double weight, int amountStorage, int minStorage,
            int splitTime) {
        super(name, price, weight, amountStorage, minStorage, splitTime);

        setExpirationDate(expirationDate);
        setStorageTemp(storageTemp);

    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public double getStorageTemp() {
        return storageTemp;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        if (expirationDate == null || expirationDate.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("A data de validade do produto deve ser hoje, ou no futuro.");

        this.expirationDate = expirationDate;
    }

    public void setStorageTemp(double storageTemp) {
        this.storageTemp = storageTemp;
    }

    public void replenish(int amount, LocalDate newDate) {
        super.replenish(amount);

        setExpirationDate(newDate);
    }

    @Override
    public String toString() {
        return super.toString() +
        "\n > Data de Validade: " + expirationDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
        "\n > Temperatura de Armazenamento: " + storageTemp;
    }

}
