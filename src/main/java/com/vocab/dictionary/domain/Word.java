package com.vocab.dictionary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    private String eng1;
    private String eng2;
    private String eng3;
    private String rus;

    public Word(String eng1, String eng2, String eng3, String rus) {
        this.eng1 = eng1;
        this.eng2 = eng2;
        this.eng3 = eng3;
        this.rus = rus;
    }
}
