package com.csg.example.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WordProcessService {


    public int countWordsStartingWithM(List<String> words) {

        return Optional.ofNullable(words)
                .map(list -> (int) list.stream()
                        .filter(Objects::nonNull)
                        .filter(word -> word.toLowerCase().startsWith("m"))
                        .count())
                .orElse(0);

    }


    public List<String> getWordsLongerThanFiveCharacters(List<String> words) {

        return words.stream()
                .filter(Objects::nonNull) // Ensure we don't process null words
                .filter(word -> word.length() > 5)
                .collect(Collectors.toList());
    }
}
