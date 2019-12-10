package com.vocab.dictionary.repositories;

import com.vocab.dictionary.domain.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("wordRepository")
public interface WordRepository extends JpaRepository<Word, Long> {
    List<Word> findByEng1Containing(String word);
    List<Word> findByEng1(String word);
    List<Word> findByRusContaining(String word);
}
