package io.datajek.springbasics.movierecommendersystem.lesson19;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

    //Filter is a dependency of RecommenderImplementation
    @Autowired
    private Filter filter;

    @Value("${recommender.implementation.favoriteMovie: Spirited Away}")
    private String favoriteMovie;

    /**
     * Constructor
     * @param filter
     */
    public RecommenderImplementation(Filter filter) {
        this.filter = filter;
    }

    /**
     * Filter Getter
     * @return a filter
     */
    public Filter getFilter() {
        return filter;
    }

    /**
     * Get the fav movie
     * @return name of the fav movie as a string
     */
    public String returnFavoriteMovie() {
        return favoriteMovie;
    }

    /**
     * Use a filter to find recommendations
     * @param movie
     * @return a list of similar movies
     */
    public String [] recommendMovies (String movie) {

        //print the name of interface implementation being used
        System.out.println("\nName of the filter in use: " + filter + "\n");

        String[] results = filter.getRecommendations(movie);

        return results;
    }

}
