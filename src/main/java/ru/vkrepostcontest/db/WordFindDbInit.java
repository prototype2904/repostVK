package ru.vkrepostcontest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vkrepostcontest.domain.WordFind;
import ru.vkrepostcontest.domain.WordFindType;
import ru.vkrepostcontest.service.WordFindService;

import javax.annotation.PostConstruct;

/**
 * @author Stetskevich Roman on 08.09.2016.
 * @since 0.1
 */
@Component
public class WordFindDbInit {

    @Autowired
    private WordFindService wordFindService;

    @PostConstruct
    public void init(){
        create("конкурс", WordFindType.CONTEST);
        create("розыгрыш", WordFindType.CONTEST);
        create("рассказать друзьям", WordFindType.REPOST);
        create("репост", WordFindType.REPOST);
    }

    private void create(String word, WordFindType wordFindType){
        WordFind wordFind = new WordFind();
        wordFind.setWordFindType(wordFindType);
        wordFind.setWord(word);
        wordFindService.save(wordFind);
    }
}
