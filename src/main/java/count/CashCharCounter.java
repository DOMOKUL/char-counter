package count;

import java.util.HashMap;
import java.util.Map;

public class CashCharCounter implements CharCounter {

    private final BasicCharCounter basicCharCounter;
    private final Map<String, Map<Character, Integer>> cache = new HashMap<>();

    public CashCharCounter(BasicCharCounter basicCharCounter) {
        this.basicCharCounter = basicCharCounter;
    }

    @Override
    public Map<Character, Integer> fillMap(String text) throws IllegalArgumentException {
        if (text == null || text.equals("")) {
            throw new IllegalArgumentException("You should input String");
        }
        if (cache.containsKey(text)) {
            return cache.get(text);
        }
        Map<Character, Integer> map;
        map = basicCharCounter.fillMap(text);
        cache.put(text, map);
        return map;
    }
}
