package main.java.com.onlineshopping.model;

public class Products {
    //p-Product
    private String p_id;
    private String p_name;
    private float p_price;
    private int p_quantity;

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public float getP_price() {
        return p_price;
    }

    public void setP_price(float p_price) {
        this.p_price = p_price;
    }

    public int getP_quantity() {
        return p_quantity;
    }

    public void setP_quantity(int p_quantity) {
        this.p_quantity = p_quantity;
    }

    public Products(String p_id, String p_name, float p_price, int p_quantity) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_price = p_price;
        this.p_quantity = p_quantity;
    }

    @Override
    public String toString() {
        return p_id + "  " + p_name + "  " + p_price + "  " + p_quantity;
    }
}
