# 🖥️ Computer Club Management System

**When Swing meets Spring Boot — a desktop ERP for a computer club that takes authentication and validation as seriously as your production backend.**

Diploma project. Not a university "hello world." A real client-server desktop application with role-based access, input sanitization, and a relational database that doesn't let you book the same PC twice.

---

## 🎯 The Business Problem

Computer clubs handle: clients, PCs, sessions, tariffs, staff shifts. Doing this in Excel is pain. Doing this without validation is chaos.

This application replaces spreadsheets with a structured desktop interface where:
- **Admins** manage hardware and view revenue.
- **Staff** start/end client sessions, track active PCs.
- **Nobody** breaks the system with bad input.

---

## 🧱 Architecture (Desktop App, Production Mindset)
📦 ComputerClubGUIapplication
├── 🖥️ Swing GUI Layer → Human interface, built on Event Dispatch Thread
├── 🔐 Auth Module → Login with role discrimination (Admin vs Staff)
├── ✅ Validation Layer → Input checks BEFORE hitting the database
├── 🧠 Spring Context → Dependency injection, service beans, transaction management
├── 🗄️ MySQL Repository Layer → JDBC/Spring Data, connection pooling
└── 📦 Maven → Dependency management, reproducible builds

text

| Layer | What It Does | Why It Matters |
|-------|--------------|----------------|
| **Swing UI** | Desktop forms, tables, session timers | Users don't need a browser — zero deployment friction |
| **Spring DI** | Wire services, repositories, validators | Testable, decoupled, not a God-class spaghetti |
| **Authentication** | Login → role → accessible features | Staff can't touch admin reports. Admin can't accidentally close a session |
| **Validation** | Regex + business rules before DB call | No garbage data. No SQL injection. No "oops" |
| **MySQL** | Relational schema: users, PCs, sessions, tariffs | Auditable history, joins for analytics |

---

## 🔐 Authentication & Authorization

[Login Screen] → Spring AuthService → DB users table → Role (ADMIN / STAFF)
                                                           ↓
                                              [Admin Dashboard] or [Staff Workspace]
Passwords hashed. Roles enforced in the service layer, not just hidden in the UI. If a staff member manually types an admin URL... nothing happens. They never reach the controller.

🛡️ Validation (Defense in Depth)
Input Field	Rule	Error Message
Client phone	\+?\d{10,12}	"Enter a valid phone number"
Session time	Must not overlap existing booking	"This PC is already reserved"
Tariff price	Positive BigDecimal	"Price must be greater than zero"
Empty fields	Not-null check on all mandatory inputs	"This field is required"
Validation runs both on the Swing side (instant feedback) and service side (security net). Two layers. Zero trust.

## 🛠️ Tech Stack

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-6DB33F?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

🚀 Quick Run
bash
# 1. Clone
git clone https://github.com/NeironEssensive/ComputerClubGUIapplication.git
# 2. Build & run
mvn clean package
java -jar target/computer-club-gui.jar
🧠 What This Project Proves
Spring isn't only for web apps. DI, transactions, and service abstraction work beautifully in desktop Java.

I think about security from the start. Auth and validation aren't "later" features — they're in the architecture diagram before a single button is painted.

Relational modeling is second nature. The MySQL schema handles overlaps, history, and revenue queries — not just CRUD.

