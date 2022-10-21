package io.datajek.springbasics.movierecommendersystem.lesson17;

public interface Filter {
    public String[] getRecommendations(String movie);
}
