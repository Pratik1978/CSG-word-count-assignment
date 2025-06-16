package com.csg.example.controller;

import com.csg.example.api.request.WordProcessRequest;
import com.csg.example.exception.InvalidWordRequestException;
import com.csg.example.service.WordProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class WordProcessController {

    @Autowired
    private WordProcessService wordProcessService;

    @PostMapping("/count-starting-with-m")
    public ResponseEntity<Map<String, Integer>> countWordsStartingWithM(@RequestBody(required = false) WordProcessRequest request) {
        validateRequest(request);
        int count = wordProcessService.countWordsStartingWithM(request.getWords());
        return ResponseEntity.ok(Collections.singletonMap("Count of words starting with m or M", count));
    }

    @PostMapping("/longer-than-five")
    public ResponseEntity<List<String>> getWordsLongerThanFiveCharacters(@RequestBody(required = false) WordProcessRequest request) {
        validateRequest(request);
        return ResponseEntity.ok(wordProcessService.getWordsLongerThanFiveCharacters(request.getWords()));
    }



    private void validateRequest(WordProcessRequest request) {
        if (request == null || request.getWords() == null || request.getWords().isEmpty()) {
            throw new InvalidWordRequestException("Request body or words list is missing.");
        }
    }


}

