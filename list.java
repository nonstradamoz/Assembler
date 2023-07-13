package eoc_java.Assembler_combined;

import java.util.HashMap;
import java.util.Map;

public class list {
    public static Map<String, Integer> map = new HashMap<>();
    public static int count = 16;

    public int checkAndAppend(String element) {
        if (map.containsKey(element)) {
            int value = map.get(element);
            return value;
        } else {
            int x = count;
            map.put(element, x);
            count++;
            return x;
        }
    }

}
