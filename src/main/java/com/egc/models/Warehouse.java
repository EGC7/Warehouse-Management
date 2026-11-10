package com.egc.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Warehouse implements ManageableStorage{

    private String name;
    private double maxStorageKg;
    private Address address;

    private ArrayList<Product> products = new ArrayList<>();

    public Warehouse(String name, Address addres, double maxStorageKg){
        setName(name);
        setMaxStorage(maxStorageKg);
        setAddress(addres);
    }

    public Warehouse(String name){
        setName(name);
    }
    
    public Warehouse(){}

    public String getName() {
        return name;
    }

    public double getMaxStorage() {
        return maxStorageKg;
    }

    public Address getAddress() {
        return address;
    }

    public List<Product> getProducts(){
        return Collections.unmodifiableList(products);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.trim().length() < 3 )
            throw new IllegalArgumentException("O nome do armazem deve ter pelo menos 3 Caracteres.");
        this.name = name;
    }

    public void setMaxStorage(double maxStorageKg) {
        if (maxStorageKg < 0)
            throw new IllegalArgumentException("A capacidade do armazem máxima deve ser maior que 0.");
        this.maxStorageKg = maxStorageKg;
    }

    public void setAddress(Address address) {
        if (address == null || address.isValid() )
            throw new IllegalArgumentException("O endereço deve ser válido.");
        this.address = address;
    }

    public double getActualStorage(){ return calcListWeight(products); }

    @Override
    public void addProduct(Product product){
        if (product == null)
            throw new IllegalArgumentException("O produto não estar ser vazio.");

        if ( (getActualStorage() + (product.getWeight() * product.getAmountStorage()) ) > this.maxStorageKg)
            throw new MaxSizeException();
            // throw new MaxSizeException("AIIAIAIAAI NÃO AGUENTO");

        products.add(product);
        product.setId(products.size());

    }

    private double calcListWeight(List<Product> pds){
        double tot = 0;

        for (Product p : pds){
            if (p != null)
                tot += (p.getWeight() * p.getAmountStorage());
        }

        return tot;
    }

    @Override
    public void updateProductList(List<Product> productList) {
        
        if (productList == null){
            products = new ArrayList<>();
            return;
        }

        if (productList.contains(null))
            throw new IllegalArgumentException("A lista contém pelo menos um produto vazio.");

        if ( calcListWeight(productList) > this.maxStorageKg)
            throw new MaxSizeException();

        products = new ArrayList<>(productList);
        
        updateProductList();
    }

    @Override
    public void updateProductList() {

        if (products == null) return;

        for (int p = 0; p < products.size(); p++){  
            this.products.get(p).setId(p+1);
        }
    }

    @Override
    public boolean removeProductById(int id) {
        return products.removeIf(prod -> prod.getId() == id);
    }

    @Override
    public boolean removeProductByName(String name) {
        return products.removeIf(prod -> prod.getName() == name);
    }

    @Override
    public Product searchProductById(int id) {
        for (Product p : products){
            if (p.getId() == id) return p;
        }
        return null;
    }
    
    @Override
    public Product searchProductByName(String name) {
        for (Product p : products){
            if (p.getName() == name) return p;
        }
        return null;
    }

    @Override 
    public String toString(){
        return "--------- " + name + " ---------\n" +
        "> Capacidade Máxima (Kg): " + maxStorageKg + 
        "\n> Endereço: " + address.toString(); 
    }

    public void showDetails(){
        System.out.println(toString());
    }

}