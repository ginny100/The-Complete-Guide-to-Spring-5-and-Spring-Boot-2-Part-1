package io.datajek.springbasics.movierecommendersystem.lesson2;

public class CollaborativeFilter implements Filter {
    /**
     * Get similar movies based on the user's watch history
     * @param movie
     * @return a list of relevant movies
     */
    public String[] getRecommendations(String movie) {
        //logic of content based filter
        return new String[] {"Finding Nemo", "Ice Age", "Toy Story"};
    }
}
