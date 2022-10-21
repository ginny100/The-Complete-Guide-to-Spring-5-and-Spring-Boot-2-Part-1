package io.datajek.springbasics.movierecommendersystem.lesson18;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

@Repository
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Movie {
    private int id;
    private String name;
    private String genre;
    private String producer;

    public Movie() {
        super();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getProducer() {
        return producer;
    }

    public double movieSimilarity(Movie movie2) {

        double similarity = 0.0;
        //if genres are same add 0.3 to similarity
        //if producers are same add 0.5 to similarity
        return similarity;
    }

}