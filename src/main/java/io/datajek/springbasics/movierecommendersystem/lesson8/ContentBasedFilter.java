package io.datajek.springbasics.movierecommendersystem.lesson8;

import org.springframework.stereotype.Component;

@Component
public class ContentBasedFilter implements Filter{

    public ContentBasedFilter() {
        super();
        System.out.println("content-based filter constructor called");
    }

    //getRecommendations takes a movie as input and returns a list of similar movies

    /**
     * Get recommendations based on the user's watch history
     * @param movie
     * @return
     */
    public String[] getRecommendations(String movie) {

        //implement logic of content based filter

        //return movie recommendations
        return new String[] {"Happy Feet", "Ice Age", "Shark Tale"};
    }
}