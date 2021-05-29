package controllers;

import services.ProductService;

import java.util.Scanner;

public class MainController {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu(){
        int choice;
        do {
            System.out.println("Choose number to continue");
            System.out.println("1. Add New Product");
            System.out.println("2. Delete Product");
            System.out.println("3. Show All Product");
            System.out.println("4. Search Product");
            System.out.println("5. Exit");

            System.out.print("Your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("1. Import Product");
                    System.out.println("2. Export Product");
                    int choiceProduct = Integer.parseInt(scanner.nextLine());
                    switch (choiceProduct){
                        case 1:
                            ProductService.addNewProductImport();
                            break;
                        case 2:
                            ProductService.addNewProductExport();
                            break;
                    }

                    break;
                case 2:
//                    deleteProduct();
                    break;
                case 3:
                    ProductService.showProduct();
                    break;
                case 4:
//                    searchProduct();
                    break;

            }
        }while (choice >= 1 && choice <= 5);
    }
}
