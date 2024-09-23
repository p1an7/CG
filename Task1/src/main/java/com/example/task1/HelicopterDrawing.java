//package com.example.task1;
//
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//import javafx.animation.AnimationTimer;
//import javafx.application.Application;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.input.KeyCode;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Circle;
//import javafx.scene.shape.Polygon;
//import javafx.scene.shape.Rectangle;
//import javafx.stage.Stage;
//
//public class HelicopterDrawing {
//    @Override
//    public void start(Stage primaryStage) {
//        Pane pane = new Pane();
//
//        // Создаем корпус вертолета
//        Polygon body = new Polygon();
//        body.getPoints().addAll(new Double[]{
//                50.0, 100.0,
//                100.0, 75.0,
//                120.0, 75.0,
//                170.0, 100.0,
//                120.0, 125.0,
//                100.0, 125.0
//        });
//        body.setFill(Color.BLUE);
//
//        // Создаем лопасти вертолета
//        Polygon rotor = new Polygon();
//        rotor.getPoints().addAll(new Double[]{
//                85.0, 75.0,
//                115.0, 75.0,
//                110.0, 60.0,
//                90.0, 60.0
//        });
//        rotor.setFill(Color.DARKGRAY);
//
//        // Создаем хвост вертолета
//        Polygon tail = new Polygon();
//        tail.getPoints().addAll(new Double[]{
//                140.0, 90.0,
//                170.0, 90.0,
//                155.0, 100.0,
//                140.0, 100.0
//        });
//        tail.setFill(Color.DARKBLUE);
//
//        // Добавляем все части на панель
//        pane.getChildren().addAll(body, rotor, tail);
//
//        Scene scene = new Scene(pane, 400, 300);
//        primaryStage.setTitle("Helicopter Drawing");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//}
