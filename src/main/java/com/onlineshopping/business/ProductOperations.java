package main.java.com.onlineshopping.business;

import main.java.com.onlineshopping.customexception.DuplicateProductExpection;
import main.java.com.onlineshopping.implementations.ProductImpl;
import main.java.com.onlineshopping.interfaces.ProductIntref;
import main.java.com.onlineshopping.model.Products;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static main.java.com.onlineshopping.utils.CommonUtils.randomGenerate;
import static main.java.com.onlineshopping.utils.Constants.*;


public class ProductOperations {

    List<Products> products = new ArrayList<>();
    ProductIntref productImpl = new ProductImpl();
    Scanner in = new Scanner(System.in);
    AddProductFromFiles addProductsFromFiles = new AddProductFromFiles();

    public void addItems() {

        int id_num = randomGenerate();
        String id = "PID_" + "" + id_num;

        try {
            System.out.println(PRODUCT_NAME);
            String name = in.next();
            System.out.println(ENTER_PRICE);
            float price = in.nextFloat();
            System.out.println(ENTER_QUANTIY);
            int quan = in.nextInt();
            productImpl.addProducts(new Products(id, name, price, quan), products);
        } catch (DuplicateProductExpection e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println(INVALID_INPUT);
            in.nextLine();
        }
    }

    public void addItems(String name, Float price, int quantity) {
        int id_num = randomGenerate();
        String id = "PID_" + "" + id_num;
        System.out.println(name + " " + price + " " + quantity);
        try {
            productImpl.addProducts(new Products(id, name, price, quantity), products);
        } catch (DuplicateProductExpection e) {
            System.out.println(e.getMessage());
        }

    }

    public void addItemChoices(ProductOperations productOperations) {
        System.out.println("--------------------");
        System.out.println("1. Add one item");
        System.out.println("2. Add More Products");
        System.out.println("3. Add Products from Excel");
        System.out.println("______________________");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                addItems();
                break;
            case 2:
                System.out.println("Enter the number of Products to add");
                int num_products = in.nextInt();
                for (int i = 0; i < num_products; i++) {
                    addItems();
                }
                break;
            case 3:
                addProductsFromFiles.addProducts(productOperations);
                break;

        }
        // added nextLine
        in.nextLine();
    }

    public void findItem() {
        String input1;
        if (products.size() == 0) {
            System.out.println(NO_PRODUCT);
            System.out.println("Would to like to add any items Y/N");
            input1 = in.nextLine();
            if (input1.equals("y") || input1.equals("Y")) {
                addItems();
            }
            in.nextLine();
        } else {

            System.out.println(PRODUCT_NAME);
            String input = in.nextLine();
            Products temp = productImpl.findProduct(input, products);
            if (temp != null)
                System.out.println(temp);
            else
                System.out.println("Where the product Not found");

        }
    }


    public void displayEntireItem() {
        if (products.size() == 0) {
            System.out.println(NO_PRODUCT);
        } else {
            for (Products temp : products) {
                System.out.println(temp);
            }
        }
    }


    //Remove Items
    public void removeItems() {
        if (products.size() == 0) {
            System.out.println(NO_PRODUCT);
        } else {
            System.out.println(PRODUCT_ID);
            String id_input = in.next();
            productImpl.deleteProduct(id_input, products);
        }
    }

    public void updateItems() {
        if (products.size() == 0) {
            System.out.println(NO_PRODUCT);
        } else {
            System.out.println(PRODUCT_ID);
            String input = "";
            try {
                input = in.next();
                Products temp = productImpl.findProductById(input, products);
                if (temp == null) {
                    System.out.println("The Product with this ID not Found");
                } else {
                    System.out.println(ENTER_PRICE);
                    float new_price = in.nextFloat();
                    System.out.println(ENTER_QUANTIY);
                    int new_quantity = in.nextInt();
                    productImpl.updateProducts(temp, new_price, new_quantity);
                    System.out.println("The Item is updated Successfully");
                }
            } catch (InputMismatchException e) {
                System.out.println(INVALID_INPUT);
            }

        }
    }

    public void newExcel() {
        addProductsFromFiles.printToNewExcel(products);
    }


}
