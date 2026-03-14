import { useEffect, useState } from "react";
import api from "../api/axiosConfig";

function AssignedTickets(){

  const [tickets,setTickets] = useState([]);

  const username = localStorage.getItem("username");

useEffect(()=>{

  api.get("/ticket/all")
  .then(res=>{

    const myTickets = res.data.filter(
      t => t.executive && t.executive.id === 4
    );

    setTickets(myTickets);

  });

},[]);

  const resolveTicket = async(id)=>{

    await api.put(`/ticket/resolve/${id}`);

    alert("Ticket Resolved");

    window.location.reload();

  };

  return(

    <div className="container mt-5">

      <h3>My Assigned Tickets</h3>

      {tickets.length === 0 && <p>No tickets assigned</p>}

      {tickets.map(t=>(
        <div key={t.id} className="card p-3 mb-3">

          <h5>{t.subject}</h5>

          <p>{t.issue}</p>

          <b>Customer:</b> {t.customer?.name} <br/>

          <b>Priority:</b> {t.ticketPriority} <br/>

          <b>Status:</b> {t.ticketStatus} <br/>

          {t.ticketStatus !== "RESOLVED" && (
            <button
              className="btn btn-success mt-2"
              onClick={()=>resolveTicket(t.id)}
            >
              Resolve
            </button>
          )}

        </div>
      ))}

    </div>
  );
}

export default AssignedTickets;