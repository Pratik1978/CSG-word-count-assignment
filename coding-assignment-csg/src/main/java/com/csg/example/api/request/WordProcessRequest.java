package com.csg.example.api.request;

import java.util.List;

public class WordProcessRequest {


    private List<String> words;

    public WordProcessRequest(List<String> words) {
        this.words = words;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }
}
