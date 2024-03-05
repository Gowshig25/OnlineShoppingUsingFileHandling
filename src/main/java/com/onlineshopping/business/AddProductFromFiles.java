package main.java.com.onlineshopping.business;

import main.java.com.onlineshopping.model.Products;

import java.io.*;
import java.util.List;

import static main.java.com.onlineshopping.utils.Constants.csvFile;
// class for File Managing
public class AddProductFromFiles {

    // Function to add the Products from the .csv file to the List
    public void addProducts(ProductOperations productOperations) {


        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    String price_string = parts[1];
                    Float price = Float.parseFloat(price_string);
                    String quantity_string = parts[2];
                    int quantity = Integer.parseInt(quantity_string);
                    productOperations.addItems(name, price, quantity);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    // Function to add the entire product from the List to new csv file
    // while before the program is exit
    public void printToNewExcel(List<Products> data) {
        try (FileWriter writer = new FileWriter("C:\\JavaProgramming\\OnlineShoppingFileHandling\\src\\main\\resources\\notes.csv")) {
            // Writing data to CSV file
            writer.append("Product ID,Product Name,Price,Quantity\n");

            // Writing data to CSV file
            for (Products product : data) {
                writer.append(product.getP_id()).append(",")
                        .append(String.valueOf(product.getP_name())).append(",")
                        .append(String.valueOf(product.getP_price())).append(",")
                        .append(String.valueOf(product.getP_quantity())).append("\n");
            }
            System.out.println("The Item is added Successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
