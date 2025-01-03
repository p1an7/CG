package com.example.task1;

import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
public class FighterJetAnimationTest {

    @Start
    public void start(Stage stage) {
        new FighterJetAnimation().start(stage);
    }

    @Test
    public void testKeyPressMovement(FxRobot robot) {
        // Simulate key presses and check the fighter jet's position
        robot.press(KeyCode.RIGHT).release(KeyCode.RIGHT);
        robot.sleep(100); // Wait for the animation to update

        FighterJet fighterJet = robot.lookup("#fighterJet").queryAs(FighterJet.class);
        assertNotNull(fighterJet);

        double initialX = fighterJet.getTranslateX();
        double initialY = fighterJet.getTranslateY();

        robot.press(KeyCode.RIGHT).release(KeyCode.RIGHT);
        robot.sleep(100); // Wait for the animation to update

        assertTrue(fighterJet.getTranslateX() > initialX);
        assertEquals(initialY, fighterJet.getTranslateY());
    }
}