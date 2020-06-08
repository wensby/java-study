package com.example.demo;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;

class MoviesEndpointTest {

  @Test
  void getTopListReturnsListFromService() {
    Movie parasite = Movie.builder()
        .rank(1)
        .title("Parasite")
        .rankedDate(LocalDate.now())
        .build();
    MovieService movieService = mock(MovieService.class);
    MoviesEndpoint endpoint = new MoviesEndpoint(movieService);
    when(movieService.getTopList()).thenReturn(List.of(parasite));

    ResponseEntity<List<Movie>> response = endpoint.getTopList();

    assertThat(response.getStatusCode(), is(OK));
    assertThat(response.getBody(), is(List.of(parasite)));
  }
}