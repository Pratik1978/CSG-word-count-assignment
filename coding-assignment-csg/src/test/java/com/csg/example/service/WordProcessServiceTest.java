package com.csg.example.service;

import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WordProcessServiceTest {

    private final WordProcessService wordProcessService = new WordProcessService();

    @Test
    void countWordsStartingWithM_ValidList_ReturnsCorrectCount() {
        List<String> words = Arrays.asList("moon", "magic", "sun", "micro", "star", "matter");
        int count = wordProcessService.countWordsStartingWithM(words);

        assertEquals(4, count);
    }

    @Test
    void countWordsStartingWithM_EmptyList_ReturnsZero() {
        List<String> words = Collections.emptyList();
        int count = wordProcessService.countWordsStartingWithM(words);

        assertEquals(0, count);
    }

    @Test
    void countWordsStartingWithM_NullList_ReturnsZero() {
        int count = wordProcessService.countWordsStartingWithM(null);

        assertEquals(0, count);
    }

    @Test
    void countWordsStartingWithM_ListWithNullValues_IgnoresNulls() {
        List<String> words = Arrays.asList("moon", null, "magic", "micro", "matter");
        int count = wordProcessService.countWordsStartingWithM(words);

        assertEquals(4, count);
    }

    @Test
    void getWordsLongerThanFiveCharacters_ValidList_ReturnsFilteredWords() {
        List<String> words = Arrays.asList("magic", "micro", "sun", "galaxy", "starry");
        List<String> result = wordProcessService.getWordsLongerThanFiveCharacters(words);

        assertEquals(Arrays.asList("galaxy", "starry"), result);
    }

    @Test
    void getWordsLongerThanFiveCharacters_EmptyList_ReturnsEmptyList() {
        List<String> words = Collections.emptyList();
        List<String> result = wordProcessService.getWordsLongerThanFiveCharacters(words);

        assertTrue(result.isEmpty());
    }

    @Test
    void getWordsLongerThanFiveCharacters_NullList_ThrowsException() {
        assertThrows(NullPointerException.class, () -> wordProcessService.getWordsLongerThanFiveCharacters(null));
    }

    @Test
    void getWordsLongerThanFiveCharacters_ListWithNullValues_IgnoresNulls() {
        List<String> words = Arrays.asList("magic", null, "muffin", "microservices", "sun", "micro", "galaxy");
        List<String> result = wordProcessService.getWordsLongerThanFiveCharacters(words);

        assertEquals(Arrays.asList("muffin", "microservices","galaxy", "starry"), result);
    }


}
