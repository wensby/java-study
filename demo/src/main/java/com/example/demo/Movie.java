package com.example.demo;

import java.time.LocalDate;

import static java.util.Objects.requireNonNull;

public class Movie {

  private final int rank;
  private final String title;
  private final LocalDate rankedDate;

  public Movie(Builder builder) {
    this.rank = builder.rank;
    this.title = requireNonNull(builder.title);
    this.rankedDate = requireNonNull(builder.rankedDate);
  }

  public static Builder builder() {
    return new Builder();
  }

  public int getRank() {
    return rank;
  }

  public String getTitle() {
    return title;
  }

  public LocalDate getRankedDate() {
    return rankedDate;
  }

  @Override
  public String toString() {
    return "Movie{" +
        "rank=" + rank +
        ", title='" + title + '\'' +
        ", rankedDate=" + rankedDate +
        '}';
  }

  public static class Builder {

    private int rank;
    private String title;
    private LocalDate rankedDate;

    private Builder() {
    }

    public Builder rank(int rank) {
      this.rank = rank;
      return this;
    }

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder rankedDate(LocalDate rankedDate) {
      this.rankedDate = rankedDate;
      return this;
    }

    public Movie build() {
      return new Movie(this);
    }
  }
}
