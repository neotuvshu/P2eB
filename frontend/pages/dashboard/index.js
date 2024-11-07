import { useRouter } from 'next/router';
import { useEffect } from 'react';

export default function DashboardPage() {
    const router = useRouter();

    useEffect(() => {
        const token = localStorage.getItem('token');
        if (!token) {
            router.push('/login'); // Токен байхгүй бол Login руу чиглүүлнэ
        }
    }, []);

    return <div>Your Dashboard Content Here</div>;
}
