package com.example.task1;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class FighterJet extends Group {

    private double deltaX = 0;
    private double deltaY = 0;

    public FighterJet() {
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

        // Добавляем все части на панель
        getChildren().addAll(body, rotor, tail);
        setTranslateX(400);
        setTranslateY(300);
    }

    public void move() {
        setTranslateX(getTranslateX() + deltaX);
        setTranslateY(getTranslateY() + deltaY);

        // Ограничение движения по экрану
        if (getTranslateX() > 800) {
            setTranslateX(0);
        } else if (getTranslateX() < 0) {
            setTranslateX(800);
        }

        if (getTranslateY() > 600) {
            setTranslateY(0);
        } else if (getTranslateY() < 0) {
            setTranslateY(600);
        }
    }

    public void setDeltaX(double deltaX) {
        this.deltaX = deltaX;
    }

    public void setDeltaY(double deltaY) {
        this.deltaY = deltaY;
    }
}
