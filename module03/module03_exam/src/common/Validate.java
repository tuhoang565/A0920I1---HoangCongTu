package common;

public class Validate {
    public static String validateName(String productName){
        String message = null;

        if(productName.isEmpty()){
            message = "Name not null";
        }
        return message;
    }

    public static String validatePrice(int productPrice){
        String message = null;

        if(productPrice <= 100){
            message = "Price > 100";
        }
        return message;
    }

    public static String validateStock(int productExist){
        String message = null;
        if(productExist <= 10){
            message = "Stock > 10";
        }
        return message;
    }


}
