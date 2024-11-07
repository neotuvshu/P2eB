//frontend/pages/dashboard/Dashboard.js

import React from 'react';
import { Admin, Resource } from 'react-admin';
import dataProvider from './dataProvider';
import DashboardLayout from './DashboardLayout';

const Dashboard = () => (
    <Admin layout={DashboardLayout} dataProvider={dataProvider}>
        <Resource name="system-management" list={() => <div>System Management Page</div>} />
        <Resource name="data-management" list={() => <div>Data Management Page</div>} />
        {/* Other Catergories */}
    </Admin>
);

export default Dashboard;