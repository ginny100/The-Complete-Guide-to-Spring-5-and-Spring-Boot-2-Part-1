package io.datajek.springbasics.movierecommendersystem.lesson2;

public class RecommenderImplementation {

    //use filter interface to select filter
    private Filter filter;

    public RecommenderImplementation(Filter filter) {
        super();
        this.filter = filter;
    }

    /**
     * Use a filter to find recommendations
     * @param movie
     * @return a list of similar movies
     */
    public String [] recommendMovies (String movie) {

        //print the name of interface implementation being used
        System.out.println("Name of the filter in use: " + filter + "\n");

        String[] results = filter.getRecommendations("Finding Dory");

        //return the results
        return results;
    }
}
