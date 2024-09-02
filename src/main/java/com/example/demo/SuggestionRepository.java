package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SuggestionRepository {

    private final Map<String, Suggestion> map = HashMap.newHashMap(2);

    public SuggestionRepository() {
        map.put("bergen", new Suggestion(12, "sunglasses"));
    }

    public Map<String, Suggestion> getMap() {
        return map;
    }
}
