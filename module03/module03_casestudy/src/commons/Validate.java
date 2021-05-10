package commons;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.regex.Pattern;

public class Validate {
    public static String validatePhoneNumber(String customerPhone){
        String message = null;
        String regex = "((84)+([0-9]{8}))|(090|091)+([0-9]{7})";
        if(!customerPhone.matches(regex)){
            message = "Phone number invalid";
        }
        return message;
    }

    public static String validateIdCard(String customerIdCard){
        String message = null;
        String regex = "^(([0-9]{9})|([0-9]{12}))$";
        if(!customerIdCard.matches(regex)){
            message = "Id card invalid";
        }
        return message;
    }

    public static String validateEmail(String customerEmail){
        String message = null;
        String regex = "^[a-z][a-z0-9_\\.]{1,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
        if(!customerEmail.matches(regex)){
            message = "Email invalid";
        }
        return message;
    }

    public static String validateBirthday(LocalDate customerBirthday){
        String message = null;

        LocalDate now = LocalDate.now();
        long year = Period.between(customerBirthday, now).getYears();
        if(year < 18 || year > 125){
            message = "Birthday invalid";
        }
        return message;
    }

    public static String validateServiceName(String serviceName){
        String messasge = null;
        String regex = "^(DV-[0-9]{4})$";
        if(!serviceName.matches(regex)){
            messasge = "Service Name invalid";
        }
        return messasge;
    }

    public static String validatePositiveNumber(int number){
        String message = null;
        if(number <= 0){
            message = "Number must greater than 0";
        }
        return message;
    }

}
