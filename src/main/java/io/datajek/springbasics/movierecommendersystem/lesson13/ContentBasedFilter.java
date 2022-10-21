package io.datajek.springbasics.movierecommendersystem.lesson13;

import javax.inject.Named;
import org.springframework.beans.factory.annotation.Qualifier;

@Named
@Qualifier("CBF")
public class ContentBasedFilter implements Filter{

    /**
     * Takes a movie as input and returns a list of similar movies
     * @param movie
     * @return a list of similar movies
     */
    public String[] getRecommendations(String movie) {
        //implement logic of content based filter
        return new String[] {"Happy Feet", "Ice Age", "Shark Tale"};
    }
}