// auth.js
export const setAuth = (username, userId, role) => {
  localStorage.setItem("username", username);
  localStorage.setItem("userId", userId);
  localStorage.setItem("role", role);
};

export const clearAuth = () => localStorage.clear();

export const getUsername = () => localStorage.getItem("username");
export const getUserId = () => localStorage.getItem("userId");
export const getRole = () => localStorage.getItem("role");