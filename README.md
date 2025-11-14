# 🛒 EcoMarket — Proyecto Completo
EcoMarket es un sistema compuesto por dos proyectos independientes:

1. **EcoMarket App (Android / Kotlin / Jetpack Compose)**  
2. **EcoMarket Backend API (Kotlin + Spring Boot)**  

Este README documenta ambos proyectos para facilitar su despliegue, instalación y mantenimiento.

---

# ==========================================
# 🧩 1. ECO MARKET — BACKEND (SPRING BOOT)
# ==========================================

# 🛠️ EcoMarket - Backend API

Backend desarrollado en **Kotlin + Spring Boot**, encargado de gestionar productos, categorías, usuarios y carrito para la app móvil **EcoMarket**.

Provee una API REST consumida por Retrofit desde la aplicación Android.

---

## 🚀 Tecnologías Utilizadas
- Kotlin  
- Spring Boot 3  
- Spring Web  
- Spring Data JPA  
- H2 Database (memoria)  
- Maven  
- Jackson / Moshi compatible  
- OkHttp (Frontend Android)

---

## 📂 Estructura del Proyecto

backend/
├─ src/main/kotlin/com/ecomarket/backend/
│ ├─ controller/ → Endpoints REST
│ ├─ service/ → Lógica de negocio
│ ├─ repository/ → Repositorios JPA
│ ├─ model/ → Entidades JPA
│ └─ BackendApplication.kt → Main
├─ src/main/resources/
│ ├─ application.properties
│ └─ data.sql
└─ pom.xml


---

## ▶️ Ejecutar 

En consola, dentro del proyecto backend:

Em la terminal
./mvnw spring-boot:run

En PowerShell:
mvnw spring-boot:run



La API iniciará en:

👉 http://localhost:8080


▶️ Iniciar Todo
1. Levantar backend
./mvnw spring-boot:run

2. Abrir Android Studio y ejecutar la app

El emulador usará:

http://10.0.2.2:8080/




