package main.java.com.onlineshopping;

import main.java.com.onlineshopping.business.Authentication;
import main.java.com.onlineshopping.business.ProductOperations;
import main.java.com.onlineshopping.customexception.IncorrectUsernamePassword;
import main.java.com.onlineshopping.utils.Constants;

import java.util.InputMismatchException;
import java.util.Scanner;

import static main.java.com.onlineshopping.utils.Constants.*;

public class OnlineShopping {
    ProductOperations productoperation = new ProductOperations();
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Authentication authentication = new Authentication();
        OnlineShopping onlineshopping = new OnlineShopping();
        int chances = 3;
        int success = 0;

        try {
            while (chances > 0 && success == 0) {
                if (authentication.authenticate()) {
                    System.out.println(LOGGED_IN);
                    showMenuTemplate();
                    onlineshopping.getUserChoices();
                    success = 1;
                } else {
                    System.out.println(INVALID_USER);
                    System.out.println("You have only " + (chances - 1) + " chances left");
                }
                chances--;
            }
        } catch (IncorrectUsernamePassword v) {
            System.out.println(v.getMessage());
        } catch (InputMismatchException e) {
            System.out.println(Constants.INVALID_INPUT);
        }
    }

// Function to dispaly the menu to the User
    public static void showMenuTemplate() {
        System.out.println();
        System.out.println("              |----------------------------------------|");
        System.out.println("              *           Online Shopping             *");
        System.out.println("              |                                        |");
        System.out.println("              |     1. Add Items to the Stock          |");
        System.out.println("              |                                        |");
        System.out.println("              |     2.  Find Items                     |");
        System.out.println("              |                                        |");
        System.out.println("              |     3.  Display Entire Item            |");
        System.out.println("              |                                        |");
        System.out.println("              |     4. Remove Item from list           |");
        System.out.println("              |                                        |");
        System.out.println("              |     5.Update Items                     |");
        System.out.println("              |                                        |");
        System.out.println("              |     6. Exist                           |");
        System.out.println("              |----------------------------------------|");

        System.out.println("Enter your choice");
    }

    // Function to get the choices from user
    public void getUserChoices() {
        int choice = in.nextInt();
        boolean flag = true;
        while (flag) {
            switch (choice) {
                case 1:
                    productoperation.addItemChoices(productoperation);
                    break;
                case 2:
                    productoperation.findItem();
                    break;
                case 3:
                    productoperation.displayEntireItem();
                    break;
                case 4:
                    productoperation.removeItems();
                    break;
                case 5:
                    productoperation.updateItems();
                    break;
                case 6:
                    System.out.println(EXITED);
                    productoperation.newExcel();
                    flag = false;
                default:
                    flag = false;
            }
            if (choice <= 5 && choice >= 1) {
                showMenuTemplate();
                choice = in.nextInt();
            }
        }
    }
}
