package com.egc.models;

import java.util.List;

public interface ManageableStorage {
    
    public void addProduct(Product product);
    
    public void updateProductList(List<Product> productList);
    public void updateProductList();
    
    public boolean removeProductByName(String name);
    public boolean removeProductById(int id);
    
    public boolean buyProductByName(String name);
    public boolean buyProductById(int id);

    public Product searchProductByName(String name);
    public Product searchProductById(int id);
}
