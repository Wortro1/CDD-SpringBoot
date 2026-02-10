# 🏋️ GYM System API Documentation

Bienvenido a la documentación técnica oficial del sistema de gestión de gimnasio. Esta API RESTful permite la administración de usuarios, control de clientes, gestión de reservas y configuración de entrenamientos.

## 📋 Configuración Global

| Parámetro | Valor |
| :--- | :--- |
| **Base Host** | `http://localhost:8080` |
| **Formato** | `JSON` (`application/json`) |
| **Seguridad** | *Pendiente de Implementación* |

---

## 📑 Tabla de Contenidos
1. [👮 Administración](#1-administración-admincontroller)
2. [👤 Clientes / Usuarios Externos](#2-clientes--usuarios-externos-usuarioexternocontroller)
3. [📅 Gestión de Reservas](#3-gestión-de-reservas-bookingcontroller)
4. [📝 Tipos de Tarea](#4-tipos-de-tarea-tasktypecontroller)
5. [🦾 Tipos de Entrenamiento](#5-tipos-de-entrenamiento-tipoentrenamientocontroller)

---

# 🏋️ Documentación de Endpoints: Administrador (AdminController)

Esta sección de la API permite la gestión integral de los administradores del sistema GYM y la consulta global de usuarios externos.

## 📋 Información Base
* **Prefijo de la Ruta:** `/gym/api/administrador`
* **Formato de Intercambio:** `JSON`
* **Puerto por Defecto:** `8080`

---

## 🛠️ Resumen de Endpoints

| Método | Ruta | Descripción |
| :--- | :--- | :--- |
| `POST` | `/` | Crea un nuevo administrador. |
| `GET` | `/alladmin` | Lista todos los administradores registrados. |
| `GET` | `/{id}` | Obtiene los detalles de un administrador por su ID. |
| `PUT` | `/{id}` | Actualiza la información de un administrador existente. |
| `DELETE` | `/{id}` | Elimina a un administrador del sistema. |
| `GET` | `/usuarios/todos` | Consulta la lista completa de usuarios externos. |

---

## 📑 Detalle de Métodos

### 1. Crear Administrador
Registra un nuevo perfil administrativo en la base de datos.
* **URL:** `POST /gym/api/administrador`
* **Cuerpo de la Petición (Body):** Objeto `AdminDTO`.
* **Respuesta Exitosa:** `200 OK` con el `AdminDTO` creado.

### 2. Listar Todos los Administradores
Recupera una lista con la información de todos los administradores.
* **URL:** `GET /gym/api/administrador/alladmin`
* **Respuesta Exitosa:** `200 OK` con un `List<AdminDTO>`.

### 3. Obtener Administrador por ID
Busca un administrador específico utilizando su identificador único.
* **URL:** `GET /gym/api/administrador/{id}`
* **Parámetros:** `id` (Integer)
* **Respuesta:** `200 OK` si se encuentra. El manejo de errores (404) es gestionado por la capa de servicio.

### 4. Actualizar Administrador
Modifica los datos de un administrador basándose en su ID.
* **URL:** `PUT /gym/api/administrador/{id}`
* **Parámetros:** `id` (int)
* **Cuerpo de la Petición (Body):** `AdminDTO` con los datos actualizados.
* **Respuesta Exitosa:** `200 OK` con el objeto actualizado.

### 5. Eliminar Administrador
Remueve permanentemente a un administrador del sistema.
* **URL:** `DELETE /gym/api/administrador/{id}`
* **Parámetros:** `id` (int)
* **Respuesta Exitosa:** `200 OK` (sin contenido).

### 6. Consultar Todos los Usuarios Externos
Endpoint especializado para que el administrador pueda supervisar a todos los usuarios externos registrados.
* **URL:** `GET /gym/api/administrador/usuarios/todos`
* **Respuesta Exitosa:** `200 OK` con una lista de `UsuarioExternoDTO`.
---
> **Nota:** Todas las respuestas de error y validaciones de existencia son procesadas a través de la clase `AdminService` para mantener la lógica de negocio centralizada.

# 👤 Gestión de Clientes (Usuarios Externos)

Este módulo permite la administración del ciclo de vida de los usuarios externos (clientes del gimnasio). A diferencia del módulo de administrador, estas rutas están enfocadas en el registro, consulta y edición de perfiles de usuario individuales.

## 📋 Información Base

* **Controlador:** `UsuarioExternoController`
* **Paquete:** `com.CDD.GYM.web.controllers`
* **Ruta Base (Base URL):** `/gym/api/usuarios-externos`
* **Host:** `http://localhost:8080`
* **Formato:** `JSON`

---

## 🛠️ Resumen de Endpoints

| Método | Endpoint | Acción | Descripción |
| :--- | :--- | :--- | :--- |
| `POST` | `/` | **Registrar** | Crea un nuevo usuario externo en el sistema. |
| `PUT` | `/{id}` | **Actualizar** | Modifica los datos personales de un usuario existente. |
| `GET` | `/{id}` | **Consultar** | Obtiene el detalle de un perfil específico por ID. |
| `DELETE` | `/{id}` | **Eliminar** | Da de baja a un usuario del sistema. |

---

## 📑 Detalle Técnico de los Métodos

### 1. Registrar Cliente
Crea un nuevo registro de usuario externo.

* **URL Completa:** `POST http://localhost:8080/gym/api/usuarios-externos`
* **Cuerpo (Body):** Requiere un objeto `UsuarioExternoDTO`.
* **Respuesta:** Retorna el objeto `UsuarioExternoDTO` recién creado (incluyendo su ID autogenerado).

### 2. Actualizar Cliente
Permite modificar información del usuario (nombre, contacto, etc.).

* **URL Completa:** `PUT http://localhost:8080/gym/api/usuarios-externos/{id}`
* **Parámetros de Ruta:** `id` (int) - Identificador del usuario a modificar.
* **Cuerpo (Body):** Objeto `UsuarioExternoDTO` con los datos nuevos.
* **Respuesta:** Retorna el objeto actualizado.

### 3. Obtener Cliente por ID
Busca un usuario específico.

* **URL Completa:** `GET http://localhost:8080/gym/api/usuarios-externos/{id}`
* **Parámetros de Ruta:** `id` (Integer).
* **Respuesta:**
    * **200 OK:** Si el usuario existe, devuelve el JSON del DTO.
    * **Error:** El manejo de excepciones (ej. 404 Not Found) es delegado a la capa de servicio (`UsuarioExternoService`).

### 4. Eliminar Cliente
Elimina el registro de un usuario.

* **URL Completa:** `DELETE http://localhost:8080/gym/api/usuarios-externos/{id}`
* **Parámetros de Ruta:** `id` (int).
* **Respuesta:** Retorna estado **200 OK** (void) tras la eliminación exitosa.

---

## 💻 Ejemplo de Estructura de Datos (JSON)

**UsuarioExternoDTO** (Ejemplo sugerido para POST/PUT):

```json
{
  "nombre": "Laura Martinez",
  "email": "laura.m@email.com",
  "telefono": "300-123-4567",
  "direccion": "Calle Falsa 123",
  "edad": 28,
  "peso": 65.5,
  "altura": 1.70
}

## 📅 Reservas (`BookingController`)
**Base Path:** `/gym/api/booking`

Servicios encargados del ciclo de vida de las reservas (creación, consulta, edición y cancelación).

### Endpoints de Bookings
| Método | Endpoint | Descripción |
| :--- | :--- | :--- |
| `POST` | `/create_booking` | Registra una nueva reserva en el sistema. |
| `GET` | `/all_bookings` | Recupera el historial de todas las reservas. |
| `GET` | `/boking_by_id/{id}` | Consulta una reserva específica mediante su ID. |
| `PUT` | `/update/{id}` | Modifica los datos de una reserva existente. |
| `DELETE` | `/delete_booking/{id}` | Elimina una reserva de forma permanente. |

---

## 🛠️ Especificaciones Técnicas de Bookings

### 1. Crear Reserva
* **URL:** `http://localhost:8080/gym/api/booking/create_booking`
* **Método:** `POST`
* **Cuerpo (JSON):** ```json
{
  "usuarioId": 1,
  "fecha": "2024-10-25",
  "hora": "10:00",
  "actividad": "Crossfit"
}
### 🛠️ Listado de Endpoints de Reservas

#### 1. Crear Reserva
Registra una nueva reserva en el sistema.
* **URL:** `POST /gym/api/booking/create_booking`
* **Body:** `BookingDTO` (JSON)
* **Retorno:** Objeto `BookingDTO` creado.

#### 2. Listar Todas las Reservas
Obtiene el historial completo de reservas.
* **URL:** `GET /gym/api/booking/all_bookings`
* **Retorno:** `List<BookingDTO>`

#### 3. Buscar Reserva por ID
Consulta el detalle de una reserva específica.
* **URL:** `GET /gym/api/booking/boking_by_id/{id}`
* **Parámetros:** `id` (Integer)
* **Retorno:** `BookingDTO`

#### 4. Actualizar Reserva
Modifica los datos de una reserva existente.
* **URL:** `PUT /gym/api/booking/update/{id}`
* **Parámetros:** `id` (Integer)
* **Body:** `BookingDTO` con los campos a actualizar.
* **Retorno:** `BookingDTO` actualizado.

#### 5. Eliminar Reserva
Cancela y elimina una reserva del sistema.
* **URL:** `DELETE /gym/api/booking/delete_booking/{id}`
* **Parámetros:** `id` (Integer)

---

## 💡 Notas Técnicas
* **Manejo de IDs:** Asegúrate de enviar los IDs como tipos numéricos en las URLs.
* **Persistencia:** Todos los cambios realizados a través de estos endpoints se reflejan inmediatamente en la base de datos vinculada a través de `BookingService` y `AdminService`.
* **Seguridad:** Se asume que estos endpoints están protegidos bajo roles administrativos.



## 📝 Tipos de Tarea (`TaskTypeController`)
**Base Path:** `/gym/api/task_type`

Este controlador gestiona las categorías o tipos de actividades/tareas disponibles en el gimnasio (ej. Yoga, Pesas, Cardio).

### Detalles de Endpoints

#### 1. Crear Tipo de Tarea
* **URL:** `POST /gym/api/task_type`
* **Body:** `TaskTypeDTO` (JSON)
* **Descripción:** Define una nueva categoría de actividad.

#### 2. Consultar por ID
* **URL:** `GET /gym/api/task_type/look_task_id/{id}`
* **Parámetros:** `id` (int)
* **Retorno:** Objeto `TaskTypeDTO`.

#### 3. Actualizar Tipo de Tarea
* **URL:** `PUT /gym/api/task_type/update_task/{id}`
* **Parámetros:** `id` (Integer)
* **Body:** `TaskTypeDTO` actualizado.

#### 4. Listar Todas las Tareas
* **URL:** `GET /gym/api/task_type/all_task`
* **Retorno:** `List<TaskTypeDTO>` con todas las tareas registradas.

#### 5. Eliminar Tipo de Tarea
* **URL:** `DELETE /gym/api/task_type/delete_task/{id}`
* **Parámetros:** `id` (Integer)

---

## 🛠️ Notas de Implementación General

1. **Protocolo:** Todas las peticiones deben realizarse sobre `http://localhost:8080`.
2. **Formato de Datos:** Se requiere el encabezado `Content-Type: application/json` para métodos `POST` y `PUT`.
3. **Persistencia:** Los cambios son gestionados por las capas de servicio (`AdminService`, `BookingService`, `TaskTypeService`) que aseguran la integridad de los datos en la base de datos.
4. **Fe de erratas en Rutas:** * Reservas: `/boking_by_id/{id}` (falta una 'o').
   * TaskType: `/look_task_id/{id}`.

# 🏋️ Documentación de API: Tipos de Entrenamiento

Este módulo gestiona el catálogo de modalidades de entrenamiento disponibles en el gimnasio (ej. Hipertrofia, Cardio, Crossfit, Yoga).

El controlador implementa **RESTful standards** utilizando códigos de estado HTTP semánticos (`200`, `201`, `204`, `404`) para una mejor integración con el cliente.

## 📋 Información Base

* **Controlador:** `TipoEntrenamientoController`
* **Paquete:** `com.CDD.GYM.web.controllers`
* **Ruta Base (Base URL):** `/gym/api/tipos-entrenamiento`
* **Host por defecto:** `http://localhost:8080`
* **Formato de intercambio:** `JSON`

---

## 🛠️ Resumen de Endpoints

| Método | Endpoint | Descripción | Status Exitoso |
| :--- | :--- | :--- | :--- |
| `GET` | `/` | Listar todos los tipos de entrenamiento. | `200 OK` / `204 No Content` |
| `GET` | `/{id}` | Buscar un tipo específico por ID. | `200 OK` |
| `POST` | `/` | Crear un nuevo tipo de entrenamiento. | `201 Created` |
| `PUT` | `/{id}` | Actualizar un tipo existente. | `200 OK` |
| `DELETE` | `/{id}` | Eliminar un tipo de entrenamiento. | `204 No Content` |

---

## 📑 Detalle de la API

### 1. Listar Todos
Obtiene la lista completa de tipos de entrenamiento registrados en la base de datos.

* **URL:** `GET /gym/api/tipos-entrenamiento`
* **Respuestas:**
    * `200 OK`: Retorna la lista de objetos `TipoEntrenamientoDTO`.
    * `204 No Content`: La petición fue exitosa, pero la lista está vacía (no hay registros).

### 2. Buscar por ID
Recupera el detalle de un solo tipo de entrenamiento.

* **URL:** `GET /gym/api/tipos-entrenamiento/{id}`
* **Parámetros de Ruta:**
    * `id` (Integer): Identificador único del tipo de entrenamiento.
* **Respuestas:**
    * `200 OK`: Objeto encontrado.
    * `404 Not Found`: No existe ningún registro con ese ID.

### 3. Crear Nuevo Tipo
Registra una nueva modalidad de entrenamiento.

* **URL:** `POST /gym/api/tipos-entrenamiento`
* **Headers:** `Content-Type: application/json`
* **Cuerpo de la Petición (Body):**
```json
{
  "nombre": "Crossfit Avanzado",
  "descripcion": "Entrenamiento de alta intensidad",
  "intensidad": "Alta"
}

