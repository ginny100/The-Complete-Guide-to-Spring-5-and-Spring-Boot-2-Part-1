package io.datajek.springbasics.movierecommendersystem.lesson11;

public interface Filter {
    public String[] getRecommendations(String movie);
}