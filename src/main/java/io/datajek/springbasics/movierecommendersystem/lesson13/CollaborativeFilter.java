package io.datajek.springbasics.movierecommendersystem.lesson13;

import javax.inject.Named;
import org.springframework.beans.factory.annotation.Qualifier;

@Named
@Qualifier("CF")
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