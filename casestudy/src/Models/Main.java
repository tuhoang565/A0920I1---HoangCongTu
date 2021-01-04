package Models;

public class Main {
    public static void main(String[] args) {
        ServicesPlus servicesPlus = new ServicesPlus("massage", 2, 2000);
        Room room = new Room("Deluxe", 45.0, 50000.0, 4, "Rent for day",
                "011", "massage", servicesPlus);
        room.showInfor();
    }
}
