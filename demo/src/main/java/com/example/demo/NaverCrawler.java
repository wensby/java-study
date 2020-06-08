package com.example.demo;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NaverCrawler {

  private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd");

  public List<Movie> crawlTopListMovies() {
    System.out.println("crawling");
    Document document = getMovieRankDocument();
    Elements titles = document.select("div.tit3");
    Element date = document.selectFirst("p.r_date");
    LocalDate rankedDate = LocalDate.parse(date.text(), DATE_TIME_FORMATTER);

//    List<Movie> movies = new ArrayList<>();
//    for (int i = 0; i < titles.size(); i++) {
//      Movie movie = Movie.builder()
//          .rank(i + 1)
//          .title(titles.get(i).text())
//          .rankedDate(rankedDate)
//          .build();
//      movies.add(movie);
//    }
//    return movies;

    return IntStream.range(0, titles.size())
        .mapToObj(i -> Movie.builder()
            .rank(i + 1)
            .title(titles.get(i).text())
            .rankedDate(rankedDate)
            .build())
        .collect(Collectors.toList());
  }

  private Document getMovieRankDocument() {
    try {
      String url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn";
      Connection.Response homepage = Jsoup.connect(url)
          .method(Connection.Method.GET)
          .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
          .execute();
      return homepage.parse();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
