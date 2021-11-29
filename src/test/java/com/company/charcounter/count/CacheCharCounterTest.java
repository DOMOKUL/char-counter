package com.company.charcounter.count;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class CacheCharCounterTest {

    // arrange
    static final String TEST = "hello world!";
    static LinkedHashMap<Character, Long> testMap = new LinkedHashMap<>();

    @Mock
    LinkedHashMap<String, LinkedHashMap<Character, Long>> cache;

    BasicCharCounter basicCharCounter = mock(BasicCharCounter.class);

    @InjectMocks
    CacheCharCounter cacheCharCounter = new CacheCharCounter(basicCharCounter);

    @Test
    void fillCacheMap_shouldCacheReturned_whenInputTextInCache() {
        // act
        testMap.put('h', 1L);
        testMap.put('e', 1L);
        testMap.put('l', 3L);
        testMap.put('o', 2L);
        testMap.put('w', 1L);
        testMap.put('r', 1L);
        testMap.put('d', 1L);
        testMap.put('!', 1L);
        testMap.put(' ', 1L);

        // assert
        when(basicCharCounter.countInternal(TEST)).thenReturn(testMap);
        assertEquals(testMap, cacheCharCounter.countInternal(TEST));
        verify(basicCharCounter, times(1)).countInternal(TEST);
    }

    @Test
    void fillCacheMap_shouldReturnValueFromCache_whenPresent() {
        // act
        testMap.put('h', 1L);
        testMap.put('e', 1L);
        testMap.put('l', 3L);
        testMap.put('o', 2L);
        testMap.put('w', 1L);
        testMap.put('r', 1L);
        testMap.put('d', 1L);
        testMap.put('!', 1L);
        testMap.put(' ', 1L);
        when(cache.containsKey(TEST)).thenReturn(true);
        when(cache.get("hello world!")).thenReturn(testMap);

        // assert
        assertEquals(testMap, cacheCharCounter.countInternal(TEST));
        verify(basicCharCounter, never()).countInternal(anyString());
        verifyNoMoreInteractions(cache, basicCharCounter);
    }

    @Test
    void fillCacheMap_shouldCallCounterAndCacheValue_whenNotPresent() {
        // act
        testMap.put('h', 1L);
        testMap.put('e', 1L);
        testMap.put('l', 3L);
        testMap.put('o', 2L);
        testMap.put('w', 1L);
        testMap.put('r', 1L);
        testMap.put('d', 1L);
        testMap.put('!', 1L);
        testMap.put(' ', 1L);

        when(cache.containsKey(TEST)).thenReturn(false);
        when(basicCharCounter.countInternal(TEST)).thenReturn(testMap);

        // assert
        assertEquals(testMap, cacheCharCounter.countInternal(TEST));

        verify(basicCharCounter, times(1)).countInternal(TEST);
        verify(cache, times(1)).put(TEST, testMap);

        verifyNoMoreInteractions(cache, basicCharCounter);
    }

    @Test
    void fillCacheMap_shouldNotAcceptNull_whenInputNull() {
        // assert
        assertThrows(IllegalArgumentException.class, () -> cacheCharCounter.countInternal(null));
    }
}