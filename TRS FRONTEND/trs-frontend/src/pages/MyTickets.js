import { useEffect, useState } from "react";
import api from "../api/axiosConfig";

function MyTickets(){

  const [tickets,setTickets] = useState([]);

  const username = localStorage.getItem("username");

  useEffect(()=>{

    api.get("/ticket/all")
    .then(res=>{

      const myTickets = res.data.filter(
        t => t.customer && 
        t.customer.name.toLowerCase() === username.toLowerCase()
      );

      setTickets(myTickets);

    });

  },[]);

  return(

 <div className="my-tickets-container">
  <h3>My Tickets</h3>

  {tickets.map(t => (
    <div key={t.id} className="ticket-card">
      <h5>{t.subject}</h5>
      <p>{t.issue}</p>
      <b>Priority:</b> {t.ticketPriority} <br/>
      <b>Status:</b> {t.ticketStatus} <br/>
      <b>Assigned Executive:</b> {t.executive?.name || "Not Assigned"} <br/>
      <b>Executive Role:</b> {t.executive?.jobTitle || "-"} <br/>
    </div>
  ))}
  </div>
    )}

export default MyTickets;