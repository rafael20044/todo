
# To-do List (backend con Spring Boot)

Este es un proyecto de backend para una aplicación de To-Do List, desarrollado con Spring Boot. El sistema incluye funcionalidades para gestionar tareas, usuarios y etiquetas, y permite la autenticación mediante JWT tokens.


![Spring Logo](https://www.4x-treme.com/wp-content/uploads/2019/10/spring-boot-logo.png)



## Características principales:

* CRUD de usuarios: Creación, lectura, actualización y eliminación de usuarios.
* CRUD de tareas: Gestión completa de tareas, incluyendo la creación, edición, eliminación y visualización de tareas.
* CRUD de etiquetas: Creación, edición y eliminación de etiquetas para organizar las tareas.
* Autenticación con JWT: Implementación de un sistema de autenticación seguro mediante tokens JWT.
Este proyecto es ideal para quienes buscan implementar un sistema de tareas con una arquitectura basada en Spring Boot y una capa de seguridad robusta con JWT.


## Variables de entorno

Este proyecto utiliza variables de entorno para configurar la conexión a la base de datos y la seguridad. Asegúrate de definir las siguientes variables en tu entorno o en el archivo `application.properties`:

```bash
spring.datasource.url=jdbc:postgresql://${DB_HOST}:${DB_PORT}/${DB_NAME}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASS}
```

* `DB_HOST`: Dirección del servidor de la base de datos (por ejemplo, localhost o la URL de tu base de datos remota).
* `DB_NAME`: Nombre de la base de datos que se usará para almacenar los datos de la aplicación.
* `DB_USER`: Nombre de usuario para acceder a la base de datos.
* `DB_PASS`: Contraseña correspondiente al usuario de la base de datos.
* `SECRET`: Clave secreta utilizada para firmar y verificar los tokens JWT. Asegúrate de que esta clave sea suficientemente compleja y única.


## Documentación

[Documentación](https://rafaelbarragan.vercel.app/proyectos)

