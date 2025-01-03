package com.example.task1;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class FighterJetAnimation extends Application {

    private FighterJet fighterJet;

    @Override
    public void start(Stage primaryStage) {
        // Создаем фон
        Background background = new Background();

        // Создаем истребитель
        fighterJet = new FighterJet();

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
                fighterJet.move();
            }
        };
        timer.start();

        // Обработка нажатий клавиш для управления истребителем
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
                fighterJet.setDeltaY(-1);
            } else if (event.getCode() == KeyCode.DOWN) {
                fighterJet.setDeltaY(1);
            } else if (event.getCode() == KeyCode.LEFT) {
                fighterJet.setDeltaX(-1);
            } else if (event.getCode() == KeyCode.RIGHT) {
                fighterJet.setDeltaX(1);
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
