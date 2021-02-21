package services;

import commons.ReadFileCSV;
import commons.ValidateInput;
import commons.WriteFileCSV;
import models.Room;
import models.ServicesPlus;

import java.util.*;

public class RoomService {
    static Scanner scanner = new Scanner(System.in);
    ServicesPlus servicesPlus;
    static final String PATH_ROOM = "D:\\A0920I1_Hoang_Cong_Tu\\casestudy\\src\\data\\rooms.csv";

    public static void addRoom() {
        List<Room> roomList = new ArrayList<>();
        String serviceName, typeRent, id;
        int area, cost;
        int numberOfPeople;
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
        } while (!ValidateInput.validateIDRoom(id));

        System.out.println("Enter service plus's name: ");
        String servicePlusName = scanner.nextLine();
        System.out.println("Enter unit: ");
        int unit = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());

        if (ValidateInput.validateIDRoom(id) && ValidateInput.validateServiceName(serviceName) && ValidateInput.validateArea((String.valueOf(area)))
                && ValidateInput.validateCost(String.valueOf(cost)) && ValidateInput.validateMaxPeople(String.valueOf(numberOfPeople))
                && ValidateInput.validateTypeRent(typeRent)) {

            Room room = new Room(serviceName, area, cost, numberOfPeople, typeRent, id, new ServicesPlus(servicePlusName, unit, price));
            roomList.add(room);
            List<String> listStringRoom = new ArrayList<>();
            for (int i = 0; i < roomList.size(); i++) {
                listStringRoom.add(roomList.get(i).getInfo());
            }
            WriteFileCSV.writeFile(listStringRoom, true, PATH_ROOM);
        }

    }

    public static void showRoom(){
        List<String> roomList = ReadFileCSV.readFileCSV(PATH_ROOM);
        for(int i = 0; i < roomList.size(); i++){
            System.out.println((1 + i) + ". " + roomList.get(i));
        }
        System.out.println("--------------------------------");
    }

    public static void showRoomByTreeSet(){
        List<String> list = ReadFileCSV.readFileCSV(PATH_ROOM);
        Set<String> stringSet = new TreeSet<>();

        for(int i = 0; i < list.size(); i++){
            String string = list.get(i);
            String[] parts = string.split(",");
            String name = parts[0];
            stringSet.add(name);
        }
        for(String name : stringSet){
            System.out.println(name);
        }
    }
}
