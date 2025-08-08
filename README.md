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

## 📄 License

MIT License — Free to use and modify

---


