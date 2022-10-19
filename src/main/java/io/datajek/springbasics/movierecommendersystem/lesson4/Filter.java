package io.datajek.springbasics.movierecommendersystem.lesson4;

public interface Filter {
    public String[] getRecommendations(String movie);
}
