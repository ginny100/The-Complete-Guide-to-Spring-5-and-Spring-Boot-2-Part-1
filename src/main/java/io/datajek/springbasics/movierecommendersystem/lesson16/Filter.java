package io.datajek.springbasics.movierecommendersystem.lesson16;

public interface Filter {
    public String[] getRecommendations(String movie);
}
