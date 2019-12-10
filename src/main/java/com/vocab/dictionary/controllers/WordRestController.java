package com.vocab.dictionary.controllers;

import com.vocab.dictionary.domain.Word;
import com.vocab.dictionary.services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WordRestController {
    @Autowired
    private WordService wordService;

    @RequestMapping(path="/word", method= RequestMethod.GET)
    public List<Word> getAllWords(){
        return wordService.getAllWords();
    }
    @RequestMapping(value = "/word/{id}", method = RequestMethod.GET)
    public Word getEmployeeById(@PathVariable("id") long id){
        return wordService.getWordById(id);
    }
}
