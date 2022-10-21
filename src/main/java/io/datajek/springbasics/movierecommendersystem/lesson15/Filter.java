package io.datajek.springbasics.movierecommendersystem.lesson15;

public interface Filter {
    public String[] getRecommendations(String movie);
}
