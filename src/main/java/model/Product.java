package model;

public class Product {
    private String code;
    private String name;
    private String category;
    private int quantity;
    private double price;
    private String pathImage;

    public Product() {
    }

    public Product(String code, String name, String category, int quantity, double price, String pathImage) {
        this.code = code;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.pathImage = pathImage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }
}
