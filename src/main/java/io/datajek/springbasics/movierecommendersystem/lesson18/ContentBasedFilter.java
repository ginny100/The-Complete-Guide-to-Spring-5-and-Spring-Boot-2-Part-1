package io.datajek.springbasics.movierecommendersystem.lesson18;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentBasedFilter implements Filter{

    @Autowired
    private Movie movie;

    /**
     * Constructor
     */
    public ContentBasedFilter() {
        super();
    }

    /**
     * Takes a movie as input and returns a list of similar movies
     * @param movie
     * @return a list of similar movies
     */
    public String[] getRecommendations(String movie) {
        //calculate similarity between movies

        //return movie recommendations
        return new String[] {"Happy Feet", "Ice Age", "Shark Tale"};
    }

}