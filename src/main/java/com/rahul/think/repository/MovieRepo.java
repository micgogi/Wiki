package com.rahul.think.repository;

import com.rahul.think.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Micgogi
 * on 2/9/2020  5:49 PM
 * Micgogi
 */
@Repository
public interface MovieRepo extends JpaRepository<Movie,Integer> {
    Movie findByTitle(String title);
}
