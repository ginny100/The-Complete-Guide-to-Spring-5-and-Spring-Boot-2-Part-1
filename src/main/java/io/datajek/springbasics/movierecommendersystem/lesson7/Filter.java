package io.datajek.springbasics.movierecommendersystem.lesson7;

public interface Filter {
    public String[] getRecommendations(String movie);
}
