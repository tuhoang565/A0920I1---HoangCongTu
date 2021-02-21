package commons;

import exceptions.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateInput {
    private static Pattern pattern;
    private static Matcher matcher;

    public static final String ID_VILLA = "^(SVVL-\\d{4})$";
    public static final String ID_HOUSE = "^(SVHO-\\d{4})$";
    public static final String ID_ROOM = "^(SVRO-\\d{4})$";
    public static final String SERVICE_NAME = "^[A-Z]{1}[a-z]+$";
    public static final String AREA = "^([3-9]\\d+|(\\d\\d\\d)+)$";
    public static final String SWIMMING_POOL_AREA = "^([3-9]\\d+|(\\d\\d\\d)+)$";
    public static final String COST = "^[1-9][0-9]*$";
    public static final String MAX_PEOPLE = "^([1-9]|[1]\\d)$";
    public static final String OTHER_SERVICE = "^(Massage|Karaoke|Food|Drink|Car)$";
    public static final String FLOOR = "^[1-9][0-9]*$";
    public static final String TYPE_RENT = "^(Year|Month|Day|Hour)$";
    public static final String ROOM_STANDARD = "^[A-Z]{1}[a-z]+$";

    public static final String BIRTHDAY = "^(0[1-9]|[12][0-9]|3[01])[\\/](0[1-9]|1[012])[\\/](19|20)\\d\\d$";
    public static final String CUSTOMER_NAME = "^[A-Z][a-z]{1,}(?: [A-Z][a-z]*){0,2}$";
    public static final String EMAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String GENDER = "^(Male|Female|Unknow)$";
    public static final String ID_CARD = "^(\\d{3}\\s\\d{3}\\s\\d{3})$";



    public static boolean validateIDVilla(String regex){
        pattern = Pattern.compile(ID_VILLA);
        matcher = pattern.matcher(regex);
        if(!matcher.matches()){
            System.out.println("Wrong format id - (SVVL-1111)");
        }
        return matcher.matches();
    }
    public static boolean validateIDHouse(String regex){
        pattern = Pattern.compile(ID_HOUSE);
        matcher = pattern.matcher(regex);
        if(!matcher.matches()){
            System.out.println("Wrong format id - (SVHO-1111)");
        }
        return matcher.matches();
    }
    public static boolean validateIDRoom(String regex){
        pattern = Pattern.compile(ID_ROOM);
        matcher = pattern.matcher(regex);
        if(!matcher.matches()){
            System.out.println("Wrong format id - (SVRO-1111)");
        }
        return matcher.matches();
    }

    public static boolean validateServiceName(String regex){
        Pattern pattern = Pattern.compile(SERVICE_NAME);
        Matcher matcher = pattern.matcher(regex);
        if(!matcher.matches()){
            System.out.println("Wrong format service name, must UPPERCASE first character");
        }
        return matcher.matches();
    }

    public static boolean validateArea(String regex){
        Pattern pattern = Pattern.compile(AREA);
        Matcher matcher = pattern.matcher(regex);
        if(!matcher.matches()){
            System.out.println("Wrong format area, area must be GREATER than 30");
        }
        return matcher.matches();
    }

    public static boolean validateSwimmingPoolArea(String regex){
        Pattern pattern = Pattern.compile(SWIMMING_POOL_AREA);
        Matcher matcher = pattern.matcher(regex);
        if(!matcher.matches()){
            System.out.println("Wrong format swimming pool area, swimming pool must be GREATER than 30");
        }
        return matcher.matches();
    }

    public static boolean validateCost(String regex){
        Pattern pattern = Pattern.compile(COST);
        Matcher matcher = pattern.matcher(regex);
        if(!matcher.matches()){
            System.out.println("Wrong format, cost must be GREATER than 0");
        }
        return matcher.matches();
    }

    public static boolean validateMaxPeople(String regex){
        Pattern pattern = Pattern.compile(MAX_PEOPLE);
        Matcher matcher = pattern.matcher(regex);
        if(!matcher.matches()){
            System.out.println("Wrong format, people must be GREATER than 0 and LOWER than 20");
        }
        return matcher.matches();
    }

    public static boolean validateOtherService(String regex){
        Pattern pattern = Pattern.compile(OTHER_SERVICE);
        Matcher matcher = pattern.matcher(regex);
        if(!matcher.matches()){
            System.out.println("Wrong format, other service just can be one of them: Massage|Karaoke|Food|Drink|Car");
        }
        return matcher.matches();
    }

    public static boolean validateFloor(String regex){
        Pattern pattern = Pattern.compile(FLOOR);
        Matcher matcher = pattern.matcher(regex);
        if(!matcher.matches()){
            System.out.println("Wrong format, floor must be GREATER than 0");
        }
        return matcher.matches();
    }

    public static boolean validateTypeRent(String regex){
        Pattern pattern = Pattern.compile(TYPE_RENT);
        Matcher matcher = pattern.matcher(regex);
        if(!matcher.matches()){
            System.out.println("Wrong format, type rent must be one of them: Year/Month/Day/Hour");
        }
        return matcher.matches();
    }

    public static boolean validateRoomStandard(String regex){
        Pattern pattern = Pattern.compile(ROOM_STANDARD);
        Matcher matcher = pattern.matcher(regex);
        if(!matcher.matches()){
            System.out.println("Wrong format, room standard must UPPERCASE first character - Hello");
        }
        return matcher.matches();
    }

    //Validation cho class Customer - exception
    public static boolean validateBirthday(String regex) throws BirthdayException {
        Pattern pattern = Pattern.compile(BIRTHDAY);
        Matcher matcher = pattern.matcher(regex);
        //kiem tra dung dinh dang dd/MM/yyyy
        if(!matcher.matches()){
            throw new BirthdayException();
        }
        //kiem tra nam sinh > 18 so voi ngay hien tai
        LocalDate date = LocalDate.parse(regex, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate now = LocalDate.now();
        LocalDate birthDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth());
        int actual = Period.between(birthDate, now).getYears();

        if(actual < 18){
            throw new BirthdayException();
        }
        return matcher.matches();
    }

    public static boolean validateNameCustomer(String regex) throws NameException {
        Pattern pattern = Pattern.compile(CUSTOMER_NAME);
        Matcher matcher = pattern.matcher(regex);
        if(!matcher.matches()){
            throw new NameException();
        }
        return matcher.matches();
    }

    public static boolean validateEmail(String regex) throws EmailException {
        Pattern pattern = Pattern.compile(EMAIL);
        Matcher matcher = pattern.matcher(regex);
        if(!matcher.matches()){
            throw new EmailException();
        }
        return matcher.matches();
    }

    public static boolean validateIdCard(String regex) throws IdCardException {
        Pattern pattern = Pattern.compile(ID_CARD);
        Matcher matcher = pattern.matcher(regex);
        if(!matcher.matches()){
            throw new IdCardException();
        }
        return matcher.matches();
    }

    public static boolean validateGender(String regex) throws GenderException {
        Pattern pattern = Pattern.compile(GENDER);
        Matcher matcher = pattern.matcher(regex);
        if(!matcher.matches()){
            throw new GenderException();
        }
        return matcher.matches();
    }


}
