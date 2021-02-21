package B19_String_Regex.BaiTap.ValidateClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassExample {
    private static final String CLASSNAME = "^[C,A,P]+\\d{4}[G, H, I, K, L, M]$";

    public ClassExample() {
    }
    public boolean validate(String regex){
        Pattern pattern = Pattern.compile(CLASSNAME);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
