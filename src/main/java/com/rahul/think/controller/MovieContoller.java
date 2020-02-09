package com.rahul.think.controller;

import com.rahul.think.entity.Movie;
import com.rahul.think.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Micgogi
 * on 2/9/2020  5:55 PM
 * Micgogi
 */
@RestController
public class MovieContoller {
    @Autowired
    MovieRepo movieRepo;
    @GetMapping("/movieList")
    public ResponseEntity<?> getAllMovie(){

        return  new ResponseEntity<>(movieRepo.findAll(), HttpStatus.OK);
    }
    @GetMapping("/movieByTitle/{title}")
    public ResponseEntity<Movie> getMovieByTitle(@PathVariable String title){

        return  new ResponseEntity<Movie>(movieRepo.findByTitle(title), HttpStatus.OK);
    }
    //localhost:8090/getMovie/title/desc
    //localhost:8090/getMovie/title/asc
    @GetMapping("/getMovie/{sortedBy}/{sortedOrder}")
    public ResponseEntity<?> getMovieDescendingOrder(@PathVariable String sortedBy,
                                                     @PathVariable String sortedOrder){
        List<Movie> movieList = movieRepo.findAll();
        if(sortedBy.equals("title")) {
            if(sortedOrder.equals("asc")) {
                TitleCompare tc = new TitleCompare();
                Collections.sort(movieList, tc);
                return new ResponseEntity<>(movieList, HttpStatus.OK);
            }
            if(sortedOrder.equals("desc")) {
                TitleCompare tc = new TitleCompare();
                Collections.sort(movieList, tc.reversed());
                return new ResponseEntity<>(movieList, HttpStatus.OK);
            }
        }
return new ResponseEntity<>(movieList,HttpStatus.OK);
    }
}
class TitleCompare implements Comparator<Movie>
{
    public int compare(Movie m1, Movie m2)
    {
        return m1.getTitle().compareTo(m2.getTitle());
    }
}
class ReleaseComapsre implements Comparator<Movie>{

    @Override
    public int compare(Movie o1, Movie o2) {
        return 0;
    }
}
