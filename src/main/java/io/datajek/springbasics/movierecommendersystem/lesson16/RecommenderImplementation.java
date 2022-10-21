package io.datajek.springbasics.movierecommendersystem.lesson16;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class RecommenderImplementation {

    @Autowired
    @Qualifier("contentBasedFilter")
    private Filter filter;

    /**
     * Getter method
     * @return
     */
    public Filter getFilter() {
        return filter;
    }

    /**
     * Setter method
     * @param filter
     */
    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    /**
     * Use content based filter to find similar movies
     * @param movie
     * @return
     */
    public String[] recommendMovies (String movie) {
        System.out.println("Name of the filter in use: " + filter + "\n");

        String[] results = filter.getRecommendations("Finding Dory");

        return results;
    }
}