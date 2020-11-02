package com.techelevator.moviereviews.dto;

import java.util.ArrayList;
import java.util.List;

public class MovieReviewDTO {

    private String movieTitle;
    private List<String> reviews = new ArrayList<>();

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }

    public void addReview(String movieTitle){
        reviews.add(movieTitle);
    }
}
