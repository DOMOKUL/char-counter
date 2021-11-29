package com.company.charcounter.text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FormatterTest {

    // arrange
    private static final String COUNT_CHARS_WITH_LOWER_KEYS = """
            "h" - 1
            "e" - 1
            "l" - 3
            "o" - 2
            " " - 1
            "w" - 1
            "r" - 1
            "d" - 1
            "!" - 1
                """;
    private static final String COUNT_CHARS_WITH_DIGITS_AND_SYMBOLS = """
            "H" - 1
            "e" - 1
            "l" - 3
            "o" - 1
            "1" - 4
            "$" - 2
            " " - 1
            "W" - 1
            "O" - 1
            "2" - 1
            ")" - 2
            "r" - 1
            "d" - 1
            "!" - 1
            """;
    private static final String COUNT_CHARS_WITH_UPPER_KEYS = """
            "H" - 1
            "e" - 1
            "l" - 3
            "o" - 1
            " " - 1
            "W" - 1
            "O" - 1
            "r" - 1
            "d" - 1
            "!" - 1
            """;

    Formatter formatter;

    @BeforeEach
    void setUp() {
        formatter = new Formatter();

    }

    @Test
    void formatOutput_shouldPrintOutput_whenInputLowerKeys() {
        // arrange
        Map<Character, Long> map = Map.of(' ', 1L,
                '!', 1L,
                'r', 1L,
                'd', 1L,
                'e', 1L,
                'w', 1L,
                'h', 1L,
                'l', 3L,
                'o', 2L);

        // act
        String actual = formatter.createLinesForOutput(map, "hello world!");

        // assert
        assertEquals(COUNT_CHARS_WITH_LOWER_KEYS, actual);
    }

    @Test
    void formatOutput_shouldPrintOutput_whenInputTextWithDigitsAndSymbols() {
        // arrange
        Map<Character, Long> map = new HashMap<>();
        map.put(' ', 1L);
        map.put('!', 1L);
        map.put('d', 1L);
        map.put('$', 2L);
        map.put('e', 1L);
        map.put('H', 1L);
        map.put(')', 2L);
        map.put('l', 3L);
        map.put('O', 1L);
        map.put('o', 1L);
        map.put('1', 4L);
        map.put('r', 1L);
        map.put('2', 1L);
        map.put('W', 1L);

        // act
        String actual = formatter.createLinesForOutput(map, "Hello1$$ WO1211)rld!");

        // assert
        assertEquals(COUNT_CHARS_WITH_DIGITS_AND_SYMBOLS, actual);
    }

    @Test
    void formatOutput_shouldPrintOutput_whenInputTextWithUpperCase() {
        // arrange
        Map<Character, Long> map = Map.of(' ', 1L,
                '!', 1L,
                'r', 1L,
                'd', 1L,
                'e', 1L,
                'W', 1L,
                'H', 1L,
                'l', 3L,
                'O', 1L,
                'o', 1L);

        // act
        String actual = formatter.createLinesForOutput(map, "Hello WOrld!");

        // assert
        assertEquals(COUNT_CHARS_WITH_UPPER_KEYS, actual);

    }
}