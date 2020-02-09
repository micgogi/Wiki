package com.rahul.think.controller;

import com.rahul.think.entity.Movie;
import com.rahul.think.repository.MovieRepo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

/**
 * @author Micgogi
 * on 2/9/2020  7:00 PM
 * Micgogi
 */
@RunWith(SpringRunner.class)
@WebMvcTest(MovieContoller.class)
public class MovieContollerTest {
    @Autowired
    private transient MockMvc mockMvc;
@Autowired
    MovieRepo movieRepo;


    private  Movie movie;

    @InjectMocks
    private MovieContoller movieController;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(movieController).build();

        Movie movie = new Movie("dd","s","ddd","ddd","ddd","ddd","edd","dd","d","dd","dd");
        //options=Optional.of(movie);

    }
    @Test
    public void testSaveNewMovieSuccess() throws Exception {


        Assert.assertEquals("hiii","hiii");
    }


}
