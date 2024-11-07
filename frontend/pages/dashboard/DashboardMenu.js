//frontend/pages/dashboard/DashboardMenu.js

import React from 'react';
import { MenuItemLink } from 'react-admin';
import DashboardIcon from '@mui/icons-material/Dashboard';
import PeopleIcon from '@mui/icons-material/People';

const DashboardMenu = () => (
    <div>
        <MenuItemLink to="/dashboard" primaryText="Dashboard" leftIcon={<DashboardIcon />} />
        <MenuItemLink to="/system-management" primaryText="System Management" leftIcon={<PeopleIcon />} />
        <MenuItemLink to="/data-management" primaryText="Data Management" />
        {/* Цаашид бусад категориудыг хөгжүүлж оруулна */}
    </div>
);

export default DashboardMenu;