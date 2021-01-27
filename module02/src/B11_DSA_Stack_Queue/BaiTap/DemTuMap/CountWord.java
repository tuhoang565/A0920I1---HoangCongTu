package B11_DSA_Stack_Queue.BaiTap.DemTuMap;

import java.util.Map;
import java.util.TreeMap;

public class CountWord {
    public static void main(String[] args) {
        TreeMap<String, Integer> map1 = new TreeMap<>();
        String string = "hello my friend how are you my friend";
        String[] stringArray = string.split("\\s");
        for (int i = 0; i < stringArray.length; i++) {
            if (map1.containsKey(stringArray[i])) {
                    map1.put(stringArray[i], map1.get(stringArray[i]) + 1);
            } else {
                map1.put(stringArray[i], 1);
            }

        }

        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
