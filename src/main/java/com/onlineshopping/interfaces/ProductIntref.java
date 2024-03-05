package main.java.com.onlineshopping.interfaces;

import main.java.com.onlineshopping.model.Products;

import java.util.List;

public interface ProductIntref {
    public Products findProduct(String prod_name, List<Products> productList);

    public Products findProductById(String prod_name, List<Products> productList);

    public void deleteProduct(String productId, List<Products> productList);

    public void updateProducts(Products product, float new_price, int new_quantity);

    public void addProducts(Products product, List<Products> productList);
}
