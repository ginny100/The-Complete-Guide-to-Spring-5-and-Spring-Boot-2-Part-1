package io.datajek.springbasics.movierecommendersystem.lesson17;

import org.springframework.beans.factory.annotation.Autowired;

public class RecommenderImplementation {

    @Autowired
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