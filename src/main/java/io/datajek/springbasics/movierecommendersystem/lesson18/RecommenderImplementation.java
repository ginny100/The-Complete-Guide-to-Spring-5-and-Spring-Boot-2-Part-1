package io.datajek.springbasics.movierecommendersystem.lesson18;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommenderImplementation {

    //Filter is a dependency of RecommenderImplementation
    @Autowired
    private Filter filter;

    public RecommenderImplementation(Filter filter) {
        this.filter = filter;
    }

    public Filter getFilter() {
        return filter;
    }

    /**
     * Use a filter to find recommendations
     * @param movie
     * @return a list of recommendations
     */
    public String [] recommendMovies (String movie) {

        //print the name of interface implementation being used
        System.out.println("\nName of the filter in use: " + filter + "\n");

        String[] results = filter.getRecommendations(movie);

        return results;
    }

}