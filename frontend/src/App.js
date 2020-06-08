import React from 'react';
import { Navbar } from './components/Navbar';
import { HomePage, MoviesPage } from './pages';
import { Route } from 'react-router';
import './App.css';

function App() {
  return (
    <div>
      <div className='logo'>Logo</div>
      <Navbar />
      <Route exact path='/'><HomePage /></Route>
      <Route path='/movies'><MoviesPage /></Route>
      <Route path='/music'>Music</Route>
    </div>
  );
}

export default App;
