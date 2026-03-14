import { useState } from "react";
import api from "../api/axiosConfig";
import { getUsername, getUserId } from "../utils/auth";

function AddTicket() {
  const username = getUsername();
  const userId = getUserId();

  const [data, setData] = useState({
    subject: "",
    issue: "",
    priority: "LOW",
  });

const handleSubmit = async (e) => {
  e.preventDefault();

  try {
    await api.post(`/ticket/add/${userId}`, {
      subject: data.subject,
      issue: data.issue,
      priority: data.priority
    });

    alert("Ticket Created Successfully");

    setData({
      subject: "",
      issue: "",
      priority: "LOW"
    });

  } catch (err) {
    console.error(err.response?.data);
    alert(err.response?.data || "Error creating ticket");
  }
};

  return (
    <div className="form-container">
      <div className="form-card" style={{ width: "450px" }}>
        <h3>Create Ticket</h3>
        <form onSubmit={handleSubmit}>
          <label>Customer Name</label>
          <input type="text" value={username || ""} disabled />

          <label>Issue Title</label>
          <input
            type="text"
            placeholder="Enter Issue Title"
            required
            value={data.subject}
            onChange={(e) => setData({ ...data, subject: e.target.value })}
          />

          <label>Describe Issue</label>
          <textarea
            rows="3"
            placeholder="Describe the issue"
            required
            value={data.issue}
            onChange={(e) => setData({ ...data, issue: e.target.value })}
          />

          <label>Priority</label>
          <select
            value={data.priority}
            onChange={(e) => setData({ ...data, priority: e.target.value })}
          >
            <option value="LOW">LOW</option>
            <option value="MEDIUM">MEDIUM</option>
            <option value="HIGH">HIGH</option>
          </select>

          <button className="btn primary-btn" type="submit">
            Create Ticket
          </button>
        </form>
      </div>
    </div>
  );
}

export default AddTicket;