package main.java.com.onlineshopping.utils;

import main.java.com.onlineshopping.model.Products;

import java.util.List;
import java.util.Scanner;

public class CommonUtils {
    Scanner in = new Scanner(System.in);

    public static int randomGenerate() {
        return (int) (Math.random() * 90) + 10;
    }

    public static boolean ifNullExist(Products product, List<Products> productList) {
        return !product.getP_name().equals("null") && !product.getP_name().equals("empty") && product.getP_price() != 0;
    }

    public static void userSignIn() {
        System.out.println("1.   Log In");
        System.out.println("2.   Create the Account");
    }

}
