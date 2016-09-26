package ru.vkrepostcontest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Слова для поиска
 *
 * @author Stetskevich Roman on 08.09.2016.
 * @since 0.1
 */
@Entity
@Table(name = "word_find")
public class WordFind {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "word")
    private String word;

    @Enumerated(EnumType.STRING)
    private WordFindType wordFindType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public WordFindType getWordFindType() {
        return wordFindType;
    }

    public void setWordFindType(WordFindType wordFindType) {
        this.wordFindType = wordFindType;
    }
}
