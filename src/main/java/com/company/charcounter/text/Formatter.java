package com.company.charcounter.text;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Formatter {

    private static final char SPACE = ' ';
    private static final char DASH = '-';
    private static final char QUOTES = '"';
    private static final char NEWLINE = '\n';

    public String createLinesForOutput(Map<Character, Long> map, String text) {
        List<Character> list = getUniqueCharacters(text);
        return charFormatter(map, list);
    }

    private List<Character> getUniqueCharacters(String text) {
        List<Character> word = text.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        return word.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    private String charFormatter(Map<Character, Long> map, List<Character> list) {
        var outputResult = new StringBuilder();
        list
                .forEach(e -> outputResult.append(QUOTES)
                        .append(e)
                        .append(QUOTES)
                        .append(SPACE)
                        .append(DASH)
                        .append(SPACE)
                        .append(map.get(e))
                        .append(NEWLINE));
        return outputResult.toString();
    }

}
