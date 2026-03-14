import { useEffect, useState } from "react";
import api from "../api/axiosConfig";

function AllTickets() {

  const [tickets, setTickets] = useState([]);
  const [allTickets, setAllTickets] = useState([]);
  const [priorityFilter, setPriorityFilter] = useState("ALL");

  const loadTickets = () => {
    api.get("/ticket/all")
      .then(res => {
        setTickets(res.data);
        setAllTickets(res.data);
      })
      .catch(err => {
        console.log(err);
        alert("Error loading tickets");
      });
  };

  useEffect(() => {
    loadTickets();
  }, []);

  const filterTickets = (value) => {

    setPriorityFilter(value);

    if (value === "ALL") {
      setTickets(allTickets);
    } else {
      const filtered = allTickets.filter(
        t => t.ticketPriority === value
      );
      setTickets(filtered);
    }
  };

  const resolveTicket = async (id) => {

    try {

      await api.put(`/ticket/resolve/${id}`);

      alert("Ticket Resolved Successfully");

      loadTickets();

    } catch (err) {

      console.log(err);
      alert("Error resolving ticket");

    }

  };

  return (
   <div className="tickets-container">

    <h3>All Tickets</h3>

    <div style={{marginBottom:"20px"}}>
      <label style={{marginRight:"10px"}}>Priority:</label>

      <select
        value={priorityFilter}
        onChange={(e)=>filterTickets(e.target.value)}
      >
        <option value="ALL">ALL</option>
        <option value="HIGH">HIGH</option>
        <option value="MEDIUM">MEDIUM</option>
        <option value="LOW">LOW</option>
      </select>
    </div>

  {tickets.map((t) => (
    <div key={t.id} className="ticket-card">

      <h5>{t.subject}</h5>
      <p>{t.issue}</p>

      <span className={`ticket-badge priority-${t.ticketPriority}`}>
        {t.ticketPriority}
      </span>

      <span className={`ticket-badge status-${t.ticketStatus}`}>
        {t.ticketStatus}
      </span>

      <br/><br/>

     {t.ticketStatus === "IN_PROGRESS" && (
      <button
        className="btn btn-success mt-2"
        onClick={() => resolveTicket(t.id)}
      >
        Resolve
      </button>
    )}

  </div>
  ))}

</div>
  );
}

export default AllTickets;