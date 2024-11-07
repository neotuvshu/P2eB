/**
 * Author: Enkh
 * Module: Login Creation
 * Description: Implements the login functionality for the system, including user authentication and session handling.
 * Date: November 6, 2024
 */

// pages/login.tsx
import { useState } from 'react';
import { useRouter } from 'next/router';

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const router = useRouter();

    const handleLogin = async (e: React.FormEvent) => {
        e.preventDefault();

        try {
            const response = await fetch('/api/login', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ username, password }),
            });

            const data = await response.json();
            if (response.ok) {
                // Store the token in localStorage
                localStorage.setItem('token', data.token);
                
                // Redirect to dashboard upon successful login
                router.push('/dashboard');
            } else {
                alert(data.message);
            }
        } catch (error) {
            console.error('Login error:', error);
            alert('Something went wrong, please try again.');
        }
    };

    return (
        <div>
            <h2>Login</h2>
            <form onSubmit={handleLogin}>
                <input
                    type="text"
                    placeholder="Username"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                />
                <input
                    type="password"
                    placeholder="Password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />
                <button type="submit">Login</button>
            </form>
        </div>
    );
};

export default Login;
