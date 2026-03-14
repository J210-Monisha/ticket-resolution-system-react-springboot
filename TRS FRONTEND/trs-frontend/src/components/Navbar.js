import React from "react";
import { Link, useNavigate } from "react-router-dom";

function Navbar() {
  const navigate = useNavigate();
  const username = localStorage.getItem("username");
  const isLoggedIn = !!localStorage.getItem("username");

  const handleLogout = () => {
    const confirmLogout = window.confirm("Are you sure you want to logout?");
    if (!confirmLogout) return;

    localStorage.clear();
    navigate("/login");
  };

  return (
    <header className="navbar-custom">
      <Link to="/" className="logo">TRS</Link>

      <nav className="nav-buttons">
             <Link to="/" className="btn nav-btn">Home</Link>
               {isLoggedIn && (
            <button onClick={handleLogout} className="btn logout-btn">
              Logout
            </button>
        )}
      </nav>
    </header>
  );
}

export default Navbar;