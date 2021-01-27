package B12_JavaCollection.BaiTap.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    static Scanner scanner = new Scanner(System.in);
    static List<Product> productList;

    static {
        productList = new ArrayList<Product>();
        productList.add(new Product(1, "Redbull", 15000));
        productList.add(new Product(2, "Coca", 13000));
        productList.add(new Product(3, "Pepsi", 10000));
    }

    public static void showProduct() {
        for (int i = 0; i < productList.size(); i++) {
            System.out.println("Id: " + productList.get(i).getId());
            System.out.println("Name: " + productList.get(i).getName());
            System.out.println("Price: " + productList.get(i).getPrice());
        }
    }

    public static void addProduct() {
        System.out.println("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());
        productList.add(new Product(id, name, price));

        showProduct();
        System.out.println("Successfull add product");
    }

    public static void updateProduct(){
        System.out.println("Enter id product want to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter new name: ");
        String name = scanner.nextLine();
        System.out.println("Enter new price: ");
        double price = Double.parseDouble(scanner.nextLine());
        productList.get(id).setName(name);
        productList.get(id).setPrice(price);

        System.out.println("Update successfull");
        showProduct();
    }

    public static void deleteProduct(){
        System.out.println("Enter id product want to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        productList.remove(id);

        showProduct();
        System.out.println("Delete successfull");
    }

    public static void searchProduct(){
        boolean isSearch = false;
        System.out.println("Enter product's name want to search: ");
        String name = scanner.nextLine();
        for (int i = 0; i < productList.size(); i++){
            if(productList.get(i).getName().equals(name)){
                isSearch = true;
                break;
            }
        }

        if(isSearch){
            System.out.println("Found");
        }else {
            System.out.println("Not found");
        }
    }

//  Comparable

//    public static void ascendingPrice(){
//        Collections.sort(productList);
//        for(Product product : productList){
//            System.out.println(product.toString());
//        }
//    }

    public static void ascendingPrice(){
        ProductSortByPrice productSortByPrice = new ProductSortByPrice();
        Collections.sort(productList, productSortByPrice);

        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public static void ascendingName(){
        ProductSortByName productSortByName = new ProductSortByName();
        Collections.sort(productList, productSortByName);

        for(Product product : productList){
            System.out.println(product);
        }
    }

    public static void menu(){
        int choose = 0;
        do{
            System.out.println("Menu: ");
            System.out.println("1. Them san pham");
            System.out.println("2. Hien thi san pham");
            System.out.println("3. Xoa san pham");
            System.out.println("4. Sua san pham");
            System.out.println("5. Tim kiem san pham");
            System.out.println("6. Sap xep giam dan theo gia");
            System.out.println("7. Sap xep tang dan theo ten");
            System.out.println("0. Thoat");
            System.out.print("Your choice: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 0:
                    System.out.println("Exit successful");
                    break;
                case 1:
                    addProduct();
                    break;
                case 2:
                    showProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    updateProduct();
                    break;
                case 5:
                    searchProduct();
                    break;
                case 6:
                    ascendingPrice();
                    break;
                case 7:
                    ascendingName();
                    break;
                default:
                    System.out.println("Error");
            }
        }while (choose != 0);
    }

}
