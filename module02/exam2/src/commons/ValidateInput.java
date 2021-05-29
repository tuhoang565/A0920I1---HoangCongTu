package commons;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateInput {
    private static Pattern pattern;
    private static Matcher matcher;
    public static final String NUMBER = "^[1-9][0-9]*$";

    public static boolean validateInput(String regex){
        Pattern pattern = Pattern.compile(NUMBER);
        Matcher matcher = pattern.matcher(regex);
        if(!matcher.matches()){
            System.out.println("Wrong format, input must be GREATER than 0");
        }
        return matcher.matches();
    }

}
