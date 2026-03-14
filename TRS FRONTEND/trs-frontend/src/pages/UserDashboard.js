import { useEffect, useState } from "react";
import api from "../api/axiosConfig"; // axios instance with JWT
import { Link } from "react-router-dom";
import Navbar from "../components/Navbar";

function UserDashboard() {
  const [stats, setStats] = useState({ total: 0, pending: 0, resolved: 0 });
  const [tickets, setTickets] = useState([]);
  const userId = localStorage.getItem("userId");

  useEffect(() => {
    const fetchTickets = async () => {
      try {
        const res = await api.get(`/ticket/user/${userId}`);
        const userTickets = res.data;

        setTickets(userTickets);

        setStats({
          total: userTickets.length,
          pending: userTickets.filter(t => t.ticketStatus === "OPEN" || t.ticketStatus === "IN_PROGRESS").length,
          resolved: userTickets.filter(t => t.ticketStatus === "RESOLVED").length
        });
      } catch (err) {
        console.error(err);
      }
    };

    fetchTickets();
  }, [userId]);

  return (
    <>
    <Navbar />
    <div className="home-container">
      <div className="dashboard-card-box">
        <h2>User Dashboard</h2>

        <div className="dashboard-stats">
          <div className="stat-card total">📝 Total Tickets <span>{stats.total}</span></div>
          <div className="stat-card pending">⏳ Pending <span>{stats.pending}</span></div>
          <div className="stat-card resolved">✅ Resolved <span>{stats.resolved}</span></div>
        </div>

        <div className="dashboard-actions">
          <Link to="/add-ticket" className="dashboard-btn">➕ Add Ticket</Link>
          <Link to="/my-tickets" className="dashboard-btn">📋 My Tickets</Link>
        </div>

        <h3 style={{ marginTop: "30px" }}>Recent Tickets</h3>
        <table className="tickets-table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Subject</th>
              <th>Status</th>
              <th>Priority</th>
              <th>Created At</th>
            </tr>
          </thead>
          <tbody>
            {tickets.slice(0,5).map(ticket => (
              <tr key={ticket.id}>
                <td>{ticket.id}</td>
                <td>{ticket.subject}</td>
                <td>{ticket.ticketStatus}</td>
                <td>{ticket.ticketPriority}</td>
                <td>{new Date(ticket.createdAt).toLocaleString()}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
    </>
  );
}

export default UserDashboard;