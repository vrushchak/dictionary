package com.vocab.dictionary.controllers;

import com.vocab.dictionary.domain.Word;
import com.vocab.dictionary.repositories.WordRepository;
import com.vocab.dictionary.services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private WordRestController wordRestController;

    @GetMapping("/")
    public String main (Map<String, Object> model){
        List<Word> words = wordRepository.findAll();
        model.put("words", words);
        return "index";
    }

    @PostMapping("/add")
    public String add(
            @RequestParam String eng1,
            String eng2,
            String eng3,
            @RequestParam String rus,
            Map<String, Object> model) {
        Word word = new Word(eng1, eng2, eng3, rus);


        List<Word> wordEngFroDb = wordRepository.findByEng1(eng1);
        if(!wordEngFroDb.isEmpty()){
            model.put("exist", "This word already exists");
        } else {
            wordRepository.save(word);
            model.put("addnew", "New word added");
        }

        List<Word> words = wordRepository.findAll();
        model.put("words", words);

        wordRestController.getAllWords();

        return "index";
    }

//    @PostMapping("/filter_eng")
//    public String filterEng(String word, Map<String, Object> model){
//        Iterable<Word> words;
//        if (word != null && !word.isEmpty()) {
//            words = wordRepository.findByEng1Containing(word);
//        } else {
//            words = wordRepository.findAll(Sort.by(Sort.Direction.ASC, "eng1"));
//        }
//        model.put("words", words);
//        return "index";
//    }
//
//    @PostMapping("/filter_rus")
//    public String filterRus(String word, Map<String, Object> model){
//        Iterable<Word> words;
//        if (word != null && !word.isEmpty()) {
//            words = wordRepository.findByRusContaining(word);
//        } else {
//            words = wordRepository.findAll(Sort.by(Sort.Direction.ASC, "eng1"));
//        }
//        model.put("words", words);
//        return "index";
//    }
}
