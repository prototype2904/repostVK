package ru.vkrepostcontest.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Stetskevich Roman on 08.09.2016.
 * @since 0.1
 */
public interface WordFindRepository extends JpaRepository<WordFind, Long>{

    List<WordFind> findAllByWordFindType(WordFindType wordFindType);
}
