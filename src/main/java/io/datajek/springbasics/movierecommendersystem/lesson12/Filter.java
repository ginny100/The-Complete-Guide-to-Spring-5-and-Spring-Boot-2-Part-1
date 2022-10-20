package io.datajek.springbasics.movierecommendersystem.lesson12;

public interface Filter {
    public String[] getRecommendations(String movie);
}