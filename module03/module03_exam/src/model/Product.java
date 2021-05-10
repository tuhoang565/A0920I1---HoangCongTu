package model;

public class Product {
    private int productId;
    private String productName;
    private int productPrice;
    private int productDiscount;
    private int productExist;

    public Product() {
    }

    public Product(String productName, int productPrice, int productDiscount, int productExist) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDiscount = productDiscount;
        this.productExist = productExist;
    }

    public Product(int productId, String productName, int productPrice, int productDiscount, int productExist) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDiscount = productDiscount;
        this.productExist = productExist;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(int productDiscount) {
        this.productDiscount = productDiscount;
    }

    public int getProductExist() {
        return productExist;
    }

    public void setProductExist(int productExist) {
        this.productExist = productExist;
    }
}
