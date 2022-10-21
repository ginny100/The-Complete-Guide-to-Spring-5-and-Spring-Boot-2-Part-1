package io.datajek.springbasics.movierecommendersystem.lesson18;

public interface Filter {
    public String[] getRecommendations(String movie);
}