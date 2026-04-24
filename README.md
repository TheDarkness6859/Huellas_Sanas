# Proyecto: Clínica Veterinaria "Huellas Sanas"

## 1. Contexto del Caso de Uso
La clínica veterinaria **"Huellas Sanas"** enfrenta problemas críticos en su operación diaria debido al uso de herramientas aisladas (hojas de cálculo y agendas de papel). Los principales desafíos identificados son:
* **Pérdida del historial médico:** Dificultad para acceder a diagnósticos previos o esquemas de vacunación.
* **Conflictos de Agenda:** Solapamiento de citas para un mismo veterinario.
* **Información Desconectada:** Datos de dueños y mascotas desincronizados entre plataformas.

## 2. Objetivo del Sistema
Desarrollar una solución empresarial robusta bajo las mejores prácticas de la industria para centralizar la información y automatizar procesos críticos.

## 3. Especificaciones Técnicas
El sistema se ha desarrollado siguiendo estos lineamientos técnicos:
* **Lenguaje:** Java SE 17 o superior.
* **Gestión de Dependencias:** Maven.
* **Arquitectura:** Patrón **MVC** (Modelo-Vista-Controlador) con desacoplamiento total.
* **Persistencia:** Base de Datos Relacional mediante **JDBC** nativo y el patrón **DAO** (Data Access Object).

## 4. Requerimientos Funcionales y de Seguridad
### Modelado del Negocio (POO)
* Implementación de **Herencia y Polimorfismo** para la gestión de personas (Clientes, Veterinarios, Usuarios).
* Aplicación estricta de **Encapsulamiento y Abstracción** en todos los modelos.

### Seguridad
* **Módulo de Login:** Acceso restringido según roles de usuario.
* **Cifrado de Contraseñas:** Uso obligatorio de algoritmos como **SHA-256** o **BCrypt** para persistir credenciales; no se permite texto plano.

### Gestión de Citas y Transaccionalidad
* **Validaciones Críticas:** Control automático para evitar conflictos de horario en la agenda.
* **Registro Integral:** Flujo atómico que permite registrar una mascota y su primera cita en un solo paso.
* **Garantía Transaccional:** Uso de transacciones JDBC (`setAutoCommit(false)`, `commit`, `rollback`) para evitar datos huérfanos en caso de fallos.

## 5. Interfaces y Calidad
* **Multivista:** Soporte para interfaz de **Consola** y aplicación de **Escritorio** (Swing/JavaFX) compartiendo el mismo núcleo de negocio.
* **Aseguramiento de Calidad:** Pruebas unitarias automatizadas con **JUnit** y **Mockito** para validar reglas de negocio.
* **Gestión de Recursos:** Implementación de *try-with-resources* para la liberación automática de conexiones y flujos de datos.

---
*Este documento forma parte de la documentación técnica obligatoria del proyecto "Huellas Sanas"*.