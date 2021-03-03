package models;

import java.util.PrimitiveIterator;

public class ImportProduct extends Product{
    private int importPrice;
    private String importProvide;
    private int importTax;

    public ImportProduct() {
    }

    public ImportProduct(int idProduct, String aProduct, String nameProduct, int priceProduct, int quantityProduct,
                         String provider, int importPrice, String importProvide, int importTax) {
        super(idProduct, aProduct, nameProduct, priceProduct, quantityProduct, provider);
        this.importPrice = importPrice;
        this.importProvide = importProvide;
        this.importTax = importTax;
    }

    public int getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(int importPrice) {
        this.importPrice = importPrice;
    }

    public String getImportProvide() {
        return importProvide;
    }

    public void setImportProvide(String importProvide) {
        this.importProvide = importProvide;
    }

    public int getImportTax() {
        return importTax;
    }

    public void setImportTax(int importTax) {
        this.importTax = importTax;
    }

    @Override
    public String toString() {
        return "ImportProduct{" +
                "importPrice=" + importPrice +
                ", importProvide='" + importProvide + '\'' +
                ", importTax='" + importTax + '\'' +
                '}';
    }

    public String getInfo(){
        return this.getIdProduct() + "," + this.getaProduct() + "," + this.getNameProduct() + "," + this.getPriceProduct() + ","
                + this.getQuantityProduct() + "," + this.getProvider() + "," + this.getImportPrice() + "," + this.getImportProvide() + ","
                + this.getImportTax();
    }
}
