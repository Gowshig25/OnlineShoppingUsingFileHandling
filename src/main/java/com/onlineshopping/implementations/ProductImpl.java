package main.java.com.onlineshopping.implementations;

import main.java.com.onlineshopping.customexception.DuplicateProductExpection;
import main.java.com.onlineshopping.interfaces.ProductIntref;
import main.java.com.onlineshopping.model.Products;
import main.java.com.onlineshopping.utils.Constants;

import java.util.List;

import static main.java.com.onlineshopping.utils.CommonUtils.ifNullExist;
import static main.java.com.onlineshopping.utils.Constants.*;

public class ProductImpl implements ProductIntref {
    // Function to add Products with the parameter of new Products object and the excited List object
    @Override
    public void addProducts(Products product, List<Products> productList) throws DuplicateProductExpection {
        if (ifNullExist(product, productList)) {
            Products temp = findProduct(product.getP_name(), productList);
            if (temp == null) {
                productList.add(product);
                System.out.println(ADDED_PRODUCT);
            } else {
                throw new DuplicateProductExpection(EXIST_PRODUCT);
            }
        } else {
            System.out.println(INAPPROPRIATE_PRODUCT);
        }
    }
// Function to find the given Product name is present in the List
    @Override
    public Products findProduct(String prod_name, List<Products> productList) {
        for (Products temp : productList) {
            if (temp.getP_name().equals(prod_name))
                return temp;
        }
        return null;
    }

// Function to find the Product with the ID
    @Override
    public Products findProductById(String prod_name, List<Products> productList) {
        for (Products temp : productList) {
            if (temp.getP_id().equals(prod_name))
                return temp;
        }
        // throw new NoProductException("The Product is not found");
        return null;
    }

// Function to delete the product using ProductId
    @Override
    public void deleteProduct(String productId, List<Products> productList) {
        Products temp = findProductById(productId, productList);
        if (temp == null) {
            System.out.println("The Product with this ID not found");
        } else {
            productList.remove(temp);
            System.out.println(REMOVED_PRODUCT);
        }

    }
// Function to Update the price and the Quantity of the Priduct using the Productid
    @Override
    public void updateProducts(Products product, float new_price, int new_quantity) {
        product.setP_price(new_price);
        product.setP_quantity(new_quantity);
    }

}

