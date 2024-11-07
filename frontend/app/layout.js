// app/layout.js
import './globals.css';

export const metadata = {
  title: 'P2eb App',
  description: 'JWT authentication with Next.js and Spring Boot',
};

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body>{children}</body>
    </html>
  );
}
