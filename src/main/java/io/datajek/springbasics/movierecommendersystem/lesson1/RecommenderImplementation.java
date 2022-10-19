package io.datajek.springbasics.movierecommendersystem.lesson1;

public class RecommenderImplementation {
    /**
     * Use content-based filter to find similar movies
     * @param movie
     * @return a list of similar movies
     */
    public String [] recommendMovies (String movie) {

        //use content based filter to find similar movies

        ContentBasedFilter filter = new ContentBasedFilter();
        String[] results = filter.getRecommendations("Finding Dory");

        //return the results
        //return new String[] {"M1", "M2", "M3"};
        return results;
    }
}
