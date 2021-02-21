package services;

import commons.ReadFileCSV;
import commons.ValidateInput;
import commons.WriteFileCSV;
import exceptions.*;
import models.Customer;
import models.Services;
import views.NameComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CustomerService {
    static Scanner scanner = new Scanner(System.in);
    static final String PATH_CUSTOMER = "D:\\A0920I1_Hoang_Cong_Tu\\casestudy\\src\\data\\customers.csv";


    public static void addNewCustomers() {
        String name = null, birthday = null, gender = null, email = null, typeCustomer = null, address = null, idCustomer = null;
        String phoneNumber = null;
        Services services = null;

        List<Customer> customerList = new ArrayList<>();

        boolean regexBirthday = false;
        boolean regexName = false;
        boolean regexGender = false;
        boolean regexEmail = false;
        boolean regexIDCustomer = false;

        do {
            try {
                System.out.println("Enter name: ");
                name = scanner.nextLine();
                regexName = ValidateInput.validateNameCustomer(name);
            } catch (NameException e) {
                System.out.println(e.getMessage());
            }
        } while (!regexName);

        do {
            try {
                System.out.println("Enter birthday: ");
                birthday = scanner.nextLine();
                regexBirthday = ValidateInput.validateBirthday(birthday);
            } catch (BirthdayException e) {
                System.out.println(e.getMessage());
            }
        } while (!regexBirthday);

        do {
            try {
                System.out.println("Enter gender: ");
                gender = scanner.nextLine();
                regexGender = ValidateInput.validateGender(gender);
            } catch (GenderException e) {
                System.out.println(e.getMessage());
            }
        } while (!regexGender);

        do{
            try{
                System.out.println("Enter email: ");
                email = scanner.nextLine();
                regexEmail = ValidateInput.validateEmail(email);
            }catch (EmailException e){
                System.out.println(e.getMessage());
            }
        }while (!regexEmail);

        do{
            try{
                System.out.println("Enter id customer: ");
                idCustomer = scanner.nextLine();
                regexIDCustomer = ValidateInput.validateIdCard(String.valueOf(idCustomer));
            }catch (IdCardException e){
                System.out.println(e.getMessage());
            }
        }while (!regexIDCustomer);

        System.out.println("Enter type customer: ");
        typeCustomer = scanner.nextLine();
        System.out.println("Enter address: ");
        address = scanner.nextLine();
        System.out.println("Enter phone number: ");
        phoneNumber = scanner.nextLine();


        if (regexBirthday && regexEmail && regexGender && regexIDCustomer && regexName) {
            Customer customer = new Customer();
            customer.setName(name);
            customer.setBirthday(birthday);
            customer.setGender(gender);
            customer.setIdCustomer(idCustomer);
            customer.setPhoneNumber(phoneNumber);
            customer.setEmail(email);
            customer.setTypeCustomer(typeCustomer);
            customer.setAddress(address);
            customerList.add(customer);
            List<String> listStringCustomer = new ArrayList<>();
            for (int i = 0; i < customerList.size(); i++) {
                listStringCustomer.add(customerList.get(i).getInfor());
            }
            WriteFileCSV.writeFile(listStringCustomer, true, PATH_CUSTOMER);
            System.out.println("Add new customer successfull");
            System.out.println("-----------------------------");
        }

    }

    public static void showInformationCustomers() {
        List<String> list = ReadFileCSV.readFileCSV(PATH_CUSTOMER);
        List<Customer> temp = new ArrayList<>();

        list.remove(0);
        for (String customerString : list) {
            String[] parts = customerString.split(",");
            String name = parts[0];
            String birthday = parts[1];
            String gender = parts[2];
            String idCustomer = parts[3];
            String phoneNumber = parts[4];
            String email = parts[5];
            String typeCustomer = parts[6];
            String address = parts[7];
            temp.add(new Customer(name, birthday, gender, idCustomer, phoneNumber, email, typeCustomer, address, null));
        }

        Collections.sort(temp, new NameComparator());
        for(int i = 0; i < temp.size(); i++){
            System.out.println((1 + i) + ". " + temp.get(i));
        }
        System.out.println("-----------------------------------");
    }


}

