package com.company.algorithm.other;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMap {
    private Map<String, List<String>> map = new HashMap<>();

    public List<String> getVal(String key) {
        if (map.get(key) == null) {
            map.put(key, new ArrayList<>(Arrays.asList("aa")));
        }
        return map.getOrDefault(key, new ArrayList<>());
    }
}
