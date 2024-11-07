// DashboardLayout.js

import { useEffect } from 'react';
import { useRouter } from 'next/router';

const DashboardLayout = ({ children }) => {
    const router = useRouter();

    useEffect(() => {
        // Токен байгаа эсэхийг шалгах
        const token = localStorage.getItem('token');
        
        // Токен байхгүй бол login руу чиглүүлэх
        if (!token) {
            router.push('/login');
        }
    }, []);

    return (
        <div>
            <h1>Dashboard</h1>
            {/* Dashboard загвар ба агуулга */}
            {children}
        </div>
    );
};

export default DashboardLayout;