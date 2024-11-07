// app/dashboard/page.js
'use client';

import styles from './Dashboard.module.css';

export default function DashboardPage() {
  return (
    <div className={styles.dashboardContainer}>
      <div className={styles.menuBar}>
        <span className={styles.menuItem}>System Management</span>
        <span className={styles.menuItem}>Data Management</span>
        <span className={styles.menuItem}>Optimization</span>
        <span className={styles.menuItem}>Bidding</span>
        <span className={styles.menuItem}>Metering</span>
        <span className={styles.menuItem}>Settlement</span>
      </div>
      <div className={styles.mainContent}>
        <h1>This is the main screen</h1>
      </div>
    </div>
  );
}
