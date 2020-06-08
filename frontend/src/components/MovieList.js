import React from 'react';
import './MovieList.css';

const MovieList = ({ movies }) => {
  return (
    <div className='movie-list'>
      <table>
        <thead>
          <th>Rank</th>
          <th>Title</th>
          <th>Ranked Date</th>
        </thead>
        <tbody>
          {movies.map(movie => (
            <tr>
              <td>{movie.rank}</td>
              <td>{movie.title}</td>
              <td>{movie.rankedDate}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  )
};

export { MovieList };
