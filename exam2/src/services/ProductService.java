package services;

import commons.ReadFileCSV;
import commons.ValidateInput;
import commons.WriteFileCSV;
import exceptions.NumberException;
import models.ExportProduct;
import models.ImportProduct;
import models.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductService {
    static Scanner scanner = new Scanner(System.in);
    static final String PATH_PRODUCT = "D:\\A0920I1_Hoang_Cong_Tu\\exam2\\src\\data\\products.csv";
    static final String PATH_PRODUCT_EXPORT = "D:\\A0920I1_Hoang_Cong_Tu\\exam2\\src\\data\\productsExport.csv";

    static int ID_PRODUCT = 0;

    public static void addNewProductImport() {
        List<ImportProduct> importProductList = new ArrayList<>();
        int idProduct;
        String aProduct;
        String nameProduct;
        int priceProduct;
        int quantityProduct;
        String provider;
        int importPrice;
        String importProvide;
        int importTax;

        ID_PRODUCT++;
        idProduct = ID_PRODUCT;
//        do{
        System.out.println("Enter a product: ");
        aProduct = scanner.nextLine();
//        }while (aProduct.length() > 0);
//        do{
        System.out.println("Enter name product: ");
        nameProduct = scanner.nextLine();
//        }while (nameProduct.length() > 0);
        do {
            System.out.println("Enter price product: ");
            priceProduct = Integer.parseInt(scanner.nextLine());
        } while (!ValidateInput.validateInput(String.valueOf(priceProduct)));
        do {
            System.out.println("Enter quantity of product: ");
            quantityProduct = Integer.parseInt(scanner.nextLine());
        } while (!ValidateInput.validateInput(String.valueOf(quantityProduct)));
//        do{
        System.out.println("Enter provider product: ");
        provider = scanner.nextLine();
//        }while (provider.length() > 0);
        do {
            System.out.println("Enter import price product: ");
            importPrice = Integer.parseInt(scanner.nextLine());
        } while (!ValidateInput.validateInput(String.valueOf(importPrice)));
//        do{
        System.out.println("Enter import provide of product: ");
        importProvide = scanner.nextLine();
//        }while (importProvide.length() > 0);
        do {
            System.out.println("Enter import tax product: ");
            importTax = Integer.parseInt(scanner.nextLine());
        } while (!ValidateInput.validateInput(String.valueOf(importTax)));

        ImportProduct importProduct = new ImportProduct(idProduct, aProduct, nameProduct, priceProduct, quantityProduct, provider, importPrice,
                importProvide, importTax);
        importProductList.add(importProduct);

        List<String> importProductListString = new ArrayList<>();
        for (int i = 0; i < importProductList.size(); i++) {
            importProductListString.add(importProductList.get(i).getInfo());
        }
        WriteFileCSV.writeFile(importProductListString, true, PATH_PRODUCT);
        System.out.println("Add new import product successful");
        System.out.println("--------------------------");
    }

    public static void addNewProductExport() {
        List<ExportProduct> exportProductList = new ArrayList<>();
        int idProduct;
        String aProduct = null;
        String nameProduct = null;
        int priceProduct = 0;
        int quantityProduct = 0;
        String provider = null;
        int exportPrice = 0;
        String exportNational = null;
        boolean regexPrice = false;

        idProduct = ID_PRODUCT + 1;
//        do{
        System.out.println("Enter a product: ");
        aProduct = scanner.nextLine();
//        }while (aProduct.length() > 0);
//        do{
        System.out.println("Enter name product: ");
        nameProduct = scanner.nextLine();
//        }while (nameProduct.length() > 0);

//        do{
//            try{
//                System.out.println("Enter id customer: ");
//                idCustomer = scanner.nextLine();
//                regexIDCustomer = ValidateInput.validateIdCard(String.valueOf(idCustomer));
//            }catch (IdCardException e){
//                System.out.println(e.getMessage());
//            }
//        }while (!regexIDCustomer);
        do {

            System.out.println("Enter price product: ");
            priceProduct = Integer.parseInt(scanner.nextLine());
            regexPrice = ValidateInput.validateInput(String.valueOf(priceProduct));

        } while (!regexPrice);
        do {
            System.out.println("Enter quantity of product: ");
            quantityProduct = Integer.parseInt(scanner.nextLine());
        } while (!ValidateInput.validateInput(String.valueOf(quantityProduct)));
//        do{
        System.out.println("Enter provider product: ");
        provider = scanner.nextLine();
//        }while (provider.length() > 0);
        do {
            System.out.println("Enter export price product: ");
            exportPrice = Integer.parseInt(scanner.nextLine());
        } while (!ValidateInput.validateInput(String.valueOf(exportPrice)));
//        do{
        System.out.println("Enter import provide of product: ");
        exportNational = scanner.nextLine();
//        }while (importProvide.length() > 0);


        ExportProduct exportProduct = new ExportProduct(idProduct, aProduct, nameProduct, priceProduct, quantityProduct, provider,
                exportPrice, exportNational);
        exportProductList.add(exportProduct);

        List<String> exportProductListString = new ArrayList<>();
        for (int i = 0; i < exportProductList.size(); i++) {
            exportProductListString.add(exportProductList.get(i).getInfo());
        }
        WriteFileCSV.writeFile(exportProductListString, true, PATH_PRODUCT_EXPORT);
        System.out.println("Add new export product successful");
        System.out.println("--------------------------");
    }

    public static void showProduct() {
        List<String> list = ReadFileCSV.readFileCSV(PATH_PRODUCT);
        List<String> listExport = ReadFileCSV.readFileCSV(PATH_PRODUCT_EXPORT);
        for (int i = 0; i < list.size(); i++) {
            System.out.println((1 + i) + ". " + list.get(i));
        }
        for (int i = 0; i < listExport.size(); i++) {
            System.out.println((1 + i) + ". " + listExport.get(i));
        }
        System.out.println("--------------------------------");
    }

    public static void deleteProduct(){
        System.out.printf("Enter aProduct want to delete: ");
        String aProduct = scanner.nextLine();

        List<String> listImport = ReadFileCSV.readFileCSV(PATH_PRODUCT);
        List<String> listExport = ReadFileCSV.readFileCSV(PATH_PRODUCT_EXPORT);
        List<ImportProduct> tempImport = new ArrayList<>();
        List<ExportProduct> tempExport = new ArrayList<>();

        listImport.remove(0);
        for (String importProduct : listImport) {
            String[] parts = importProduct.split(",");
            String idProduct = parts[0];
            aProduct = parts[1];
            String nameProduct = parts[2];
            String priceProduct = parts[3];
            String quantityProduct = parts[4];
            String provider = parts[5];
            String exportPrice = parts[6];
            String exportNational = parts[7];

            tempExport.add(new ExportProduct(Integer.parseInt(idProduct), aProduct, nameProduct, Integer.parseInt(priceProduct),
                    Integer.parseInt(quantityProduct), provider, Integer.parseInt(exportPrice),
                    exportNational));
        }

        listImport.remove(0);
        for (String exportProduct : listExport) {
            String[] parts = exportProduct.split(",");
            String idProduct = parts[0];
            aProduct = parts[1];
            String nameProduct = parts[2];
            String priceProduct = parts[3];
            String quantityProduct = parts[4];
            String provider = parts[5];
            String importPrice = parts[6];
            String importProvide = parts[7];
            String importTax = parts[8];
            tempImport.add(new ImportProduct(Integer.parseInt(idProduct), aProduct, nameProduct, Integer.parseInt(priceProduct),
                    Integer.parseInt(quantityProduct), provider, Integer.parseInt(importPrice),
                    importProvide, Integer.parseInt(importTax)));
        }


        for(int i = 0; i < temp.size(); i++){
            System.out.println((1 + i) + ". " + temp.get(i));
        }
        System.out.println("-----------------------------------");

    }
}
