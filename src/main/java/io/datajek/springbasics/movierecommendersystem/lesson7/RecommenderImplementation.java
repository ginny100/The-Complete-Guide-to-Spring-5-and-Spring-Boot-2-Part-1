package io.datajek.springbasics.movierecommendersystem.lesson7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

    private Filter filter;

    //constructor injection
    @Autowired
    public RecommenderImplementation(@Qualifier("collaborativeFilter") Filter filter) {
        super();
        this.filter = filter;
        System.out.println("Constructor invoked...");
    }

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