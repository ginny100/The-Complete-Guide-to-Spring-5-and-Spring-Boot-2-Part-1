package io.datajek.springbasics.movierecommendersystem.lesson10;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CollaborativeFilter implements Filter {

    public CollaborativeFilter() {
        super();
        System.out.println("collaborative filter constructor called");
    }

    /**
     * Get recommendations based on the user's watch history
     * @param movie
     * @return a list of similar movies
     */
    public String[] getRecommendations(String movie) {

        //implement logic of collaborative filter

        //return movie recommendations
        return new String[] {"Finding Nemo", "Ice Age", "Toy Story"};
    }
}