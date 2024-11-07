/**
 * Author: Enkh
 * Module: Login Creation
 * Description: Implements the login functionality for the system, including user authentication and JWT handling.
 * Date: November 6, 2024
 */

// pages/api/login.js

const mysql = require('mysql2/promise');
const jwt = require('jsonwebtoken');

// Secret key for JWT (Store this securely, e.g., in environment variables)
const JWT_SECRET = process.env.JWT_SECRET || 'your-secret-key';

export default async function handler(req, res) {
    if (req.method === 'POST') {
        const { username, password } = req.body;

        try {
            const connection = await mysql.createConnection({
                host: process.env.DB_HOST,
                port: process.env.DB_PORT,
                user: process.env.DB_USER,
                password: process.env.DB_PASSWORD,
                database: process.env.DB_NAME,
            });

            const [rows] = await connection.execute(
                'SELECT USER_PWD, USE_YN FROM tb_sys_user WHERE USER_ID = ?',
                [username]
            );

            console.log("Асуулгын үр дүн:", rows);

            await connection.end();

            if (rows.length > 0 && rows[0].USE_YN === 'y') {
                const storedPassword = rows[0].USER_PWD;

                // Check if the password is correct
                if (password === storedPassword) {
                    // Generate JWT token
                    const token = jwt.sign({ username }, JWT_SECRET, { expiresIn: '1h' }); // Token expires in 1 hour
                    return res.status(200).json({ message: 'Амжилттай нэвтэрлээ', token });
                } else {
                    return res.status(401).json({ message: 'Нэвтрэх нэр эсвэл нууц үг буруу байна' });
                }
            } else {
                return res.status(401).json({ message: 'Хэрэглэгч олдсонгүй эсвэл идэвхгүй байна' });
            }

        } catch (error) {
            console.error('Өгөгдлийн сантай холбогдох алдаа:', error);
            return res.status(500).json({ message: 'Өгөгдлийн сантай холбогдох алдаа' });
        }
    } else {
        res.setHeader('Allow', ['POST']);
        res.status(405).end(`Method ${req.method} Зөвшөөрөгдөөгүй`);
    }
}
