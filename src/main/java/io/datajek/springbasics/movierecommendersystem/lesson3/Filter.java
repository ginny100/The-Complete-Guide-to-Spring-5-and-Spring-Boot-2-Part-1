package io.datajek.springbasics.movierecommendersystem.lesson3;

public interface Filter {
    public String[] getRecommendations(String movie);
}
