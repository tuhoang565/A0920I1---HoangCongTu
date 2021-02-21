package services;

import commons.ReadFileCSV;
import commons.ValidateInput;
import commons.WriteFileCSV;
import models.Villa;

import java.util.*;

public class VillaService {
    static Scanner scanner = new Scanner(System.in);
    static final String PATH = "D:\\A0920I1_Hoang_Cong_Tu\\casestudy\\src\\data\\villa.csv";


    public static void addVilla() {
        List<Villa> villaList = new ArrayList<>();
        String serviceName, typeRent, id, roomStandard, otherService;
        int area, cost;
        int numberOfPeople, swimmingPoolArea, floor;

        do {
            System.out.println("Enter service's name(first character uppercase): ");
            serviceName = scanner.nextLine();
        }while (!ValidateInput.validateServiceName(serviceName));

        do{
            System.out.println("Enter area(>30): ");
            area = Integer.parseInt(scanner.nextLine());
        }while (!ValidateInput.validateArea(String.valueOf(area)));

        do{
            System.out.println("Enter cost(>0): ");
            cost = Integer.parseInt(scanner.nextLine());
        }while (!ValidateInput.validateCost(String.valueOf(cost)));

        do{
            System.out.println("Enter number of people(>0 & <20): ");
            numberOfPeople = Integer.parseInt(scanner.nextLine());
        }while (!ValidateInput.validateMaxPeople(String.valueOf(numberOfPeople)));

        do{
            System.out.println("Enter type rent(Year/Month/Day/Hour): ");
            typeRent = scanner.nextLine();
        }while (!ValidateInput.validateTypeRent(typeRent));

        do{
            System.out.println("Enter id(SVXX-YYYY): ");
            id = scanner.nextLine();
        }while (!ValidateInput.validateIDVilla(id));

        do{
            System.out.println("Enter room standard(first character uppercase ): ");
            roomStandard = scanner.nextLine();
        }while (!ValidateInput.validateRoomStandard(roomStandard));

        do{
            System.out.println("Enter swimming pool area(>30): ");
            swimmingPoolArea = Integer.parseInt(scanner.nextLine());
        }while (!ValidateInput.validateSwimmingPoolArea(String.valueOf(swimmingPoolArea)));

        do{
            System.out.println("Enter floor(>0): ");
            floor = Integer.parseInt(scanner.nextLine());
        }while (!ValidateInput.validateFloor(String.valueOf(floor)));

       do{
           System.out.println("Enter other service(first character uppercase): ");
           otherService = scanner.nextLine();
       }while (!ValidateInput.validateOtherService(otherService));



        if (ValidateInput.validateIDVilla(id) && ValidateInput.validateServiceName(serviceName) && ValidateInput.validateArea((String.valueOf(area)))
                && ValidateInput.validateCost(String.valueOf(cost)) && ValidateInput.validateOtherService(otherService)
                && ValidateInput.validateMaxPeople(String.valueOf(numberOfPeople)) && ValidateInput.validateTypeRent(typeRent)
                && ValidateInput.validateRoomStandard(roomStandard) && ValidateInput.validateSwimmingPoolArea(String.valueOf(swimmingPoolArea))
                && ValidateInput.validateFloor(String.valueOf(floor))) {
            Villa villa = new Villa(serviceName, area, cost, numberOfPeople, typeRent, id,
                    roomStandard, swimmingPoolArea, floor, otherService);
            villaList.add(villa);

            List<String> listVillaString = new ArrayList<>();
            for (int i = 0; i < villaList.size(); i++) {
                listVillaString.add(villaList.get(i).getInfo());
            }
            WriteFileCSV.writeFile(listVillaString, true, PATH);
            System.out.println("Add new villa successful");
            System.out.println("--------------------------");
        }

    }

    public static void showVilla() {
        List<String> list = ReadFileCSV.readFileCSV(PATH);
        for (int i = 0; i < list.size(); i++) {
            System.out.println((1 + i) + ". " + list.get(i));
        }
        System.out.println("--------------------------------");
    }

    public static void showVillaByTreeSet(){
        List<String> list = ReadFileCSV.readFileCSV(PATH);
        Set<String> treeSet = new TreeSet<>();

        for(int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            String[] parts = str.split(",");
            String name = parts[0];
//            String area = parts[1];
//            String cost = parts[2];
//            String numberOfPeople = parts[3];
//            String typeRent = parts[4];
//            String id = parts[5];
//            String roomStandard = parts[6];
//            String swimmingPoolArea = parts[7];
//            String floor = parts[8];
//            String otherService = parts[9];

            treeSet.add(name);
        }

        for(String name : treeSet){
            System.out.println(name);
        }
    }

    public static String getServiceId(int i) {
        List<String> list = ReadFileCSV.readFileCSV(PATH);

        String str = list.get(i - 1);
        String[] parts = str.split(",");
        String name = parts[0];
        int area = Integer.parseInt(parts[1]);
        int cost = Integer.parseInt(parts[2]);
        int numberOfPeople = Integer.parseInt(parts[3]);
        String typeRent = parts[4];
        String id = parts[5];
        String roomStandard = parts[6];
        int swimmingPoolArea = Integer.parseInt(parts[7]);
        int floor = Integer.parseInt(parts[8]);
        String otherService = parts[9];

        return id;
    }
}
