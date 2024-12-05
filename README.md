# Spring AI Chat Demo

Este proyecto es una aplicación web que utiliza **Spring AI** y la API de **Cohere** para la generación de respuestas basadas en IA. La arquitectura incluye un backend en Spring Boot y un frontend en React.

## Características
- **Spring AI** para la integración de modelos de IA de Cohere.
- Chat interactivo para enviar y recibir mensajes procesados por IA.
- Backend desacoplado del frontend para facilitar escalabilidad.
- Interfaz de usuario limpia y responsiva.

---

## Requisitos previos
- **Java 17+** (recomendado OpenJDK 17)
- **Maven 3.8+**
- **Node.js 16+** y **npm 8+**
- **Clave API de Cohere** (regístrate en [Cohere](https://cohere.com) para obtenerla).

---

## Configuración

### Clonar el repositorio

git clone https://github.com/elianap11/spring-ai-demo.git
cd spring-ai-demo

## Configurar variables de entorno

Crea un archivo application.properties en src/main/resources con el siguiente contenido:
spring.application.name=spring-ai-demo
cohere.api.key=TU_API_KEY
client.name=TU_CLIENT_NAME
Reemplaza TU_API_KEY con tu clave API de Cohere y TU_CLIENT_NAME con tu nombre de cliente.

## Ejecutar el backend

- Dirígete al directorio raíz del proyecto: cd spring-ai-demo
- Compila y ejecuta la aplicación: mvn spring-boot:run
- El servidor estará disponible en: http://localhost:8080.

## Ejecutar el frontend

- Ve al directorio del frontend: cd frontend
- Instala las dependencias: npm install
- Inicia el servidor de desarrollo: npm start
- Accede a la aplicación en: http://localhost:3000.

## Uso de Spring AI
Spring AI es una biblioteca que simplifica la integración de modelos de IA en aplicaciones Spring Boot. En este proyecto:

- CohereConfig.java: Configura el cliente Cohere para que funcione con la API de Cohere.
- IAController.java: Utiliza el cliente para enviar mensajes al modelo de Cohere.
- V2ChatRequest: Permite configurar el tipo de modelo (como command-r-plus) y enviar mensajes para obtener respuestas.

Ejemplo de cómo se utiliza Spring AI:
```bash
return cohere.v2()
    .chat(
        V2ChatRequest.builder()
            .model("command-r-plus")
            .messages(
                List.of(
                    ChatMessageV2.user(
                        UserMessage.builder()
                            .content(UserMessageContent.of(simpleMessage.getContent()))
                            .build()
                    )
                )
            )
            .build()
    );
```
Este enfoque facilita la integración con otros modelos de Cohere o incluso con otros proveedores de IA.

## Estructura del proyecto

Backend
- config/: Configuración de Spring AI y el cliente Cohere.
- controller/: Controlador REST para manejar los mensajes del usuario.
- dto/: Data Transfer Object para la estructura del mensaje.
- exceptions/: Manejador global de excepciones.
- application.properties: Configuración de variables del backend.

Frontend
- Chat.js: Componente principal del chat.
- Chat.css: Estilos del frontend.
- App.js: Punto de entrada del frontend.

## Tecnologías utilizadas
Backend
- Java 17
- Spring Boot 3.3.6
- Spring AI 1.0.0-M4
- Cohere Java SDK 1.5.0
Frontend
- React 18
- Axios (para solicitudes HTTP)
