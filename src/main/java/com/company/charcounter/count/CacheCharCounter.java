package com.company.charcounter.count;

import java.util.HashMap;
import java.util.Map;

public class CacheCharCounter implements CharCounter {

    private final BasicCharCounter basicCharCounter;
    private Map<String, Map<Character, Long>> cache = new HashMap<>();

    public CacheCharCounter(BasicCharCounter basicCharCounter) {
        this.basicCharCounter = basicCharCounter;
    }

    @Override
    public Map<Character, Long> countInternal(String text) {
        if (text == null || text.equals("")) {
            throw new IllegalArgumentException("You should input String");
        }
        if (cache.containsKey(text)) {
            return cache.get(text);
        }
        text = text.toLowerCase();
        Map<Character, Long> result = basicCharCounter.countInternal(text);
        cache.put(text,result);
        return result;
    }
}
