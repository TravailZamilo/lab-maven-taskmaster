# 🚀 Laboratorio Maven - TaskMaster

Este proyecto es parte de mi laboratorio de **DevOps Fundamentals**, donde implementé un gestor simple de tareas usando **Java** y **Maven**.

## 📌 Descripción del proyecto
TaskMaster es una pequeña aplicación en Java que permite agregar y listar tareas. El objetivo principal fue practicar el uso de **Maven**, su ciclo de vida, gestión de dependencias, perfiles y empaquetado.

Además, ahora cuenta con una **interfaz gráfica mejorada** usando JavaFX que permite:
- Agregar tareas desde la interfaz.
- Visualizar las tareas en una lista.
- Ejecutar tests unitarios JUnit integrados desde la app y ver los resultados en pantalla.

## ⚙️ Comandos usados con Maven
- mvn clean
- mvn compile
- mvn package
- mvn javafx:run -Pdev -Denv.name=Dev

## 📦 Dependencias y plugins utilizados
- JUnit 4.13.2 (para pruebas)
- JavaFX 20.0.2 (controles y base)
- maven-compiler-plugin 3.8.1
- exec-maven-plugin 3.1.0
- javafx-maven-plugin 0.0.8

## 📝 Respuestas a preguntas del laboratorio

**¿Qué aprendiste sobre el ciclo de vida de Maven?**  
Aprendí que Maven tiene fases claras (clean, compile, package, etc.) que ayudan a automatizar y organizar el proceso de construcción de una app Java.

**¿Cómo facilita Maven el trabajo en equipo y la reproducibilidad?**  
Facilita porque el pom.xml define todo lo necesario: versiones, dependencias y plugins, asegurando que el proyecto funcione igual para todos los miembros del equipo.

**¿Cuál fue el mayor reto al trabajar con dependencias?**  
El mayor reto fue configurar correctamente las versiones de plugins y el archivo pom.xml para que no hubiera errores de parseo o compatibilidad.

**¿Por qué crees que Maven es tan usado en entornos empresariales?**  
Porque simplifica la gestión de proyectos grandes, garantiza reproducibilidad y facilita la integración con herramientas de CI/CD como Jenkins o SonarQube.

**¿Qué harías diferente si tuvieras que automatizar otro proyecto?**  
Planificaría mejor el archivo pom.xml desde el principio, agregando perfiles y plugins necesarios para integración continua y despliegue automático.
