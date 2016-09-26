package ru.vkrepostcontest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vkrepostcontest.domain.WordFind;
import ru.vkrepostcontest.domain.WordFindRepository;
import ru.vkrepostcontest.domain.WordFindType;

import java.util.List;

/**
 * @author Stetskevich Roman on 08.09.2016.
 * @since 0.1
 */
@Service
public class WordFindService {

    @Autowired
    private WordFindRepository wordFindRepository;

    public WordFind save(WordFind wordFind){
        return wordFindRepository.save(wordFind);
    }

    public List<WordFind> findAll(){
        return wordFindRepository.findAll();
    }

    public List<WordFind> findAllByType(WordFindType wordFindType){
        return wordFindRepository.findAllByWordFindType(wordFindType);
    }
}
