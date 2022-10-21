package io.datajek.springbasics.movierecommendersystem.lesson13;

import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Qualifier;

@Named
public class RecommenderImplementation {

    @Inject
    @Qualifier("CF")
    private Filter filter;

    /**
     * Get the current filter
     * @return a filter
     */
    public Filter getFilter() {
        return filter;
    }

    /**
     * Use a filter to find recommendations
     * @param movie
     * @return
     */
    public String [] recommendMovies (String movie) {

        //print the name of interface implementation being used
        System.out.println("\nName of the filter in use: " + filter + "\n");

        String[] results = filter.getRecommendations("Finding Dory");

        return results;
    }
}