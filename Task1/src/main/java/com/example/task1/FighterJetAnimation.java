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

    private double deltaX = 2;
    private double deltaY = 0;
    private Polygon fighterJet;

    @Override
    public void start(Stage primaryStage) {
        // Создаем фон (небо и облака)
        Group background = createBackground();

        // Создаем форму истребителя
        fighterJet = createFighterJet();

        // Создаем группу и добавляем фон и истребитель
        Group root = new Group();
        root.getChildren().addAll(background, fighterJet);

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
    private Polygon createFighterJet() {
        Polygon fighterJet = new Polygon();
        fighterJet.getPoints().addAll(new Double[]{
                0.0, 0.0,
                30.0, -10.0,
                20.0, 0.0,
                30.0, 10.0,
                0.0, 0.0,
                -20.0, 5.0,
                -20.0, -5.0
        });
        fighterJet.setFill(Color.BLACK);
        fighterJet.setTranslateX(400);
        fighterJet.setTranslateY(300);
        return fighterJet;
    }

    // Метод для движения истребителя
    private void moveFighterJet() {
        fighterJet.setTranslateX(fighterJet.getTranslateX() + deltaX);
        fighterJet.setTranslateY(fighterJet.getTranslateY() + deltaY);

        // Ограничение движения по экрану
        if (fighterJet.getTranslateX() > 800) {
            fighterJet.setTranslateX(0);
        } else if (fighterJet.getTranslateX() < 0) {
            fighterJet.setTranslateX(800);
        }

        if (fighterJet.getTranslateY() > 600) {
            fighterJet.setTranslateY(0);
        } else if (fighterJet.getTranslateY() < 0) {
            fighterJet.setTranslateY(600);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}