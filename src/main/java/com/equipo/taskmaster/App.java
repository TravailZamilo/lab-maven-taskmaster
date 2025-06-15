package com.equipo.taskmaster;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertEquals;

public class App extends Application {

    public static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Bienvenido a TaskMaster!");
        System.out.println("Ambiente: " + System.getProperty("env.name"));

        addTask("Estudiar Maven");
        addTask("Leer sobre CI/CD");
        printTasks();

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ListView<String> taskList = new ListView<>();
        taskList.getItems().addAll(tasks);

        TextField input = new TextField();
        input.setPromptText("Nueva tarea");

        Button addButton = new Button("➕ Agregar");
        addButton.getStyleClass().add("btn-add");  // Usar clase CSS

        addButton.setOnAction(e -> {
            String task = input.getText();
            if (!task.isEmpty()) {
                addTask(task);
                taskList.getItems().add(task);
                input.clear();
            }
        });

        HBox inputArea = new HBox(10, input, addButton);
        inputArea.setPadding(new Insets(10));

        Button runTestsButton = new Button("🧪 Ejecutar Tests");
        runTestsButton.getStyleClass().add("btn-run-tests");  // Clase CSS

        TextArea testResults = new TextArea();
        testResults.setEditable(false);
        testResults.setPrefHeight(150);

        runTestsButton.setOnAction(e -> {
            Result result = JUnitCore.runClasses(AppTest.class);
            StringBuilder sb = new StringBuilder();

            if (result.getFailureCount() > 0) {
                sb.append("❌ Tests fallidos:\n");
                for (Failure failure : result.getFailures()) {
                    sb.append(failure.toString()).append("\n");
                }
            } else {
                sb.append("✅ Todos los tests pasaron correctamente.\n");
            }
            sb.append("Tests corridos: ").append(result.getRunCount()).append("\n");
            sb.append("Tiempo: ").append(result.getRunTime()).append(" ms\n");

            testResults.setText(sb.toString());
        });

        VBox root = new VBox(10,
                new Label("📋 Tareas pendientes:"),
                taskList,
                inputArea,
                runTestsButton,
                new Label("📊 Resultados de tests:"),
                testResults);

        root.setPadding(new Insets(15));
        root.getStyleClass().add("root-pane");  // Clase CSS

        Scene scene = new Scene(root, 450, 600);

        // Aquí cargamos el CSS desde src/main/resources/style.css
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        primaryStage.setTitle("TaskMaster Mejorado");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void addTask(String task) {
        tasks.add(task);
    }

    public static void printTasks() {
        System.out.println("Tareas pendientes:");
        for (String t : tasks) {
            System.out.println("- " + t);
        }
    }

    public static class AppTest {
        @Test
        public void testAddTask() {
            tasks.clear();
            addTask("Terminar ejercicio Maven");
            assertEquals(1, tasks.size());
        }
    }
}
