import React from 'react';
import { Link } from 'react-router-dom';

const Navbar = () => {
  return <div className='navbar'>
    <Link to='/'>Home</Link>
    <Link to='/movies'>Movies</Link>
    <Link to='/music'>Music</Link>
  </div>;
}

export { Navbar };
