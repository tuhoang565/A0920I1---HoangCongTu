package B12_JavaCollection.BaiTap.Product;

import java.util.Comparator;

public class ProductSortByPrice implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return (int)p2.getPrice() - (int)p1.getPrice();
    }
}
