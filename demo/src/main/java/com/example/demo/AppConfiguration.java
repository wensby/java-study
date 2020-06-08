package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

  @Bean
  public NaverCrawler naverCrawler() {
    return new NaverCrawler();
  }

  @Bean
  public MoviesEndpoint moviesEndpoint(MovieService movieService) {
    return new MoviesEndpoint(movieService);
  }

  @Bean
  public MovieService movieService(NaverCrawler naverCrawler) {
    return new MovieService(naverCrawler);
  }
}
