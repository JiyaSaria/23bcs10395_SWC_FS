import { useState } from "react";

export default function LoginForm() {
  const [formData, setFormData] = useState({
    email: "",
    password: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;

    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const emailValid =
    /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(formData.email);

  const passwordValid =
    formData.password.length >= 8 &&
    /\d/.test(formData.password);

  const isFormValid = emailValid && passwordValid;

  const handleSubmit = (e) => {
    e.preventDefault();

    if (isFormValid) {
      alert("Login Successful!");
    }
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Login Form</h2>

      <form onSubmit={handleSubmit}>
        <div>
          <input
            type="email"
            name="email"
            placeholder="Enter Email"
            value={formData.email}
            onChange={handleChange}
          />

          {formData.email && !emailValid && (
            <p>Email must be a valid email address.</p>
          )}
        </div>

        <br />

        <div>
          <input
            type="password"
            name="password"
            placeholder="Enter Password"
            value={formData.password}
            onChange={handleChange}
          />

          {formData.password && !passwordValid && (
            <p>
              Password must be at least 8 characters and
              contain at least one number.
            </p>
          )}
        </div>

        <br />

        <button type="submit" disabled={!isFormValid}>
          Login
        </button>
      </form>
    </div>
  );
}