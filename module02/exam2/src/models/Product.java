package models;

public abstract class Product {
    private int idProduct;
    private String aProduct;
    private String nameProduct;
    private int priceProduct;
    private int quantityProduct;
    private String provider;

    public Product() {
    }

    public Product(int idProduct, String aProduct, String nameProduct, int priceProduct, int quantityProduct, String provider) {
        this.idProduct = idProduct;
        this.aProduct = aProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.quantityProduct = quantityProduct;
        this.provider = provider;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getaProduct() {
        return aProduct;
    }

    public void setaProduct(String aProduct) {
        this.aProduct = aProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(int priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(int quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", aProduct='" + aProduct + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", priceProduct=" + priceProduct +
                ", quantityProduct=" + quantityProduct +
                ", provider='" + provider + '\'' +
                '}';
    }

    abstract String getInfo();
}
