package common;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

public class Validate {
    public static String validateCustomerName(String name) {
        String message = null;
        String regex = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$";
        if (!name.matches(regex)) {
            message = "Not OK. Customer name invalid";
        }
        return message;
    }
    public static String validateBirthday(String birthday) {
         Pattern DATE_PATTERN = Pattern.compile(
                "^(29/02/(2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26]))))$" +
                        "|^((0[1-9]|1[0-9]|2[0-8])/02/((19|2[0-9])[0-9]{2}))$" +
                        "|^((0[1-9]|[12][0-9]|3[01])/(0[13578]|10|12)/((19|2[0-9])[0-9]{2}))$" +
                        "|^((0[1-9]|[12][0-9]|30)/(0[469]|11)/((19|2[0-9])[0-9]{2}))$");
        String message = null;
        if (!DATE_PATTERN.matcher(birthday).matches()) {
            return "Sai định dạng";
        }
        String[] birthdayArray = birthday.split("/");
        int year = Integer.parseInt(birthdayArray[2]);
        int month = Integer.parseInt(birthdayArray[1]);
        int day = Integer.parseInt(birthdayArray[0]);
        LocalDate birthdate = LocalDate.of(year, month, day);
        LocalDate now = LocalDate.now();
        long age = Period.between(birthdate, now).getYears();
        if (age < 18 || age > 125) {
           return "Tuổi lớn hơn 18 bé hơn 125";
        }
        return message;
    }
}
