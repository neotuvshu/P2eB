// app/admin/layout.js
export default function AdminLayout({ children }) {
    return (
      <div>
        <nav>
          <a href="/admin/dashboard">Dashboard</a>
          <a href="/logout" onClick={() => localStorage.removeItem('token')}>Logout</a>
        </nav>
        <main>{children}</main>
      </div>
    );
  }
  