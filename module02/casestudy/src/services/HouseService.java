package services;

import commons.ReadFileCSV;
import commons.ValidateInput;
import commons.WriteFileCSV;
import models.House;

import java.util.*;

public class HouseService {
    static Scanner scanner = new Scanner(System.in);
    static final String PATH_HOUSE = "D:\\A0920I1_Hoang_Cong_Tu\\casestudy\\src\\data\\houses.csv";

    public static void addHouse() {
        List<House> houseList = new ArrayList<>();
        String serviceName, typeRent, id, roomStandard, otherService;
        int area, cost;
        int numberOfPeople, floor;
        do {
            System.out.println("Enter service's name(first character uppercase): ");
            serviceName = scanner.nextLine();
        } while (!ValidateInput.validateServiceName(serviceName));

        do {
            System.out.println("Enter area(>30): ");
            area = Integer.parseInt(scanner.nextLine());
        } while (!ValidateInput.validateArea(String.valueOf(area)));

        do {
            System.out.println("Enter cost(>0): ");
            cost = Integer.parseInt(scanner.nextLine());
        } while (!ValidateInput.validateCost(String.valueOf(cost)));

        do {
            System.out.println("Enter number of people(>0 & <20): ");
            numberOfPeople = Integer.parseInt(scanner.nextLine());
        } while (!ValidateInput.validateMaxPeople(String.valueOf(numberOfPeople)));

        do {
            System.out.println("Enter type rent(Year/Month/Day/Hour): ");
            typeRent = scanner.nextLine();
        } while (!ValidateInput.validateTypeRent(typeRent));

        do {
            System.out.println("Enter id(SVXX-YYYY): ");
            id = scanner.nextLine();
        } while (!ValidateInput.validateIDHouse(id));

        do {
            System.out.println("Enter room standard(first character uppercase ): ");
            roomStandard = scanner.nextLine();
        } while (!ValidateInput.validateRoomStandard(roomStandard));

        do {
            System.out.println("Enter floor(>0): ");
            floor = Integer.parseInt(scanner.nextLine());
        } while (!ValidateInput.validateFloor(String.valueOf(floor)));

        do {
            System.out.println("Enter other service(first character uppercase): ");
            otherService = scanner.nextLine();
        } while (!ValidateInput.validateOtherService(otherService));

        if (ValidateInput.validateIDHouse(id) && ValidateInput.validateServiceName(serviceName) && ValidateInput.validateArea((String.valueOf(area)))
                && ValidateInput.validateCost(String.valueOf(cost)) && ValidateInput.validateOtherService(otherService)
                && ValidateInput.validateMaxPeople(String.valueOf(numberOfPeople)) && ValidateInput.validateTypeRent(typeRent)
                && ValidateInput.validateRoomStandard(roomStandard) && ValidateInput.validateFloor(String.valueOf(floor))) {

            House house = new House(serviceName, area, cost, numberOfPeople, typeRent, id,
                    roomStandard, floor, otherService);
            houseList.add(house);
            List<String> listStringHouse = new ArrayList<>();
            for (int i = 0; i < houseList.size(); i++) {
                listStringHouse.add(houseList.get(i).getInfo());
            }
            WriteFileCSV.writeFile(listStringHouse, true, PATH_HOUSE);
            System.out.println("Add new house successfull");
            System.out.println("--------------------------------");
        }
    }

    public static void showHouse(){
        List<String> listHouse = ReadFileCSV.readFileCSV(PATH_HOUSE);
        for(int i = 0; i < listHouse.size(); i++){
            System.out.println((1 + i) + ". " + listHouse.get(i));
        }
        System.out.println("--------------------------------");
    }

    public static void showHouseByTreeSet(){
        List<String> listHouse = ReadFileCSV.readFileCSV(PATH_HOUSE);
        Set<String> setHouse = new TreeSet<>();

        for(int i = 0; i < listHouse.size(); i++){
            String string = listHouse.get(i);
            String[] parts = string.split(",");
            String name = parts[0];
            setHouse.add(name);
        }
        for(String name : setHouse){
            System.out.println(name);
        }
    }
}
