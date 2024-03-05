package main.java.com.onlineshopping.customexception;

public class DuplicateProductExpection extends RuntimeException {
    public DuplicateProductExpection(String errormessage) {
        super(errormessage);
    }
}
