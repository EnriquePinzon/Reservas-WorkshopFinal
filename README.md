# Sistema de reservas de Hotel.

# Descripción del proyecto
La aplicación del proyecto permite y simula que un cliente realice una reserva en un hotel. Permite una relación entre los datos de un cliente con la reserva en el hotel, las habitaciones de un  hotel disponibles tanto en fecha como el tipo de habitación ya sea premium o estándar..

# Tecnologías
El workshop de reservas se construyó con:

✔ Java 11 

✔ SpringBoot 

✔ JPA

✔ MySQL 

✔ JUnit

✔ Swagger

# Funcionalidades

- Cliente: debe registrarse en la base de datos con sus respectivos datos. Para el uso del servicio de reservas en el hotel y habitación

- Habitación: La creación y registro de Habitación en la base de datos.

- Reserva: Creación de hacia un cliente una reserva en la base de datos.

Funcionalidad del sistema:
El sistema tiene requisitos para su función orgánica, primero, se debe obligatoriamente registrar  el 'Cliente' en la aplicación para poder usar el sistema de reservas, para ello los datos ingresados en los campos deben estar en el tipo de datos correctos, en caso tal de diligenciar datos erróneos, el sistema arrojará avisos de tipo de errores de datos.
Una vez registrado el 'Cliente' en el Sistema, el Cliente tiene la posibilidad de buscar habitaciones por tipo de habitación ya sea (premium o estándar) y fechas para reservas tales como si está disponible, que no permita generar o buscar a una fecha a la actual. 
Una vez el Cliente solicite una habitación para reservar, los sistemas validarán si la habitación está disponible o no y el sistema responderá con una reserva exitosa o una reserva rechazada
