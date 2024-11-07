//frontend/pages/dashboard/DashboardLayout.js

import React from 'react';
import { Layout, Menu } from 'react-admin';

const DashboardLayout = (props) => {
    return (
        <Layout 
            {...props}
            appBar = {() => <AppBar />}
            menu = {() => <DashboardMenu />}
        />
     );
};

export default DashboardLayout;