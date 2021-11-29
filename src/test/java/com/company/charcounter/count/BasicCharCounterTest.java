package com.company.charcounter.count;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BasicCharCounterTest {

    BasicCharCounter basicCharCounter;

    @BeforeEach
    void setUp() {
        basicCharCounter = new BasicCharCounter();
    }

    @Test
    void fillMap_shouldReturnException_whenInputEmptyLine() {
        // arrange
        String expected = "You should input String";

        // act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> basicCharCounter.countInternal(""));
        String actual = exception.getMessage();

        // assert
        assertTrue(actual.contains(expected));
    }

    @Test
    void fillMap_shouldReturnUniqueValue_whenInputText() {
        // arrange
        Map<Character, Long> expected = new LinkedHashMap<>();

        // act
        expected.put(' ', 1L);
        expected.put('!', 1L);
        expected.put('r', 1L);
        expected.put('d', 1L);
        expected.put('e', 1L);
        expected.put('w', 1L);
        expected.put('h', 1L);
        expected.put('l', 3L);
        expected.put('o', 2L);
        Map<Character, Long> actual = basicCharCounter.countInternal("hello world!");

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void fillMap_shouldReturnUniqueValue_whenInputUpperCaseText() {
        // arrange
        Map<Character, Long> expected = new LinkedHashMap<>();

        // act
        expected.put(' ', 1L);
        expected.put('!', 1L);
        expected.put('R', 1L);
        expected.put('D', 1L);
        expected.put('E', 1L);
        expected.put('W', 1L);
        expected.put('H', 1L);
        expected.put('L', 3L);
        expected.put('O', 2L);
        Map<Character, Long> actual = basicCharCounter.countInternal("HELLO WORLD!");

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void fillMap_shouldReturnUniqueValue_whenInputDigitsAndSymbolsUpperCase() {
        // arrange
        Map<Character, Long> expected = new LinkedHashMap<>();

        // act
        expected.put(' ', 1L);
        expected.put('1', 3L);
        expected.put('r', 1L);
        expected.put('d', 1L);
        expected.put('$', 2L);
        expected.put('e', 1L);
        expected.put('W', 1L);
        expected.put('H', 1L);
        expected.put('l', 3L);
        expected.put('O', 1L);
        expected.put('o', 1L);
        Map<Character, Long> actual = basicCharCounter.countInternal("Hello1$$ WO11rld");

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void fillMap_shouldReturnUniqueValue_whenInputDigitsAndSymbolsLowerCase() {
        // arrange
        Map<Character, Long> expected = new LinkedHashMap<>();

        // act
        expected.put(' ', 1L);
        expected.put('1', 3L);
        expected.put('r', 1L);
        expected.put('$', 2L);
        expected.put('d', 1L);
        expected.put('e', 1L);
        expected.put('w', 1L);
        expected.put('h', 1L);
        expected.put('l', 3L);
        expected.put('o', 2L);
        Map<Character, Long> actual = basicCharCounter.countInternal("hello1$$ wo11rld");

        // assert
        assertEquals(expected, actual);
    }

}