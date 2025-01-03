package com.example.task1;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;




import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class FighterJetTest {

    @Test
    public void testFighterJetCreation() {
        FighterJet fighterJet = new FighterJet();
        Group root = fighterJet;

        // Check if the fighter jet contains the body, rotor, and tail
        assertEquals(3, root.getChildren().size());

        Polygon body = (Polygon) root.getChildren().get(0);
        assertEquals(Color.BLUE, body.getFill());

        Polygon rotor = (Polygon) root.getChildren().get(1);
        assertEquals(Color.DARKGRAY, rotor.getFill());

        Polygon tail = (Polygon) root.getChildren().get(2);
        assertEquals(Color.DARKBLUE, tail.getFill());
    }

    @Test
    public void testFighterJetMovement() {
        FighterJet fighterJet = new FighterJet();
        fighterJet.setDeltaX(1);
        fighterJet.setDeltaY(1);

        double initialX = fighterJet.getTranslateX();
        double initialY = fighterJet.getTranslateY();

        fighterJet.move();

        assertEquals(initialX + 1, fighterJet.getTranslateX());
        assertEquals(initialY + 1, fighterJet.getTranslateY());
    }

    @Test
    public void testFighterJetBoundaryMovement() {
        FighterJet fighterJet = new FighterJet();
        fighterJet.setTranslateX(801); // Just outside the boundary
        fighterJet.setTranslateY(601); // Just outside the boundary

        fighterJet.move();

        assertEquals(0.0, fighterJet.getTranslateX());
        assertEquals(0.0, fighterJet.getTranslateY());
    }
}