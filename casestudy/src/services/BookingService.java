package services;

import commons.ReadFileCSV;
import commons.ValidateInput;
import commons.WriteFileCSV;
import models.Customer;
import models.Villa;
import views.NameComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BookingService {
    static final String PATH_BOOKING = "D:\\A0920I1_Hoang_Cong_Tu\\casestudy\\src\\data\\bookings.csv";
    static final String PATH_CUSTOMER = "D:\\A0920I1_Hoang_Cong_Tu\\casestudy\\src\\data\\customers.csv";
    static final String PATH_VILLA = "D:\\A0920I1_Hoang_Cong_Tu\\casestudy\\src\\data\\villa.csv";
    static final String PATH_HOUSE = "D:\\A0920I1_Hoang_Cong_Tu\\casestudy\\src\\data\\houses.csv";
    static final String PATH_ROOM = "D:\\A0920I1_Hoang_Cong_Tu\\casestudy\\src\\data\\rooms.csv";
    static Scanner scanner = new Scanner(System.in);
    static List<String> bookingServiceList = new ArrayList<>();

    public static void addNewBooking() {
        int choice_customer;
        int choice_service;
        int choice_service_detail;
        String id;

        CustomerService.showInformationCustomers();
        List<String> listCustomer = ReadFileCSV.readFileCSV(PATH_CUSTOMER);

        List<String> listHouse = ReadFileCSV.readFileCSV(PATH_HOUSE);
        List<String> listRoom = ReadFileCSV.readFileCSV(PATH_ROOM);


        System.out.println("Choice customer: ");
        choice_customer = Integer.parseInt(scanner.nextLine());

        System.out.println("1.\tBooking Villa\n" +
                "2.\tBooking House\n" +
                "3.\tBooking Room\n");
        System.out.println("Your choice: ");
        choice_service = Integer.parseInt(scanner.nextLine());
        switch (choice_service) {
//            case 1: chi add id vao file booking
            case 1:
                VillaService.showVilla();
                System.out.println("Choose villa you want to booking: ");
                choice_service_detail = Integer.parseInt(scanner.nextLine());
                id = VillaService.getServiceId(choice_service_detail);
                bookingServiceList.add((listCustomer.get(choice_customer)) + "," + id);
                WriteFileCSV.writeFile(bookingServiceList, true, PATH_BOOKING);
                break;

//                case 2: add nguyen service vao file booking
            case 2:
                HouseService.showHouse();
                System.out.println("Choose house you want to booking: ");
                choice_service_detail = Integer.parseInt(scanner.nextLine());
                bookingServiceList.add(listCustomer.get(choice_customer) + "," + listHouse.get(choice_service_detail - 1));
                WriteFileCSV.writeFile(bookingServiceList, true, PATH_BOOKING);
                break;
            case 3:
                RoomService.showRoom();
                System.out.println("Choose room you want to booking: ");
                choice_service_detail = Integer.parseInt(scanner.nextLine());
                bookingServiceList.add(listCustomer.get(choice_customer) + "," + listRoom.get(choice_service_detail - 1));
                WriteFileCSV.writeFile(bookingServiceList, true, PATH_BOOKING);
                break;
            default:
                System.out.println("Error choise");

        }
    }
}
