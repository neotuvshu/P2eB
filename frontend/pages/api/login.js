/**
 * Author: Enkh
 * Module: Login Creation
 * Description: Implements the login functionality for the system, including user authentication and session handling.
 * Date: November 6, 2024
 */

// pages/login.js

const mysql = require('mysql2/promise');

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
                

                if (password === storedPassword) {
                    return res.status(200).json({ message: 'Амжилттай нэвтэрлээ' });
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
