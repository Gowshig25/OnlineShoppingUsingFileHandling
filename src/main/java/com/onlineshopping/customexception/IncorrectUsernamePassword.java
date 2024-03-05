package main.java.com.onlineshopping.customexception;

public class IncorrectUsernamePassword extends RuntimeException {
    public IncorrectUsernamePassword(String errormessage) {
        super(errormessage);
    }
}
