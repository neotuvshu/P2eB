import axiosInstance from '@/lib/axiosInstance';

export const loginUser = async (username, password) => {
  return await axiosInstance.post('/auth/login', { username, password });
};
