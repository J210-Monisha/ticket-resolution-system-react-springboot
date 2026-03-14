import { useEffect, useState } from "react";
import api from "../api/axiosConfig";
import { Link } from "react-router-dom";
import Navbar from "../components/Navbar";

function AdminDashboard() {
  const [stats, setStats] = useState({ total: 0, open: 0, resolved: 0 });
  const [tickets, setTickets] = useState([]);

  useEffect(() => {
    const fetchTickets = async () => {
      try {
        const res = await api.get("/ticket/all");
        const allTickets = res.data;

        setTickets(allTickets);

        setStats({
  total: allTickets.length,
  open: allTickets.filter(
    t => t.ticketStatus === "OPEN" || t.ticketStatus === "IN_PROGRESS"
  ).length,
  resolved: allTickets.filter(t => t.ticketStatus === "RESOLVED").length
});
      } catch (err) {
        console.error(err);
      }
    };

    fetchTickets();
  }, []);

  return (
     <>
      <Navbar /> {/* Only wrap in Layout, header/footer come from Layout */}
      <div className="home-container">
        <div className="dashboard-card-box">
          <h2>Admin Dashboard</h2>

          <div className="dashboard-stats">
            <div className="stat-card total">📝 Total Tickets <span>{stats.total}</span></div>
            <div className="stat-card pending">⏳ Active <span>{stats.open}</span></div>
            <div className="stat-card resolved">✅ Resolved <span>{stats.resolved}</span></div>
          </div>

          <div className="dashboard-actions">
            <Link to="/all-tickets" className="dashboard-btn">📋 View All Tickets</Link>
            <Link to="/assign-executive" className="dashboard-btn">➕ Assign Executive</Link>
            <Link to="/stats" className="dashboard-btn">📊 Ticket Statistics</Link>
          </div>
        </div>
      </div>
    </>
  );
}

export default AdminDashboard;
