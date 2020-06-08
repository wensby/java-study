package com.example.demo;

import java.util.List;

public class MovieService {

  private final NaverCrawler naverCrawler;
  private List<Movie> movies;

  public MovieService(NaverCrawler naverCrawler) {
    this.naverCrawler = naverCrawler;
    this.movies = List.of();
  }

  public List<Movie> getTopList() {
    if (movies.isEmpty())  {
      movies = naverCrawler.crawlTopListMovies();
    }
    return movies;
  }
}
