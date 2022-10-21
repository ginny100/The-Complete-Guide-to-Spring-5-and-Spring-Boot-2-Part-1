package io.datajek.springbasics.movierecommendersystem.lesson13;

public interface Filter {
    public String[] getRecommendations(String movie);
}
