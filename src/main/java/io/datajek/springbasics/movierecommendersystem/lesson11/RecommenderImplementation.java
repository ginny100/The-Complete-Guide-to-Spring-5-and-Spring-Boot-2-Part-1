package io.datajek.springbasics.movierecommendersystem.lesson11;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Filter filter;

    /**
     * Setter method
     * @param filter
     */
    @Autowired
    public void setFilter(Filter filter) {
        logger.info("In RecommenderImplementation setter method..dependency injection");
        this.filter = filter;
    }

    /**
     * Use a filter to find recommendations
     * @param movie
     * @return
     */
    public String [] recommendMovies (String movie) {

        String[] results = filter.getRecommendations("Finding Dory");
        return results;
    }

    /**
     * Post-construct method
     */
    @PostConstruct
    public void postConstruct() {
        //initialization code
        logger.info("In RecommenderImplementation postConstruct method");
    }

    /**
     * Pre-destroy method
     */
    @PreDestroy
    public void preDestroy() {
        //cleanup code
        logger.info("In RecommenderImplementation preDestroy method");
    }
}