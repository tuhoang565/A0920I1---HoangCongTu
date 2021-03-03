package models;

public class ExportProduct extends Product {
    private int exportPrice;
    private String exportNational;

    public ExportProduct() {
    }

    public ExportProduct(int idProduct, String aProduct, String nameProduct, int priceProduct, int quantityProduct,
                         String provider, int exportPrice, String exportNational) {
        super(idProduct, aProduct, nameProduct, priceProduct, quantityProduct, provider);
        this.exportPrice = exportPrice;
        this.exportNational = exportNational;
    }

    public int getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(int exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getExportNational() {
        return exportNational;
    }

    public void setExportNational(String exportNational) {
        this.exportNational = exportNational;
    }

    @Override
    public String toString() {
        return "ExportProduct{" +
                "exportPrice=" + exportPrice +
                ", exportNational='" + exportNational + '\'' +
                '}';
    }

    public String getInfo(){
        return this.getIdProduct() + "," + this.getaProduct() + "," + this.getNameProduct() + "," + this.getPriceProduct() + ","
                + this.getQuantityProduct() + "," + this.getProvider() + "," + this.getExportPrice() + "," + this.getExportNational();
    }
}

