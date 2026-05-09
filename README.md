# 🚩 MedCare: Multi-Tenant Feature Flag Platform

A Smart FullStack, Real-Time, and secure **Multi-Tenant Feature Flag Management web Platform** built over **MERN Stack** (MongoDB, Express.js, React, Node.js) and persists credential **v4 UUIDs** related callbacks to respective tables.

---

## 🚀 Key Functionalities

*   **🔒 OTP linked Role-Based Access Control (RBAC)**:
    *   **Super Admin**: Full access to onboard organizations, track role activity, view/review organization administrators, maintian active feature flag counts, and display all web role active status.
    *   **Org Admin**: Modify, create, toggle, and delete scoped feature flags of their respective organization.
    *   **End User**: A clean, browser-facing portal access allowing end-users to select their organization and interact real-time if the feature flag is enabled for their use.
*   **🏢 Scalable Multi-Tenant Architecture**: Robust data isolation utilizing v4 UUID strings as primary keys across all MongoDB collections, powered by composite index keys on feature flags (`orgId` + `key`)

---

## 🛠️ Technology Stack 

*   **Frontend**: React (v18.2), Tailwind CSS, Vite, AutoPrefixer (`Lucide` & `Axios`).
*   **Backend**: Node.js,  Mongoose (MongoDB Composs), Express.js,, Cors, Dotenv.
*   **Database**: MongoDB (Local or Composs) utilizing native UUID-v4 keys.

---

## 📁 WebApp Repository Structure

```text
├── backend/
│   ├── src/
│   │   ├── controllers/      # Route controllers (authController, orgController, superController).
│   │   ├── models/           # Mongoose schemas (Organization, User, FeatureFlag).
│   │   └── routes/           # API endpoints routing definitions.
│   │   └── config/           # Back Configuration for the connection.
│   │   └── MiddleWare/           # API endpoints routing definitions
│   ├── server.js             # Express entry point & MongoDB connection.
│   └── .env                  # Port & database configurations.
│
└── frontend/
    ├── src/
    │   ├── components/       # Reusable components (Sidebar, Topbar, Toast, FlagModal)
    │   ├── pages/            # View pages (LoginPage, SignupPage, SuperDashboard, OrgDashboard, EndUserPage)
    │   ├── context/          # Decoupled API service request layer
    │   ├── utils/          # Decoupled API service request layer
    │   ├── App.js            # Core page rendering, routing, and viewport modal portal
    │   ├── index.css         # Tailwind directives & global typography definitions
    │   └── App.css           # Styling utilities & micro-animations
```

---

## 💾 Database Schemas (Mongoose)

### 1. `Organization`
Stores onboarded tenant organizations.
// ToDo.

### 2. `User`
Stores system accounts with specific RBAC roles.
*   `_id` (String, default: UUID v4): Unique User ID.
*   `email` (String, unique): User email.
*   `password` (String): Secure password.
*   `role` (String): `'super_admin'` or `'org_admin'`.
*   `orgId` (String, optional): Refers to the Organization `_id`.

### 3. `FeatureFlag`
Stores scoped feature flags with composite index keys for blazing-fast multi-tenant queries.
*   `_id` (String, default: UUID v4): Unique Flag ID.
*   `orgId` (String): Refers to the Organization `_id`.
*   `key` (String): Unique string key (e.g. `beta_billing_v2`).
*   `name` (String): User-friendly display name.
*   `description` (String): Purpose of the flag.
*   `isEnabled` (Boolean): Current toggle status.

### 4. `icus`

### 5. ``

---

## ⚡ Local Installation and Connection Setup 

### Prerequisites
*   Node.js (v16 or higher)
*   NPM
*   MongoDB running locally (`mongodb://localhost:27017/featureflag`) or a remote MongoDB Atlas URI.

### 1. Command to run the Backend Server
```bash
cd backend
npm install
npm run dev
```
*Creates server on `http://localhost:5000` and automatically connects to MongoDB.*

### 2. Command to run the React Admin Dashboard
```bash
cd admin
npm install
npm run dev
```
*Launches dashboard on `http://localhost:3000`.*

---

## 🔑 Backup Credentials

### Super Admin
*   **Email**: `superadmin@featureflag.com`
*   **Password**: `superpassword123`

---
