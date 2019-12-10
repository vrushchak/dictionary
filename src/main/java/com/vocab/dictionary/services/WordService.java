package com.vocab.dictionary.services;

import com.vocab.dictionary.domain.Word;

import java.util.List;

public interface WordService {
    public List<Word> getAllWords();
    public Word getWordById(Long id);
}
