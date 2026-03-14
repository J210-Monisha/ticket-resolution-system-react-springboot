import axios from "axios";
import { useState } from "react";
import Navbar from "../components/Navbar";

function Register() {
  const [data, setData] = useState({
    username: "",
    password: "",
    role: "CUSTOMER"
  });

  const [errors, setErrors] = useState({}); 

  const validate = () => {
    const newErrors = {};
    if (!data.username.trim()) newErrors.username = "Username is required";
    if (!data.password) newErrors.password = "Password is required";
    else if (data.password.length < 4)
      newErrors.password = "Password must be at least 4 characters";
    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleRegister = async (e) => {
    e.preventDefault();
    if (!validate()) return;

    try {
      await axios.post("http://localhost:8081/api/auth/sign-up", data);
      alert("User Registered Successfully ✅");
      setData({ username: "", password: "", role: "CUSTOMER" });
      setErrors({});
    } catch (err) {
      if (err.response && err.response.data) {
        setErrors({ api: err.response.data });
      } else {
        setErrors({ api: "Registration Failed ❌" });
      }
    }
  };

  return (
    <>
    <Navbar />
      <div className="form-container">
        <div className="form-card login-card">
          <h3>Register</h3>
          <form onSubmit={handleRegister}>

            <input
              type="text"
              placeholder="Enter Username"
              value={data.username}
              className={errors.username ? "input-error" : ""}
              onChange={(e) => setData({ ...data, username: e.target.value })}
            />
            {errors.username && <small className="error-text">{errors.username}</small>}

            <input
              type="password"
              placeholder="Enter Password"
              value={data.password}
              className={errors.password ? "input-error" : ""}
              onChange={(e) => setData({ ...data, password: e.target.value })}
            />
            {errors.password && <small className="error-text">{errors.password}</small>}

            <select
              value={data.role}
              onChange={(e) => setData({ ...data, role: e.target.value })}
            >
              <option value="CUSTOMER">Customer</option>
              <option value="EXECUTIVE">Executive</option>
            </select>

            {errors.api && <small className="error-text api-error">{errors.api}</small>}

            <button type="submit" className="btn primary-btn login-btn">
              Register
            </button>
          </form>
        </div>
      </div>
      </>
  );
}

export default Register;