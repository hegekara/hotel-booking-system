import React, { useEffect, useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import API from "../api";
import "../styles/Auth.css"

const Register = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [password2, setPassword2] = useState("");
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastNname] = useState("");
  const [phoneNumber, setPhoneNumber] = useState("");
  const [success, setSuccess] = useState(false);
  const [error, setError] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    if (localStorage.getItem("jwtToken")) {
      navigate("/home");
    }
  }, [navigate])

  const handleRegister = async (e) => {
    e.preventDefault();

    if (password !== password2) {
      setError("Passwords do not match. Please try again.");
      return;
    }

    try {
      await API.post("/customer/register", { firstName, lastName, email, phoneNumber, password });
      setSuccess(true);
    } catch (err) {
      setError("Registration failed. Please try again.");
    }
  };

  return (
    <div className="homepage-img">
      <img src="../src/static/images/homepage-img.jpeg" alt="Hotel Image" />
      <div className="content">
        <form className="auth-form" onSubmit={handleRegister}>
          <h2 className="auth-title">Register</h2>
          <div className="form-group">
            <label className="form-label">Email:</label>
            <input
              className="form-input"
              type="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label className="form-label">İsim:</label>
            <input
              className="form-input"
              type="text"
              value={firstName}
              onChange={(e) => setFirstName(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label className="form-label">Soyisim:</label>
            <input
              className="form-input"
              type="text"
              value={lastName}
              onChange={(e) => setLastNname(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label className="form-label">Cep Telefonu:</label>
            <input
              className="form-input"
              type="phone"
              value={phoneNumber}
              onChange={(e) => setPhoneNumber(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label className="form-label">Password:</label>
            <input
              className="form-input"
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label className="form-label">Password x2 :</label>
            <input
              className="form-input"
              type="password"
              value={password2}
              onChange={(e) => setPassword2(e.target.value)}
              required
            />
          </div>
          <button className="form-button" type="submit">Register</button>
          <div className="link-container">
            <Link className="form-link" to="/login">Go to Login Page</Link>
          </div>
        </form>
        {success && <p>Registration successful! You can now log in.</p>}
        {error && <p style={{ color: "red" }}>{error}</p>}
      </div>
    </div>


  );
};

export default Register;