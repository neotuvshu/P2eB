'use client';
import Image from 'next/image'
import React, { useState } from 'react';
import styles from './dashboard/Dashboard.module.css';

export default function AdminLayout({ children }) {
  const [dropdownVisible, setDropdownVisible] = useState(null);

  const menuItems = [
    {
      name: 'System Management',
      options: [
        'User Management', 
        'Manage User Permission', 
        'Manage menus by permission', 
        'Interface Management', 
        'Common code management'
      ],
    },
    {
      name: 'Data Management',
      options: [
        'Master Info', 
        'Resource Type', 
        'Generator Characteristics Information', 
        'Bid Information', 
        'Cost Information', 
        'Resource Information'
      ],
    },
    {
      name: 'Optimization',
      options: [
        'Base Information', 
        'Run Optimization', 
        'Generate Energy Supply', 
        'Generate AGC Supply', 
        'Electric Boiler AGC Supply'
      ],
    },
    {
      name: 'Bidding',
      options: [
        'Bidding Instructions', 
        'Execute the Bid', 
        'View Bids', 
        'Auction Management'
      ],
    },
    {
      name: 'Metering',
      options: ['Check the Weighing Status', 'Manage Records'],
    },
    {
      name: 'Settlement Management',
      options: ['Settlement Management'],
    },
  ];

  const handleMouseEnter = (menuItem) => setDropdownVisible(menuItem);
  const handleMouseLeave = () => setDropdownVisible(null);

  return (
    <div className={styles.dashboardContainer}>
      <div className={styles.menuBar}>
      <Image
          src= "http://127.0.0.1:5501/frontend/public/logo.svg"
          alt="Logo"
          width={100}
          height={50}  
        />
        {menuItems.map((item) => (
          <div
            key={item.name}
            className={styles.menuItem}
            onMouseEnter={() => handleMouseEnter(item.name)}
            onMouseLeave={handleMouseLeave}
          >
            {item.name}
            {dropdownVisible === item.name && (
              <div className={styles.dropdown}>
                {item.options.map((option) => (
                  <span key={option} className={styles.dropdownItem}>
                    {option}
                  </span>
                ))}
              </div>
            )}
          </div>
        ))}
      </div>
      <div className={styles.mainContent}>
        <nav>
          {/* Add relevant links if needed */}
        </nav>
        <main>{children}</main>
      </div>
    </div>
  );
}
