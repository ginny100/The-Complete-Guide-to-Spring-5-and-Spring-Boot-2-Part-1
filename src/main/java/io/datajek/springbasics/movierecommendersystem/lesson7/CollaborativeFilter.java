package io.datajek.springbasics.movierecommendersystem.lesson7;

import org.springframework.stereotype.Component;

@Component

public class CollaborativeFilter implements Filter{
    /**
     * Get similar movies based on the user's watch history
     * @param movie
     * @return a list of relevant movies
     */
    public String[] getRecommendations(String movie) {
        //logic of collaborative filter
        return new String[] {"Finding Nemo", "Ice Age", "Toy Story"};
    }
}