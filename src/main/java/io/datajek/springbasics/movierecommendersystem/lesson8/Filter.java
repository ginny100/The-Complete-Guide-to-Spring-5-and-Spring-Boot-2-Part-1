package io.datajek.springbasics.movierecommendersystem.lesson8;

public interface Filter {
    public String[] getRecommendations(String movie);
}
