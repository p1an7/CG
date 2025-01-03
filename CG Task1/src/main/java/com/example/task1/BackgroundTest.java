package com.example.task1;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class BackgroundTest {

    @Test
    public void testBackgroundCreation() {
        Background background = new Background();
        Group root = background;

        // Check if the background contains a sky rectangle
        Rectangle sky = (Rectangle) root.getChildren().get(0);
        assertEquals(Color.LIGHTBLUE, sky.getFill());
        assertEquals(800.0, sky.getWidth());
        assertEquals(600.0, sky.getHeight());

        // Check if the background contains clouds
        int cloudCount = root.getChildren().size() - 1; // Subtract 1 for the sky rectangle
        assertEquals(9, cloudCount);

        for (int i = 1; i <= cloudCount; i++) {
            Circle cloud = (Circle) root.getChildren().get(i);
            assertEquals(Color.WHITE, cloud.getFill());
        }
    }
}