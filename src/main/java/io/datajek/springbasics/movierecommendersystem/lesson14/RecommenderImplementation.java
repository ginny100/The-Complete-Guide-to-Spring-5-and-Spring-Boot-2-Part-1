package io.datajek.springbasics.movierecommendersystem.lesson14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

    //Autowiring by name
    @Autowired
    //@Qualifier("CBF")
    @Qualifier("CF")
    private Filter filter;

    /**
     * Use a filter to find recommendations
     * @param movie
     * @return a list of similar movies
     */
    public String [] recommendMovies (String movie) {

        //print the name of interface implementation being used
        System.out.println("\nName of the filter in use: " + filter + "\n");

        String[] results = filter.getRecommendations("Finding Dory");

        return results;
    }

}
