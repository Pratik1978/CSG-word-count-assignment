package com.csg.example.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import com.csg.example.api.request.WordProcessRequest;
import com.csg.example.exception.InvalidWordRequestException;
import com.csg.example.service.WordProcessService;

@ExtendWith(MockitoExtension.class)
public class WordProcessControllerTest {

    @InjectMocks
    private WordProcessController wordProcessController;

    @Mock
    private WordProcessService wordProcessService;

    private WordProcessRequest validRequest;
    private WordProcessRequest emptyRequest;


    @BeforeEach
    void setUp() {
        validRequest = new WordProcessRequest(Arrays.asList("muffin", "microservices", "sun", "micro", "galaxy"));
        emptyRequest = new WordProcessRequest(Collections.emptyList());
    }


    @Test
    void countWordsStartingWithM_ValidRequest_ReturnsCount() {
        when(wordProcessService.countWordsStartingWithM(validRequest.getWords())).thenReturn(3);

        ResponseEntity<Map<String, Integer>> response = wordProcessController.countWordsStartingWithM(validRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(3, response.getBody().get("Count of words starting with m or M"));
        verify(wordProcessService, times(1)).countWordsStartingWithM(validRequest.getWords());
    }

    @Test
    void countWordsStartingWithM_InvalidRequest_ThrowsException() {
        assertThrows(InvalidWordRequestException.class, () -> wordProcessController.countWordsStartingWithM(null));
        assertThrows(InvalidWordRequestException.class, () -> wordProcessController.countWordsStartingWithM(emptyRequest));
    }

    @Test
    void getWordsLongerThanFiveCharacters_ValidRequest_ReturnsFilteredWords() {

        List<String> expectedWords = Arrays.asList("muffin", "microservices","galaxy");
        when(wordProcessService.getWordsLongerThanFiveCharacters(validRequest.getWords())).thenReturn(expectedWords);
        ResponseEntity<List<String>> response = wordProcessController.getWordsLongerThanFiveCharacters(validRequest);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedWords, response.getBody());

    }
}