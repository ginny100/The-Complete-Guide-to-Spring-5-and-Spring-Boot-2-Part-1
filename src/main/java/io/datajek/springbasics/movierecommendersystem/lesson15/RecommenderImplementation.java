package io.datajek.springbasics.movierecommendersystem.lesson15;

public class RecommenderImplementation {

    private Filter filter;

    /**
     * Setter method
     * @param filter
     */
    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    /**
     * Getter method
     * @return a filter object
     */
    public Filter getFilter() {
        return filter;
    }

    /**
     * Constructor with no params
     */
    public RecommenderImplementation() {
    }

    /**
     * Constructor
     * @param filter
     */
    public RecommenderImplementation(Filter filter) {
        this.filter = filter;
    }

    /**
     * Use a filter to find recommendations
     * @param movie
     * @return a list of recommendations
     */
    public String [] recommendMovies (String movie) {

        //print the name of interface implementation being used
        System.out.println("\nName of the filter in use: " + filter + "\n");

        String[] results = filter.getRecommendations("Finding Dory");

        return results;
    }

}