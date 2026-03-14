import { Link } from "react-router-dom";
import Navbar from "../components/Navbar";

function Home() {
  return (
        <>
      <Navbar />
    
    <div className="home-container">
      <div className="home-card">
        <h1>Ticket Resolution System</h1>
        <p>Manage customer issues efficiently & professionally.</p>

        <div className="home-buttons">
          <Link to="/login" className="btn primary-btn">Login</Link>
          <Link to="/register" className="btn secondary-btn">Register</Link>
        </div>
      </div>
    </div>
    </>
   
  );
}

export default Home;