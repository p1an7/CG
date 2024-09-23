package com.example.task1;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FighterJetAnimation extends Application {

    private double deltaX = 0;
    private double deltaY = 0;
    private Group helicopter;

    @Override
    public void start(Stage primaryStage) {
        // Создаем фон (небо и облака)
        Group background = createBackground();

        // Создаем форму истребителя
        helicopter = createFighterJet();

        // Создаем группу и добавляем фон и истребитель
        Group root = new Group();
        root.getChildren().addAll(background, helicopter);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Fighter Jet Animation");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Запускаем анимацию
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                moveFighterJet();
            }
        };
        timer.start();

        // Обработка нажатий клавиш для управления истребителем
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
                deltaY -= 1;
            } else if (event.getCode() == KeyCode.DOWN) {
                deltaY += 1;
            } else if (event.getCode() == KeyCode.LEFT) {
                deltaX -= 1;
            } else if (event.getCode() == KeyCode.RIGHT) {
                deltaX += 1;
            }
        });
    }

    // Метод для создания фона
    private Group createBackground() {
        Group background = new Group();

        // Небо
        Rectangle sky = new Rectangle(0, 0, 800, 600);
        sky.setFill(Color.LIGHTBLUE);
        background.getChildren().add(sky);

        // Облака
        Circle cloud1 = new Circle(100, 120, 40);
        cloud1.setFill(Color.WHITE);
        Circle cloud2 = new Circle(140, 120, 40);
        cloud2.setFill(Color.WHITE);
        Circle cloud3 = new Circle(400, 80, 40);
        cloud3.setFill(Color.WHITE);
        Circle cloud4 = new Circle(600, 50, 50);
        cloud4.setFill(Color.WHITE);
        Circle cloud5 = new Circle(200, 110, 50);
        cloud5.setFill(Color.WHITE);
        Circle cloud6 = new Circle(160, 110, 60);
        cloud6.setFill(Color.WHITE);
        Circle cloud7 = new Circle(660, 50, 50);
        cloud7.setFill(Color.WHITE);
        Circle cloud8 = new Circle(440, 80, 40);
        cloud8.setFill(Color.WHITE);
        Circle cloud9 = new Circle(425, 50, 30);
        cloud9.setFill(Color.WHITE);

        background.getChildren().addAll(cloud1, cloud2, cloud3, cloud4, cloud5, cloud6, cloud7, cloud8, cloud9);

        return background;
    }

    // Метод для создания истребителя
    private Group createFighterJet() {
        Group helicopter = new Group();

        // Создаем корпус вертолета
        Polygon body = new Polygon();
        body.getPoints().addAll(new Double[]{
                50.0, 100.0,
                100.0, 75.0,
                120.0, 75.0,
                170.0, 100.0,
                120.0, 125.0,
                100.0, 125.0
        });
        body.setFill(Color.BLUE);

        // Создаем лопасти вертолета
        Polygon rotor = new Polygon();
        rotor.getPoints().addAll(new Double[]{
                85.0, 75.0,
                115.0, 75.0,
                110.0, 60.0,
                90.0, 60.0
        });
        rotor.setFill(Color.DARKGRAY);

        // Создаем хвост вертолета
        Polygon tail = new Polygon();
        tail.getPoints().addAll(new Double[]{
                140.0, 90.0,
                170.0, 90.0,
                155.0, 100.0,
                140.0, 100.0
        });
        tail.setFill(Color.DARKBLUE);
        //TODO переделать вертолет на нормальный и разбить все по принципам ооп

        // Добавляем все части на панель
        helicopter.getChildren().addAll(body, rotor, tail);
        helicopter.setTranslateX(400);
        helicopter.setTranslateY(300);
        return helicopter;
    }

    // Метод для движения истребителя
    private void moveFighterJet() {
        helicopter.setTranslateX(helicopter.getTranslateX() + deltaX);
        helicopter.setTranslateY(helicopter.getTranslateY() + deltaY);

        // Ограничение движения по экрану
        if (helicopter.getTranslateX() > 800) {
            helicopter.setTranslateX(0);
        } else if (helicopter.getTranslateX() < 0) {
            helicopter.setTranslateX(800);
        }

        if (helicopter.getTranslateY() > 600) {
            helicopter.setTranslateY(0);
        } else if (helicopter.getTranslateY() < 0) {
            helicopter.setTranslateY(600);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}