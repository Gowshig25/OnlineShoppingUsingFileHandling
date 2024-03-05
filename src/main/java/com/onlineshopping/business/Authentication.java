package main.java.com.onlineshopping.business;

import main.java.com.onlineshopping.customexception.IncorrectUsernamePassword;

import java.util.Scanner;

import static main.java.com.onlineshopping.utils.Constants.PASSWORD;
import static main.java.com.onlineshopping.utils.Constants.USER_NAME;

public class Authentication {
    Scanner in = new Scanner(System.in);

    // Function to verify the username and password.
    public boolean authenticate() throws IncorrectUsernamePassword {
        System.out.println(USER_NAME);
        String user_name = in.next();
        System.out.println(PASSWORD);
        String password = in.next();
        return user_name.equals("Gowshi") && password.equals("12345");
    }


}


