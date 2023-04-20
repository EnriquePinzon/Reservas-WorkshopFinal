# API REST: Sistema de reservas de Hotel Ashir :city_sunset:

## Descripción del proyecto
El sistema de reservas del hotel es una aplicación desarollada con Java utlizando Spring Boot, en la cual permite administrar las reservas de unas habitaciones en un hotel. Se utilizó un gestor de dependencias y un motor de base de datos con MySQL. Persistencia de datos con JPA e Hibernate.
## Tecnologías
CONFIGURACIÓN & REQUISITOS:

✔ Java 11 

✔ Spring Boot '2.7.10' 

✔ JPA e Hibernate

✔ MySQL

✔ JUnit (Test de pruebas unitarias)

✔ Swagger

## Patrón DTO (Data Transfer Object)

Se utilizó el patrón DTO, para separar los datos que se transfieren entre las capas de la aplicación. La creación de las clases DTO, dieron su  utilidad y representación de datos, los cuales sirven para transportar los datos desde los controladores a los respectivos servicios.


## Modelo de Entidad-Relación
Diagrama generado con la base de datos en MySQL

![imagen](https://user-images.githubusercontent.com/114439510/232651286-704694af-30c4-4ca4-9a7d-84a7883afc3e.png)

:small_blue_diamond: **Tabla cliente**: Almacena la información de todos los clientes, tales cómo: cédula, nombre, apellido, edad, correo, dirección.  
 
:small_blue_diamond: **Tabla habitación**: Almacena la información las habitaciones, tales cómo: número de habitación, tipo de habitación (estándar o premium), precio base. 

:small_blue_diamond: **Tabla reserva**: Almacena la información de todos los clientes, tales cómo: código de la reserva, fecha de la reserva, cédula asociada al cliente que reservó, número de la habitación reservada, total a debitar. 


## Microservicios
El proyecto constaba de tres microservicios: Cliente, Habitación y Reserva. Estos microservicios se comunicaron entre sí utilizando el protocolo HTTP, lo que permitió una comunicación eficiente y escalable entre los servicios. Lo que facilitó la evolución de cada uno de los servicios de manera independiente.


## :dart: Endpoints:
### Endpoint creación del cliente:
***POST:/api/v1/cliente***

Crea un nuevo cliente en la base de datos con la información necesaria en el body de la solicitud.

Parámetros de ingreso del cliente en formato JSON:

Cédula: (tipo numérico), nombre: (tipo texto) apellido: (tipo texto) direccion: (tipo texto) edad: (tipo numérico) correo: (tipo texto)

Una vez ingresados, la API nos devolverá la creación exitosa de un cliente en formato JSON.

![imagen](https://user-images.githubusercontent.com/114439510/232663552-06a6c5d8-9dbf-4a0b-b55e-04d1baf67745.png)

### Endpoint creación de la habitación:
***POST:/api/v1/habitacion***

Crea una habitación con los respectivos datos

numero habitación: (tipo numérico), tipoHabitacion (tipo texto), precioBase (tipo numérico)

Una vez ingresados, la API nos devolverá la creación exitosa de una habitación en formato JSON.

![imagen](https://user-images.githubusercontent.com/114439510/232661922-842ba66e-2d09-45fc-b797-11fa8ec8c382.png)

### Endpoint creación de la reserva:
Ejemplo:
***POST:/api/v1/reserva?cedula=1234&numero=60&fecha=10-07-2023***

Crea una reserva enviando los datos por medio del cuerpo de la petición. 

Una vez ingresados, la API nos devolverá la creación exitosa de una reserva en formato JSON.

![imagen](https://user-images.githubusercontent.com/114439510/232663748-84631abc-214d-4cd8-aaa3-012cfdda84ac.png)

### Endpoint obtener reserva por cédula del cliente:
Ejemplo:
***GET:/api/v1/reservas/1234*** 

Obtiene todas las reservas realizadas por el cliente con cédula 1234.

Una vez ingresados, la API nos devolverá las reservas asociadas al cliente en formato JSON.

![imagen](https://user-images.githubusercontent.com/114439510/233262039-a1a99b25-e802-4bb8-b77a-0430788d07f1.png)

# Diagrama de clases:
## Cliente

![Diagrama Clases Cliente](https://user-images.githubusercontent.com/114439510/233262767-4c532a1d-0db9-4669-a321-6b0c551442e1.png)

## Habitacion

![Diagrama de clases Habitacion](https://user-images.githubusercontent.com/114439510/233262834-2a476dbb-5889-4ab5-9b9a-d09e1355a7ef.png)

## Reserva 

![Diagrama de clases Reserva](https://user-images.githubusercontent.com/114439510/233262853-0467b644-bcd4-4322-a23e-6e5dcc5c43bc.png)

## Test Unitarios:
Dentro del proyecto se implementó Mockito & JUnit en el cual se pudo verificar el correcto funcionamiento de los componetes,métodos y sistemas empleados. 

## :pushpin: CI-Integración Continua:
En el proyecto utilicé la integración continua (CI) para automatizar el proceso de construcción, prueba y despliegue de mi aplicación. Utilicé GitHub Actions para configurar y ejecutar mis flujos de trabajo de CI, lo que me permitió detectar y solucionar problemas de manera más rápida y eficiente, así como liberar nuevas versiones de mi aplicación con mayor frecuencia y confianza.
Cada vez que se realizaba una solicitud o se realizaban cambios en el código, se ejecutaba automáticamente una serie de pruebas y verificaciones de calidad, lo que me permitió identificar y solucionar errores en una etapa temprana del proceso de desarrollo.

## :pushpin: CD-Despliegue Continuo:
En mi proyecto utilicé la entrega continua (CD) para automatizar el proceso de despliegue de mi aplicación en entornos de producción. Utilicé Railway para implementar y gestionar mi infraestructura de manera sencilla y escalable.
Configuré mi flujo de trabajo de CD en GitHub Actions para que, después de que las pruebas de integración y calidad fueran exitosas, se desplegara automáticamente la aplicación en Railway.
