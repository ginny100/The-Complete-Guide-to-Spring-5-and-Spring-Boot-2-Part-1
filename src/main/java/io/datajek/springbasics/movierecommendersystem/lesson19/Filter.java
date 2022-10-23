package io.datajek.springbasics.movierecommendersystem.lesson19;

public interface Filter {
    public String[] getRecommendations(String movie);
}
