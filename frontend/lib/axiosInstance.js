import axios from 'axios';

const axiosInstance = axios.create({
  baseURL: 'http://localhost:8080', // Backend server URL
});

axiosInstance.interceptors.request.use((config) => {
  const token = localStorage.getItem('token');
  if (token) {
    config.headers['Authorization'] = `Bearer ${token}`;
  }
  return config;
}, (error) => {
  return Promise.reject(error);
});

axiosInstance.interceptors.response.use((response) => {
  return response;
}, (error) => {
  // Handling unauthorized responses
  if (error.response && error.response.status === 401) {
    // Redirect to login page on unauthorized access
    window.location.href = '/login';
  }
  return Promise.reject(error);
});

export default axiosInstance;
