import { useEffect, useState } from "react";
import api from "../api/axiosConfig";
import Navbar from "../components/Navbar";

import {
  Chart as ChartJS,
  ArcElement,
  Tooltip,
  Legend
} from "chart.js";

import { Pie } from "react-chartjs-2";

ChartJS.register(ArcElement, Tooltip, Legend);

function TicketStats() {

  const [stats, setStats] = useState({
    open: 0,
    inProgress: 0,
    resolved: 0
  });

  useEffect(() => {
    const fetchStats = async () => {
      try {
        const res = await api.get("/ticket/all");
        const tickets = res.data;

        setStats({
          open: tickets.filter(t => t.ticketStatus === "OPEN").length,
          inProgress: tickets.filter(t => t.ticketStatus === "IN_PROGRESS").length,
          resolved: tickets.filter(t => t.ticketStatus === "RESOLVED").length
        });

      } catch (err) {
        console.error(err);
      }
    };

    fetchStats();
  }, []);

  const data = {
    labels: ["Open", "In Progress", "Resolved"],
    datasets: [
      {
        label: "Tickets",
        data: [stats.open, stats.inProgress, stats.resolved],
        backgroundColor: [
          "#f59e0b",
          "#3b82f6",
          "#10b981"
        ],
        borderWidth: 1
      }
    ]
  };

  return (
    <>
      <Navbar />

      <div className="tickets-container">
        <h3>📊 Ticket Statistics</h3>

        <div className="ticket-card">
          <Pie data={data} />
        </div>

      </div>
    </>
  );
}

export default TicketStats;