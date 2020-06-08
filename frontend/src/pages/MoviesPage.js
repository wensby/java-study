import React, { useEffect, useState } from 'react';
import { MovieList } from  '../components/MovieList';

const MoviesPage = () => {
  const [movies, setMovies] = useState([]);
  
  useEffect(() => {
    const fetchData = async () => {
      const response = await fetch('http://localhost:8080/movies/toplist');
      if (response.status === 200) {
        const json = await response.json();
        setMovies(json);
      }
      else {
        console.log('failed to fetch: ' + response.status);
      }
    }
    fetchData();
  }, []);

  return <MovieList movies={movies}/>
}

export default MoviesPage;
