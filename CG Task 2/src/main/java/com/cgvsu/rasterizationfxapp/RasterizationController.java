package com.cgvsu.rasterizationfxapp;

import com.cgvsu.rasterization.Rasterization;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class RasterizationController {
    @FXML
    AnchorPane anchorPane;
    @FXML
    private Canvas canvas;

    public RasterizationController() {
    }

    @FXML
    private void initialize() {
        this.anchorPane.prefWidthProperty().addListener((ov, oldValue, newValue) -> {
            this.canvas.setWidth(newValue.doubleValue());
        });
        this.anchorPane.prefHeightProperty().addListener((ov, oldValue, newValue) -> {
            this.canvas.setHeight(newValue.doubleValue());
        });


        // Draw an ellipse
        Rasterization.drawEllipse(this.canvas.getGraphicsContext2D(), 400, 300, 100, 50, Color.RED);
    }
}