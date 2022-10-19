package io.datajek.springbasics.movierecommendersystem.lesson2;

public interface Filter {
    public String[] getRecommendations(String movie);
}
