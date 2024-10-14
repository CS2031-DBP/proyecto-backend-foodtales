# "Foodtales: Discover, taste, and tell" 💬🍽️👥

## CS 2031 Desarrollo Basado en Plataformas 💻

## Project Members 🤝


| Name                                  | GitHub User                                                           | Email                                                         |
|---------------------------------------|-----------------------------------------------------------------------|---------------------------------------------------------------|
| Ronal Jesus Condor Blas               | [Ronal-Jesus-Condor-Blas](https://github.com/Ronal-Jesus-Condor-Blas) | [ronal.condor@utec.edu.pe](mailto:ronal.condor@utec.edu.pe)   |
| Isaac Emanuel Javier Simeón Sarmiento | [Isaac181222](https://github.com/Isaac181222)                         | [isaac.simeon@utec.edu.pe](mailto:isaac.simeon@utec.edu.pe)   |
| Luis David Barahona Valdivieso        | [LuissBarahona](https://github.com/LuissBarahona)                     | [luis.barahona@utec.edu.pe](mailto:luis.barahona@utec.edu.pe) |

## Índice
- [Introducción](#introducción)
- [Identificación del Problema o Necesidad](#identificación-del-problema-o-necesidad)
- [Descripción de la Solución](#descripción-de-la-solución)
- [Modelo de Entidades](#modelo-de-entidades)
- [Testing y Manejo de Errores](#testing-y-manejo-de-errores)
- [Medidas de Seguridad Implementadas](#medidas-de-seguridad-implementadas)
- [Eventos y Asincronía](#eventos-y-asincronía)
- [GitHub](#github)
- [Conclusiones](#conclusiones)
- [Apéndice](#apéndice)

## Introducción

### Contexto: ✏️
En la actualidad, existen muchas plataformas que permiten a los usuarios buscar lugares para comer, pero pocas ofrecen un espacio donde se puedan compartir de forma auténtica las experiencias, reseñas y opiniones relacionadas con la comida. Las personas no solo buscan un lugar para comer, sino también un espacio donde puedan hablar sobre sus descubrimientos, compartir reseñas, expresar sus opiniones y explorar nuevas opciones culinarias a través de las experiencias de otros usuarios. Foodtales surge como una solución que une una red social con el mundo gastronómico, permitiendo a los usuarios encontrar lugares de comida y compartir sus vivencias con una comunidad activa.

### Objetivos del proyecto: 🎯
a) Permitir a los usuarios encontrar restaurantes, cafés, food trucks y otros lugares de comida en función de sus preferencias.  
b) Facilitar que los usuarios puedan escribir reseñas y compartir opiniones sobre sus experiencias gastronómicas.  
c) Crear un espacio para que los usuarios puedan debatir y compartir recomendaciones sobre diferentes tipos de cocina y platos.  
d) Ofrecer herramientas para que los usuarios puedan seguir a otros amantes de la comida y explorar sus recomendaciones.  

## Identificación del problema o necesidad
### Descripción del problema: 🤔
En la actualidad, existe una creciente demanda por experiencias gastronómicas únicas y auténticas. Sin embargo, muchas personas tienen dificultades para encontrar recomendaciones confiables y actualizadas sobre lugares de comida, especialmente en zonas menos populares. A pesar de que existen diversas plataformas de reseñas, estas suelen ser impersonales, dispersas o carecen de un enfoque específico en la experiencia completa alrededor de los alimentos. Además, los usuarios buscan más que simples calificaciones; desean una comunidad en la que puedan compartir historias y experiencias en torno a la comida.
### Justificación: ✅
Resolver esta necesidad es crucial porque la comida no solo satisface una necesidad básica, sino que también representa una forma de cultura, identidad y conexión social. Foodtales permitirá a los usuarios descubrir nuevos lugares, expresar opiniones auténticas y conectarse con otros amantes de la gastronomía en un espacio interactivo. Esta plataforma fomentará la creación de una comunidad donde cada experiencia culinaria sea valorada como parte de una historia, aportando así valor tanto a consumidores como a restaurantes. Conectar personas a través de las experiencias gastronómicas no solo enriquece las recomendaciones, sino que también contribuye al crecimiento de los negocios locales.

## Descripción de la solución
### Funcionalidades Implementadas: 🛠️
1. **Registro y Autenticación de Usuarios:**
    - Implementación de un sistema de autenticación basado en **JWT (JSON Web Tokens)**, permitiendo a los usuarios registrarse e iniciar sesión de forma segura.
    - Dos endpoints principales:
        - `/auth/login`: Permite a los usuarios iniciar sesión con sus credenciales.
        - `/auth/register`: Permite a los usuarios registrarse proporcionando los detalles necesarios.
    - Manejo seguro de contraseñas y generación de tokens de acceso para las sesiones de usuario.

2. **Gestión de Publicaciones (Posts):**
    - Los usuarios pueden crear, editar y eliminar publicaciones donde comparten sus experiencias gastronómicas.
    - Las publicaciones permiten la inclusión de texto y calificaciones relacionadas con comidas o restaurantes.
    - Cada publicación se asocia a un usuario y puede tener múltiples comentarios de otros usuarios.

3. **Sistema de Comentarios:**
    - Los usuarios pueden comentar en las publicaciones de otros usuarios, lo que fomenta la interacción y discusión en torno a los temas culinarios.
    - Los comentarios son gestionados a través de un controlador dedicado, permitiendo crear y eliminar comentarios asociados a publicaciones específicas.

4. **Gestión de Restaurantes:**
    - Los usuarios pueden agregar nuevos restaurantes a la plataforma.
    - Cada restaurante tiene atributos como nombre, ubicación y correo electrónico, y puede ser actualizado o eliminado por los administradores.
    - Funcionalidad para publicar eventos específicos cuando un nuevo restaurante es registrado, como el envío de correos electrónicos automáticos de bienvenida.

5. **Eventos Asíncronos:**
    - El sistema incluye eventos asíncronos, como el envío de correos electrónicos cuando un nuevo restaurante es registrado en la plataforma.
    - Implementación de la anotación `@EnableAsync` en el proyecto para permitir el procesamiento de tareas de manera asíncrona, mejorando el rendimiento y la escalabilidad.

6. **Manejo de Errores y Validación:**
    - Manejo adecuado de errores en los endpoints, devolviendo respuestas HTTP apropiadas (como `404 Not Found` o `400 Bad Request`) cuando es necesario.
    - Validación de los datos de entrada en las solicitudes de creación y actualización de publicaciones, comentarios y restaurantes.

### Tecnologías Utilizadas: 🤖
1. **Spring Boot 3.3.4:**
   - **Spring Boot Starter Web**: Utilizado para crear el backend de la aplicación, manejando las solicitudes HTTP y proporcionando APIs RESTful.
   - **Spring Boot Starter Data JPA**: Usado para la persistencia de datos mediante el mapeo objeto-relacional (ORM) con JPA/Hibernate.
   - **Spring Boot Starter Mail**: Para el envío de correos electrónicos de manera sencilla, como parte de la funcionalidad de notificaciones.

2. **Base de Datos:**
   - **PostgreSQL**: Base de datos relacional utilizada para almacenar la información de usuarios, publicaciones, comentarios y restaurantes.
   - **H2 Database**: Base de datos en memoria usada principalmente para pruebas en el entorno de desarrollo.
   - **Testcontainers (PostgreSQL)**: Utilizado para pruebas de integración, ejecutando contenedores Docker de PostgreSQL durante los tests.

3. **Seguridad:**
   - **JWT (JSON Web Tokens)**: Implementado para la autenticación y autorización de usuarios, garantizando sesiones seguras.
   - **Hibernate Validator**: Utilizado para la validación de datos y garantizar la consistencia de las solicitudes recibidas.

4. **Manejo de Eventos Asíncronos:**
   - **Spring Async**: Implementado para el procesamiento de tareas de manera asíncrona, mejorando la eficiencia del sistema en tareas como el envío de correos.

5. **Envío de Correos:**
   - **Jakarta Mail (JavaMail)**: Utilizado para enviar correos electrónicos automáticos, como notificaciones de bienvenida a los nuevos restaurantes registrados.

6. **Otras Tecnologías:**
   - **Lombok**: Usado para reducir el código repetitivo, proporcionando anotaciones que simplifican la creación de getters, setters y constructores.
   - **Gson**: Biblioteca de Google para el procesamiento de JSON, utilizada para la serialización y deserialización de objetos.
   - **OkHttp**: Cliente HTTP utilizado para realizar peticiones HTTP de manera eficiente.

## Modelo de Entidades
![Entity-Relationship Diagram](docs/images/Comment.png)

### Descripción: 📋
| Entidad          | Descripción                                                                                                                                               | Relaciones                                                                                                   |
|------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------|
| **User**         | Representa a un usuario de la plataforma. Incluye atributos como nombre, correo electrónico, contraseña, biografía, y tipo de usuario (UserType).            | - Un usuario puede tener varios **posts** y **comentarios**.<br> - Relación muchos a muchos con otros **usuarios** (seguidores). |
| **Post**         | Representa una publicación realizada por un usuario, donde comparte su experiencia o reseña sobre algún restaurante o comida.                               | - Un **post** es creado por un **usuario**.<br> - Un **post** puede tener múltiples **comentarios**.         |
| **Comment**      | Representa un comentario hecho por un usuario en una publicación (post). Incluye el contenido del comentario y la fecha en que se realizó.                  | - Un **comentario** pertenece a un **post** y es hecho por un **usuario**.                                   |
| **Food**         | Representa un plato de comida. Incluye atributos como nombre, precio, calificación promedio y estado (disponible o no disponible).                          | - Un **plato** puede estar asociado con un **restaurante**.<br> - Puede recibir varias **valoraciones de comida**. |
| **Restaurant**   | Representa un restaurante en la plataforma, incluyendo su nombre, ubicación, y estado.                                                                     | - Un **restaurante** puede tener varios **platos**.<br> - Los **usuarios** pueden hacer valoraciones a los **restaurantes**.     |
| **TypeFood**     | Representa un tipo de comida, como italiana, mexicana, o peruana. Incluye el nombre y una descripción opcional.                                             | - Relación muchos a muchos con **restaurantes**.<br> Un restaurante puede tener varios tipos de comida.       |
| **FoodRating**   | Representa una calificación que un usuario realiza sobre un plato específico, con una puntuación del 1 al 5 y un comentario opcional.                        | - Relación muchos a uno con **plato (Food)** y **usuario**.                                                  |
| **RestaurantRating** | Representa una calificación que un usuario realiza sobre un restaurante, con una puntuación del 1 al 5 y un comentario opcional.                            | - Relación muchos a uno con **restaurante (Restaurant)** y **usuario**.                                       |
## Testing y Manejo de Errores

### Niveles de Testing Realizados: 🛠️

En el proyecto **Foodtales**, se han implementado pruebas unitarias utilizando **JUnit 5**, un framework de pruebas ampliamente utilizado para proyectos Java. Los tests se encargan de verificar el correcto funcionamiento de las entidades del dominio, asegurando que las funcionalidades clave se comporten como se espera.

#### Ejemplos de Casos de Prueba
Uno de los componentes probados es la entidad `Comment`, la cual está relacionada con las publicaciones y los usuarios. A continuación se describen algunos de los casos de prueba implementados:

- **Creación de un comentario**:
   - Se verifica que un comentario se cree correctamente con todos sus atributos, como el contenido, la fecha, el usuario y el post asociado.
   - Ejemplo: Se espera que un comentario creado tenga el mismo contenido y esté asociado a la publicación y usuario correctos.

- **Actualización del contenido de un comentario**:
   - Se prueba que es posible actualizar el contenido de un comentario y que el nuevo contenido es correctamente almacenado.

- **Relaciones entre entidades**:
   - Existen pruebas que garantizan la correcta relación entre un comentario y su publicación (`Post`) y entre un comentario y su usuario (`User`).
   - Ejemplo: Se asegura que el comentario tenga una referencia válida a la publicación a la que pertenece y al usuario que lo creó.

Estas pruebas unitarias ayudan a garantizar la estabilidad y confiabilidad del sistema, ya que cubren escenarios comunes y validan las relaciones entre las entidades del dominio.

### Resultados: 📊

Los tests han permitido confirmar que las funcionalidades clave, como la creación, actualización y validación de relaciones entre entidades (`Comment`, `Post`, `User`), se comportan correctamente en diversos escenarios de prueba. Esto asegura que las interacciones principales del sistema estén funcionando de manera estable y sin errores.

### Manejo de Errores: ❌

El manejo de errores en la aplicación sigue un enfoque basado en **excepciones** y **respuestas controladas** a los errores de negocio o problemas inesperados. Utilizando las características de Spring Boot, se asegura que los errores se gestionen de manera centralizada y coherente.

#### Mecanismos de Manejo de Errores:

- **Control de Excepciones**:
   - La aplicación utiliza controladores de errores globales mediante la anotación `@ControllerAdvice` de Spring Boot, lo que permite capturar y manejar excepciones lanzadas durante la ejecución de las peticiones HTTP.
   - Ejemplo: Si ocurre un error de validación o una entidad no es encontrada (por ejemplo, un comentario o usuario inexistente), se retorna una respuesta adecuada con un código de estado HTTP descriptivo como 404 (Not Found) o 400 (Bad Request).

- **Mensajes de Error Detallados**:
   - Se pueden generar mensajes de error personalizados que informen a los usuarios o desarrolladores de manera clara sobre la naturaleza del problema.
   - Ejemplo: Un mensaje de error como "El comentario no pudo ser encontrado" puede ser enviado en una respuesta JSON cuando una búsqueda falla.

- **Validaciones**:
   - Se asegura que los datos introducidos o actualizados cumplan con los requisitos de negocio. Si una validación falla, Spring Boot dispara excepciones como `MethodArgumentNotValidException`, las cuales pueden ser manejadas en un controlador global de excepciones.

## Medidas de Seguridad Implementadas

### Seguridad de Datos: 🛡️

En la aplicación **Foodtales**, se han implementado diversas medidas para garantizar la seguridad de los datos, asegurando que la información sensible esté protegida frente a accesos no autorizados. Entre las medidas clave destacan:

- **Autenticación y Autorización**: Se ha implementado un sistema de autenticación basado en **JWT (JSON Web Tokens)**, el cual permite identificar a los usuarios de manera segura en cada solicitud. Además, se han configurado roles y permisos para controlar el acceso a diferentes recursos de la aplicación, asegurando que solo los usuarios autorizados puedan realizar determinadas acciones.

- **Encriptación de Contraseñas**: Las contraseñas de los usuarios se almacenan de forma segura utilizando algoritmos de hashing como **BCrypt**, lo que garantiza que en caso de una filtración de la base de datos, las contraseñas no sean accesibles de forma directa.

- **Conexiones Seguras (HTTPS)**: La aplicación está configurada para utilizar **HTTPS** en la comunicación entre el servidor y los clientes, asegurando que los datos transferidos estén cifrados y no puedan ser interceptados por atacantes en la red.

### Prevención de Vulnerabilidades: 🚨

Para proteger la aplicación frente a vulnerabilidades comunes, se han seguido las mejores prácticas de seguridad en el desarrollo de software, algunas de las cuales incluyen:

- **Protección contra Inyecciones SQL**: Se utilizan **ORM (Object-Relational Mapping)** como **Hibernate**, lo que permite interactuar con la base de datos utilizando consultas seguras, previniendo ataques de inyección SQL.

- **Validación de Entradas**: Se han implementado validaciones exhaustivas en las entradas del usuario, asegurando que los datos introducidos cumplan con los formatos y reglas necesarias antes de ser procesados por el sistema. Esto ayuda a mitigar riesgos como **Cross-Site Scripting (XSS)** y **ataques de inyección**.

- **Cabeceras de Seguridad**: La aplicación incluye cabeceras HTTP de seguridad configuradas correctamente, tales como **X-Content-Type-Options**, **X-Frame-Options** y **Content-Security-Policy**, lo que ayuda a prevenir ataques como **Clickjacking** y **ejecución de scripts maliciosos**.

- **Gestión de Sesiones**: El sistema gestiona las sesiones de usuario de manera segura, con configuraciones para la expiración de tokens de autenticación y protección contra ataques de secuestro de sesiones (Session Hijacking).

Todas estas medidas de seguridad permiten que **Foodtales** se mantenga firme frente a amenazas y garantice la integridad y confidencialidad de los datos gestionados.


## Deploy en AWS 
![Screenshot from 2024-10-13 23-51-27](https://github.com/user-attachments/assets/9d77769b-4c7b-45a2-b813-8c7e7c7ced2b)

Se logró realizar el deployment del backend en AWS.La ip de la captura fue la última registrada antes del último cambio del Readme.
Se implementó un GitHub Actions para hacer el deployment auomáticamente con un push al main.


## Eventos y Asincronía
En **Foodtales**, los eventos y la asincronía juegan un papel importante para mejorar la eficiencia del sistema, especialmente en tareas que no requieren una respuesta inmediata. El envío de correos electrónicos es uno de los principales ejemplos de este enfoque. En lugar de procesar estas tareas de manera síncrona, lo cual podría generar demoras innecesarias para el usuario, se ejecutan en segundo plano, permitiendo que la experiencia sea más fluida.
### Casos de uso del envío de correos electrónicos:
1. **Registro de un Nuevo Usuario:**
   - Cuando un nuevo usuario se registra en la plataforma, se dispara un evento que envía de forma asíncrona un correo electrónico de bienvenida. Este correo confirma el registro del usuario y proporciona información útil para comenzar a interactuar en la plataforma. El envío de este correo en segundo plano permite que el usuario complete el proceso de registro sin esperas innecesarias.

2. **Registro de un Nuevo Restaurante:**
   - Cuando un restaurante es registrado por un usuario, también se genera un evento asíncrono que envía un correo electrónico de bienvenida al propietario del restaurante. Este correo está diseñado para proporcionar instrucciones sobre cómo gestionar el perfil del restaurante dentro de la plataforma, destacando herramientas que pueden ayudar a mejorar su visibilidad frente a otros usuarios. Este evento se ejecuta sin afectar la fluidez de la experiencia del usuario, mejorando la escalabilidad del sistema.
## GitHub
El desarrollo de **Foodtales** se gestionó de forma colaborativa utilizando **GitHub**, donde se emplearon ramas, issues y pull requests para organizar y revisar el trabajo de todo el equipo.

- **Ramas (Branches):** Cada nueva funcionalidad o corrección de errores se desarrolló en ramas independientes para evitar conflictos en la rama principal (`main`). Esto permitió que los miembros del equipo trabajaran en paralelo de manera eficiente.

- **Issues:** Se utilizaron issues para asignar tareas, reportar errores y gestionar el progreso del proyecto. Las etiquetas (`bug`, `enhancement`) ayudaron a priorizar las tareas y mantener el enfoque en lo más importante.

- **Pull Requests:** Antes de fusionar cualquier cambio en la rama principal, se creaba un pull request. Esto permitió que los cambios fueran revisados y discutidos por el equipo, asegurando la calidad del código antes de su integración.

Este flujo de trabajo colaborativo permitió mantener el proyecto organizado, mejorar la calidad del código mediante revisiones, y asegurar una integración continua sin problemas.
## Conclusiones
### Logros del Proyecto: 📝
El desarrollo de Foodtales ha permitido crear una plataforma que resuelve una necesidad significativa al ofrecer un espacio donde los usuarios pueden encontrar y compartir experiencias culinarias de forma auténtica. Se ha logrado integrar funcionalidades para la publicación de reseñas y discusión abierta entre amantes de la comida. Esto ha contribuido a la construcción de una comunidad activa en torno a la gastronomía, facilitando el descubrimiento de nuevos lugares y el crecimiento de pequeños negocios locales.
### Aprendizajes Clave: 📚
Durante el desarrollo de la aplicación, aprendimos la importancia de planificar bien la estructura del código para que fuera fácil de mantener y mejorar. Además, trabajar con retroalimentación constante nos ayudó a ajustar detalles de la interfaz, mejorando la usabilidad y asegurando una experiencia positiva para los usuarios.
### Trabajo Futuro: 🚀
En el futuro, nos gustaría agregar más funciones, como filtros para buscar comida según preferencias personales o recomendaciones en tiempo real. También planeamos ofrecer recompensas para los usuarios más activos y hacer alianzas con restaurantes para ofrecer descuentos exclusivos a la comunidad.

## Apéndice
### Licencia
Foodtales está bajo la licencia MIT.

### Referencias
- Documentación de Node.js: https://nodejs.org/
- Documentación de PostgreSQL: https://www.postgresql.org/docs/
