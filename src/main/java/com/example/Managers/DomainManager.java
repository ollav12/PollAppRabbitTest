package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DomainManager {

    private final Map<String, DomainManager> map = HashMap.newHashMap(2);

    public DomainManager() {
        map.put("bergen", new DomainManager("s", "s"));
    }

    public Map<String, DomainManager> getMap() {
        return map;
    }
}
