package com.company.charcounter.count;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BasicCharCounter implements CharCounter {

    @Override
    public Map<Character, Long> countInternal(String text) {
        if (text == null || text.equals("")) {
            throw new IllegalArgumentException("You should input String");
        }
        return text
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
