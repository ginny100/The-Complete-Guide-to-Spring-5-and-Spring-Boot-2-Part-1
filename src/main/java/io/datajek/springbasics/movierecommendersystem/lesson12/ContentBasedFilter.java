package io.datajek.springbasics.movierecommendersystem.lesson12;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ContentBasedFilter implements Filter{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Constructor
     */
    public ContentBasedFilter() {
        super();
        logger.info("In ContentBasedFilter constructor method");
    }

    /**
     * Post-construct method
     */
    @PostConstruct
    private void postConstruct() {
        //load movies into cache
        logger.info("In ContentBasedFilter postConstruct method");
    }

    /**
     * Pre-destroy method
     */
    @PreDestroy
    private void preDestroy() {
        //clear movies from cache
        logger.info("In ContentBasedFilter preDestroy method");
    }

    /**
     * Takes a movie as input and returns a list of similar movies
     * @param movie
     * @return a list of similar movies
     */
    public String[] getRecommendations(String movie) {
        //calculate similarity between movies
        //return movie recommendations
        return new String[] {"Happy Feet", "Ice Age", "Shark Tale"};
    }
}