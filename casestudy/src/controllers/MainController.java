package controllers;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import commons.ReadFileCSV;
import models.*;
import services.*;

import java.util.*;


public class MainController {
    static Scanner scanner = new Scanner(System.in);
    private static boolean isExit = false;
    private static boolean isBackToMenu = false;
    static final String PATH_EMPLOYEE = "D:\\A0920I1_Hoang_Cong_Tu\\casestudy\\src\\data\\employees.csv";

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        int choice;
        do {
            System.out.println("1. Add New Services");
            System.out.println("2. Show Services");
            System.out.println("3. Add New Customer");
            System.out.println("4. Show Information of Customer");
            System.out.println("5. Add New Booking");
            System.out.println("6. Show Information of Employee");
            System.out.println("7. Queue");
            System.out.println("8. Stack");
            System.out.println("9. Exit");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addNewService();
                    break;
                case 2:
                    showService();
                    break;
                case 3:
                    CustomerService.addNewCustomers();
                    break;
                case 4:
                    CustomerService.showInformationCustomers();
                    break;
                case 5:
                    BookingService.addNewBooking();
                    break;
                case 6:
                    EmployeeService.showEmployee();
                    break;
                case 7:
                    printQueue();
                    break;
                case 8:
                    searchByStack();
                    break;
                case 9:
                    isExit = true;
                    System.out.println("Exit");
                    System.out.println("----------------------");
                    break;
                default:
                    System.out.println("error");
            }
            if (isExit) {
                break;
            }
        } while (choice >= 1 && choice <= 9);
    }

    public static void addNewService() {
        int choice_service;
        do {
            System.out.println("1.\tAdd New Villa\n" +
                    "2.\tAdd New House\n" +
                    "3.\tAdd New Room\n" +
                    "4.\tBack to menu\n" +
                    "5.\tExit\n");
            System.out.println("Your choice: ");
            choice_service = scanner.nextInt();
            switch (choice_service) {
                case 1:
                    VillaService.addVilla();
                    break;
                case 2:
                    HouseService.addHouse();
                    break;
                case 3:
                    RoomService.addRoom();
                    break;
                case 4:
                    isBackToMenu = true;
                    break;
                case 5:
                    isExit = true;
                    break;
                default:
                    System.out.println("Error choice");
            }
            if (isExit || isBackToMenu) {
                return;
            }
        } while (choice_service >= 1 && choice_service <= 5);
    }

    public static void showService() {
        int choiceShowService;
        do {
            System.out.println("1.\tShow all Villa\n" +
                    "2.\tShow all House\n" +
                    "3.\tShow all Room\n" +
                    "4.\tShow All Name Villa Not Duplicate\n" +
                    "5.\tShow All Name House Not Duplicate\n" +
                    "6.\tShow All Name Name Not Duplicate\n" +
                    "7.\tBack to menu\n" +
                    "8.\tExit\n");
            System.out.println("Your choice: ");
            choiceShowService = scanner.nextInt();
            switch (choiceShowService) {
                case 1:
                    VillaService.showVilla();
                    break;
                case 2:
                    HouseService.showHouse();
                    break;
                case 3:
                    RoomService.showRoom();
                    break;
                case 4:
                    VillaService.showVillaByTreeSet();
                    break;
                case 5:
                    HouseService.showHouseByTreeSet();
                    break;
                case 6:
                    RoomService.showRoomByTreeSet();
                    break;
                case 7:
                    isBackToMenu = true;
                    break;
                case 8:
                    isExit = true;
                    break;
                default:
                    System.out.println("Error choice");
            }
            if (isExit || isBackToMenu) {
                break;
            }
        } while (choiceShowService > 0 && choiceShowService < 9);
    }

    public static void printQueue(){
        System.out.println("Enter number of customer: ");
        scanner.nextLine();
        int numberOfCustomer = Integer.parseInt(scanner.nextLine());

        Queue<String> queue = new LinkedList<>();
        for(int i = 0; i < numberOfCustomer; i++){
            System.out.println("Name of customer: ");
            String name = scanner.nextLine();
            queue.add(name);
        }
        System.out.println(queue);
    }

    public static String searchByStack(){
        Stack<Employee> employeeStack = new Stack<>();
        List<String> listEmployeeString = ReadFileCSV.readFileCSV(PATH_EMPLOYEE);
        Employee employee = new Employee();

        for(int i = 0; i < listEmployeeString.size(); i++){
            String string = listEmployeeString.get(i);
            String[] parts = string.split(",");
            employee.setName(parts[0]);
            employee.setAge(Integer.parseInt(parts[1]));
            employee.setAddress(parts[2]);

            employeeStack.push(employee);
        }
        scanner.nextLine();
        System.out.println("Enter name's employee want to search: ");
        String name = scanner.nextLine();
        for(Employee employee1 : employeeStack){
            if(employee1.getName().equals(name)){
                System.out.println(employee1.toString());
            }
        }

        return "Not found";
    }
}


