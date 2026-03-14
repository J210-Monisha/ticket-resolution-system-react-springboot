import { useEffect, useState } from "react";
import api from "../api/axiosConfig";

function AssignExecutive(){

  const [tickets,setTickets] = useState([]);
  const [executives,setExecutives] = useState([]);

  const [selectedExec,setSelectedExec] = useState({});

  const loadData = () => {

    api.get("/ticket/all")
      .then(res=>setTickets(res.data));

    api.get("/executive/all")
      .then(res=>setExecutives(res.data));

  };

  useEffect(()=>{
    loadData();
  },[]);

  const assignExec = async(ticketId)=>{

    const execId = selectedExec[ticketId];

    if(!execId){
      alert("Select an executive first");
      return;
    }

    try{

      await api.put(`/ticket/assign/${ticketId}/${execId}`);

      alert("Executive Assigned");

      loadData();

    }
    catch{
      alert("Error assigning executive");
    }

  };

  return(

<div className="tickets-container">
  <h3>Assign Executives</h3>
  {tickets.map((t) => (
    <div key={t.id} className="ticket-card">
      <h5>{t.subject}</h5>
      <p>{t.issue}</p>

      <b>Customer:</b> {t.customer?.name} <br/>

      <span className={`ticket-badge priority-${t.ticketPriority}`}>
        {t.ticketPriority}
      </span>
      <span className={`ticket-badge status-${t.ticketStatus}`}>
        {t.ticketStatus}
      </span>
      <br/><br/>

<b>Executive:</b> 
<span style={{color:"#10b981"}}>{t.executive ? t.executive.name : "Not Assigned"}</span>
    <br>
    </br>
    <select
  disabled={t.executive}
  onChange={(e) =>
    setSelectedExec({ ...selectedExec, [t.id]: e.target.value })
  }
>
  <option value="">Select Executive</option>

  {executives.map((e) => (
    <option key={e.id} value={e.id}>
      {e.name}
    </option>
  ))}
</select>

      <button
  className="btn btn-primary ms-2"
  disabled={t.executive}
  onClick={() => assignExec(t.id)}
>
  Assign
</button>
    </div>
  ))}
</div>

  );

}

export default AssignExecutive;