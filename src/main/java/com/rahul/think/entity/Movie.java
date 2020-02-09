package com.rahul.think.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Micgogi
 * on 2/9/2020  2:45 PM
 * Micgogi
 */
@Entity
public class Movie implements Comparable<Movie> {
   @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
           @JsonIgnore
    int id;
    String title;
    String directors;
    String producer;
    String actors;




    String musicComposer;
    String productionHouse;
    String releaseDate;
    String duration;
    String language;
    String budget;
    String budgetOfficeCollection;
    public Movie(){

    }
    public Movie(String title, String actor, String director, String producer, String musicComposer, String productionHouse, String releaseDate, String duration, String language, String budget, String budgetOfficeCollection) {
        this.title = title;
        this.actors = actor;
        this.directors = director;
        this.producer = producer;
        this.musicComposer = musicComposer;
        this.productionHouse = productionHouse;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.language = language;
        this.budget = budget;
        this.budgetOfficeCollection = budgetOfficeCollection;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActor() {
        return actors;
    }

    public void setActor(String actor) {
        this.actors = actor;
    }

    public String getDirector() {
        return directors;
    }

    public void setDirector(String director) {
        this.directors = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getMusicComposer() {
        return musicComposer;
    }

    public void setMusicComposer(String musicComposer) {
        this.musicComposer = musicComposer;
    }

    public String getProductionHouse() {
        return productionHouse;
    }

    public void setProductionHouse(String productionHouse) {
        this.productionHouse = productionHouse;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getBudgetOfficeCollection() {
        return budgetOfficeCollection;
    }

    public void setBudgetOfficeCollection(String budgetOfficeCollection) {
        this.budgetOfficeCollection = budgetOfficeCollection;
    }


    @Override
    public int compareTo(Movie o) {
        return o.title.compareTo(this.title);
    }
}
