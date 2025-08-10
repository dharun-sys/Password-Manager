#  Password Manager

A **production-grade password manager** with enterprise-level security, encryption, and scalability in mind.

---

##  Tech Stack

### **Languages**

* **Backend:** Java/Spring
* **Frontend:** JavaScript/TypeScript (React + TailwindCSS)

### **Frameworks & Libraries**

* **Spring Boot** *(Java)* for API development
* **JWT** for authentication
* **React** for UI
* **TailwindCSS** for styling
* **Browser Extension API** for autofill feature

### **Database & Storage**

* **PostgreSQL** — Primary database with **encrypted columns**
* **Redis** — Caching frequently accessed keys
* **HashiCorp Vault** or **AWS KMS** — Secure secret storage

### **Security & Encryption**

* **AES-256** — For data-at-rest encryption
* **Argon2id / PBKDF2 / Bcrypt** — Master password hashing
* **Per-entry encryption keys** — Unique encryption for each stored item
* **Rate limiting** — To prevent brute force attacks
* **IP whitelisting & anomaly detection** — For suspicious activity monitoring
* **Audit logging** — Tracks all actions for compliance
* **Breach Monitoring** — Integration with [HaveIBeenPwned API](https://haveibeenpwned.com/)

### **Extra Tools & Integrations**

* **Docker** — Containerization for deployment
* **NGINX** — Reverse proxy & load balancing
* **GitHub Actions** — CI/CD pipeline
* **JUnit / PyTest** — Automated testing
* **OpenAPI / Swagger** — API documentation
* **Prometheus + Grafana** — Monitoring & metrics

---

## Architecture Overview

```
┌──────────────────────────────────────────────────────┐
│                      Frontend                        │
│  React + Tailwind + Browser Extension (Autofill)     │
└───────────────▲───────────────────────────┬──────────┘
                │                           │
                │ API Requests (HTTPS + JWT)│
                │                           │
┌───────────────┴───────────────────────────▼──────────┐
│                      Backend                         │
│  Spring Boot / FastAPI                               │
│  - Auth (JWT)                                        │
│  - Encryption Layer (AES-256 + Argon2id)             │
│  - Rate limiting / Anomaly Detection                 │
└───────────────▲───────────────────────────┬──────────┘
                │                           │
                │ Secure DB Queries         │
                │                           │
┌───────────────┴──────────────┐  ┌─────────▼──────────┐
│       PostgreSQL (Encrypted) │  │   Redis (Cache)    │
└──────────────────────────────┘  └────────────────────┘
                │
                │ Secret Storage
                ▼
      HashiCorp Vault / AWS KMS
```

---

##  Features

* Secure password storage with **AES-256 encryption**
* Master password hashed with **Argon2id**
* **Per-entry encryption keys** for extra security
* **Breach alerts** via HaveIBeenPwned API
* **Browser extension** for autofill
* **Rate limiting** and **IP whitelisting**
* **Audit logging** for all activity

---

##  Must have features(given in the doc)

   * Add credentials (site name, username, password)
   * View saved credentials
   * Update or delete entries
   * Master password" login

---
## High-Level Architcture(Components)
```
Clients
  ├─ Web (React)
  ├─ Browser extension (autofill)
  └─ Mobile (optional)
      ↓ HTTPS (TLS)
API Gateway / Load Balancer (NGINX / Envoy)
      ↓
Auth Service (JWT + OAuth2)  ←→ Identity Provider (optional)
      ↓
API Backend (Microservice / Monolith)
  ├─ Vault Service (encryption orchestration)
  ├─ Storage Service (DB access)
  ├─ Sync Service (per device offsets)
  └─ Audit & Admin Service
      ↓
Data Plane:
  ├─ PostgreSQL (metadata, accounts)  ← primary persistence
  ├─ Cassandra / Scylla (append-only message store / large history) ← optional
  ├─ Redis (cache, sessions, rate limiter counters)
  ├─ Kafka (event bus: audit events, metrics, analytics)
  └─ HashiCorp Vault / AWS KMS (master key management)
Observability:
  ├─ Prometheus + Grafana (metrics)
  ├─ ELK / Loki + Kibana (logs)
  └─ Jaeger (tracing)
```
## Checklist

| Area                                         | Checked |
| -------------------------------------------- | ------- |
| **Security audits** (independent + internal) | ☐       |
| **Rate limiting + brute-force protection**   | ☑       |
| **Audit log immutability**                   | ☐       |
| **Key rotation strategy**                    | ☐       |
| **Disaster recovery & backups (encrypted)**  | ☐       |
| **Compliance (GDPR, SOC2, etc.)** if needed  | ☐       |
| **Penetration Testing (incl. extension)**    | ☐       |
| **RBAC / Admin Panel access control**        | ☐       |
| **Monitoring & alert thresholds in place**   | ☐       |
| **Detailed logging with PII redaction**      | ☐       |
| **Data export/removal for user** (GDPR)      | ☐       |

# Password Manager Project Roadmap

This roadmap outlines the plan to build a **secure, zero-knowledge password manager** over the next 4 weeks.  
The focus is on production-grade architecture, security, and clean, maintainable code.

---

## 🚀 Month-Long Plan Overview


| **Week 1**   Authentication System         |
|--------------------------------------------|
| User registration and login with zero-knowledge-compatible authentication.  |
| JWT-based access and refresh tokens implemented.  |
| Rate limiting and brute-force protection enabled.  |
| Backend APIs fully functional and integrated with a secure frontend login UI.|

| **Week 2**   Vault System Foundation       |  
|---------------------------------------------|
| Design and implement encrypted vault data structure.  |
| Client-side encryption and decryption functions using vetted cryptographic libraries. | 
| Backend APIs to store and retrieve encrypted vault blobs (stubs). |  
| Unit tests covering cryptography functions. |

| **Week 3**   Vault UI & CRUD Operations    |  
|---------------------------------------------|
| Build frontend UI for adding, editing, deleting password entries inside the vault. | 
| Integrate vault UI with backend APIs for saving and loading encrypted vault data. | 
| Implement local caching and vault auto-lock.  |
| Integration testing across frontend and backend.|

| **Week 4**   Sync, Conflict Resolution & Polish |  
|--------------------------------------------------|
| Implement vault synchronization across multiple devices with conflict detection and resolution. | 
| Final UI/UX polish and accessibility improvements.|  
| Comprehensive security and integration testing.  |
| Prepare deployment pipelines and staging environment for demo. | 
| Documentation and developer guides updated.|

---

## 🛠 Development Process

- Weekly sprints with daily standups for progress and blockers.  
- Code reviews required before merges.  
- CI/CD pipeline runs tests and security checks on every push.  
- Follow zero-knowledge principles strictly; master passwords never leave clients in plaintext.

---

## 🎯 Project Goals

- Build a **production-ready, open-source** zero-knowledge password manager.  
- Ensure **end-to-end encryption** with no sensitive data leakage.  
- Maintain clean, modular, and well-tested codebase.  
- Prepare for future extensions like browser extensions and mobile apps with a shared backend.

---

For detailed weekly task breakdowns and assignments, see the [Issues](https://github.com/your-repo/issues) section.

---

*Let’s build something secure and trustable — together.*



## 📄 License

MIT License — Free to use and modify

---


