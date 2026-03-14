import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axiosConfig";
import { setAuth } from "../utils/auth";
import Navbar from "../components/Navbar";

function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [errors, setErrors] = useState({});
  const navigate = useNavigate();

  const validate = () => {
    const newErrors = {};
    if (!username.trim()) newErrors.username = "Username is required";
    if (!password) newErrors.password = "Password is required";
    else if (password.length < 4)
      newErrors.password = "Password must be at least 4 characters";
    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleLogin = async (e) => {
    e.preventDefault();
    if (!validate()) return;

    // Quick admin check
    if (username === "Monisha" && password === "1234") {
      setAuth(username, 0, "ADMIN");
      navigate("/admin-dashboard");
      return;
    }

    try {
      const res = await api.post("/auth/login", { username, password });
      setAuth(username, res.data.userId, res.data.role);
      if (res.data.role === "ADMIN") navigate("/admin-dashboard");
      else navigate("/user-dashboard");
    } catch (err) {
      console.error("Login failed:", err.response?.data || err.message);
      setErrors({ api: "Invalid username or password" });
      localStorage.clear();
    }
  };

  return (
     <>
    <Navbar />
    <div className="form-container">
      <div className="form-card login-card">
        <h3>Login</h3>
        <form onSubmit={handleLogin}>
          <input
            type="text"
            placeholder="Username"
            value={username}
            className={errors.username ? "input-error" : ""}
            onChange={(e) => setUsername(e.target.value)}
          />
          {errors.username && (
            <small className="error-text">{errors.username}</small>
          )}

          <input
            type="password"
            placeholder="Password"
            value={password}
            className={errors.password ? "input-error" : ""}
            onChange={(e) => setPassword(e.target.value)}
          />
          {errors.password && (
            <small className="error-text">{errors.password}</small>
          )}

          {errors.api && (
            <small className="error-text api-error">{errors.api}</small>
          )}

          <button type="submit" className="btn primary-btn login-btn">
            Login
          </button>
        </form>
      </div>
    </div>
    </>
    
  );
}

export default Login;