package Test;

import org.junit.Assert;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class AgeCalculatorTest {

    public static void main(String[] args) {
        // setup
        String regex = "02/02/2016";
        LocalDate localDate1 = LocalDate.parse(regex,
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        LocalDate birthDate = LocalDate.of(localDate1.getYear(), localDate1.getMonth(), localDate1.getDayOfMonth());
        LocalDate now = LocalDate.now();
        int actual = Period.between(birthDate, now).getYears();
        System.out.println(actual);
    }
}
