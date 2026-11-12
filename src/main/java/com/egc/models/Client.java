package com.egc.models;

import java.util.HashMap;
import java.util.Map;

public class Client extends User {
    // ArrayList<Product> carShop = new ArrayList<>();
    HashMap<String, Integer> carShop = new HashMap<String, Integer>();

    public Client() {
        this("client@gmail.com", "client", "Client");
    }

    public Client(String name, String email, String password) {
        super(name, email, password, "Client");
    }

    public Client(String email, String password) {
        super(email, password, "Client");
    }

    // public List<Product> getCarShop(){
    //     return Collections.unmodifiableList(carShop);
    // }


    public Map<String, Integer> getCarShop(){
        return carShop;
    }

    public void addToCarShop(Product product, Warehouse warehouse){
        if (product == null)
            throw new IllegalArgumentException("O produto não pode ser vazio.");

        if (warehouse == null)
            throw new IllegalArgumentException("O armazém não pode ser vazio.");

        // if (carShop.contains(product)){
        //     if ((warehouse.searchProductByName(product.getName()).getAmountStorage()  ) > 0) {
        //         //! MDS Travei na verificação pq tem q ver se ele ainda pode apertar pra adicionar. Então é verificar se a quantidadeEmEstoque - oQueEuQuero > 0. Tlgd??
        //     }            
        // }

        if (carShop.containsKey(product.getName())){
            if (warehouse.searchProductByName(product.getName()).getAmountStorage() - carShop.get(product.getName()) > 0) {
                carShop.put(product.getName(), carShop.get(product.getName()) + 1);       
            }
        }
    }
    
}
