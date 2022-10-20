package io.datajek.springbasics.movierecommendersystem.lesson6;

public interface Filter {
    public String[] getRecommendations(String movie);
}
