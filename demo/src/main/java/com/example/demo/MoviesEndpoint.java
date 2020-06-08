package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static java.util.Objects.requireNonNull;

@RequestMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
public class MoviesEndpoint {

  private final MovieService movieService;

  public MoviesEndpoint(MovieService movieService) {
    this.movieService = requireNonNull(movieService);
  }


  
  @GetMapping("/toplist")
  public ResponseEntity<List<Movie>> getTopList() {
    List<Movie> movies = movieService.getTopList();
    return ResponseEntity.ok(movies);
  }
}
