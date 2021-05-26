package com.codegym.service.impl;

import com.codegym.model.Dictionary;
import com.codegym.service.DictionaryService;

import java.util.HashMap;
import java.util.Map;

public class DictionaryServiceImpl implements DictionaryService {
    private static Map<String, Dictionary> dictionaries;

    static {
        dictionaries = new HashMap<>();
        dictionaries.put("Hello", new Dictionary(1, "Xin chao"));
        dictionaries.put("Bye", new Dictionary(2, "Tam biet"));
        dictionaries.put("Morning", new Dictionary(3, "Buoi sang"));
    }

    @Override
    public Dictionary findOne(String word) {
        return dictionaries.get(word);
    }
}
