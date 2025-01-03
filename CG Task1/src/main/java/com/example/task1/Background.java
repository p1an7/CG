package com.example.task1;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Background extends Group {

    public Background() {
        // Небо
        Rectangle sky = new Rectangle(0, 0, 800, 600);
        sky.setFill(Color.LIGHTBLUE);
        getChildren().add(sky);

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

        getChildren().addAll(cloud1, cloud2, cloud3, cloud4, cloud5, cloud6, cloud7, cloud8, cloud9);
    }
}
