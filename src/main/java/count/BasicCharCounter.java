package count;

import java.util.HashMap;
import java.util.Map;

public class BasicCharCounter implements CharCounter {

    @Override
    public Map<Character, Integer> fillMap(String text) throws IllegalArgumentException {
        if (text==null || text.equals("")) {
            throw new IllegalArgumentException("You should input String");
        }
        text = text.toLowerCase();
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            if (result.containsKey(text.charAt(i))) {
                result.put(text.charAt(i), result.get(text.charAt(i)) + 1);
            } else {
                result.put(text.charAt(i), 1);
            }
        }
        return result;
    }
}
