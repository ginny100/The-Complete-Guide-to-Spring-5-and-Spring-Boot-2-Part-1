package io.datajek.springbasics.movierecommendersystem.lesson2;

public class ContentBasedFilter implements Filter {
    /**
     * Get similar movies based on the user's watch history
     * @param movie
     * @return a list of relevant movies
     */
    public String[] getRecommendations(String movie) {

        //implement logic of content based filter

        //return movie recommendations
        return new String[] {"Happy Feet", "Ice Age", "Shark Tale"};
    }
}
