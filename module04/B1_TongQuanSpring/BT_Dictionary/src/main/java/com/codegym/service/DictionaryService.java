package com.codegym.service;

import com.codegym.model.Dictionary;

public interface DictionaryService {
    Dictionary findOne(String word);
}
