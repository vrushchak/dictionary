package com.vocab.dictionary.services;

import com.vocab.dictionary.domain.Word;
import com.vocab.dictionary.repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("wordService")
public class WordServiceImpl implements WordService {
    @Autowired
    private WordRepository wordRepository;

    @Override
    public List<Word> getAllWords() {
        return wordRepository.findAll();
    }

    @Override
    public Word getWordById(Long id) {
        return wordRepository.findById(id).get();
    }
}
