import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Register from "./pages/Register";
import AdminDashboard from "./pages/AdminDashboard";
import UserDashboard from "./pages/UserDashboard";
import AssignedTickets from "./pages/AssignedTickets";
import AssignExecutive from "./pages/AssignExecutive";
import AddTicket from "./pages/AddTicket";
import MyTickets from "./pages/MyTickets";
import AllTickets from "./pages/AllTickets";
import CustomerPlans from "./pages/CustomerPlans";
import TicketStats from "./pages/TicketStats";
import "./App.css";

function App() {
  return (
    <BrowserRouter>
      
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />

        <Route path="/admin-dashboard" element={<AdminDashboard />} />
        <Route path="/assigned-tickets" element={<AssignedTickets />} />
        <Route path="/assign-executive" element={<AssignExecutive />} />
        <Route path="/user-dashboard" element={<UserDashboard />} />

        <Route path="/add-ticket" element={<AddTicket />} />
        <Route path="/my-tickets" element={<MyTickets />} />
        <Route path="/all-tickets" element={<AllTickets />} />
        <Route path="/customer-plans" element={<CustomerPlans />} />
        <Route path="/stats" element={<TicketStats />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;