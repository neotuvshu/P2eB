//frontend/pages/dashboard/Dashboard.js

import React, { useEffect, useState } from 'react';

const Dashboard = () => {
    const [data, setData] = useState(null);

    // Хамгаалагдсан өгөгдлийг авах функц
    const fetchData = async () => {
        const token = localStorage.getItem('token');

        const response = await fetch('/api/protected-endpoint', {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${token}`
            }
        });

        const data = await response.json();
        setData(data); // Өгөгдлийг бүртгэх эсвэл хадгалах
    };

    useEffect(() => {
        fetchData();
    }, []);

    return (
        <div>
            <h1>Dashboard</h1>
            {data ? (
                <div>{JSON.stringify(data)}</div>
            ) : (
                <p>Өгөгдлийг ачааллаж байна...</p>
            )}
        </div>
    );
};

export default Dashboard;
