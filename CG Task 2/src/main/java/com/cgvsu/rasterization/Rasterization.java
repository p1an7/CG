package com.cgvsu.rasterization;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

public class Rasterization {
    public Rasterization() {
    }

    public static void drawRectangle(GraphicsContext graphicsContext, int x, int y, int width, int height, Color color) {
        PixelWriter pixelWriter = graphicsContext.getPixelWriter();

        for(int row = y; row < y + height; ++row) {
            for(int col = x; col < x + width; ++col) {
                pixelWriter.setColor(col, row, color);
            }
        }
    }

    public static void drawEllipse(GraphicsContext graphicsContext, int centerX, int centerY, int a, int b, Color color) {
        PixelWriter pixelWriter = graphicsContext.getPixelWriter();

        int x = 0;
        int y = b;
        int a2 = a * a;
        int b2 = b * b;
        int p = (int) (b2 - (a2 * b) + (0.25 * a2));

        while (b2 * x <= a2 * y) {
            plotPoints(pixelWriter, centerX, centerY, x, y, color);
            if (p < 0) {
                x++;
                p += 2 * b2 * x + b2;
            } else {
                x++;
                y--;
                p += 2 * b2 * x - 2 * a2 * y + b2;
            }
        }

        p = (int) (b2 * (x + 0.5) * (x + 0.5) + a2 * (y - 1) * (y - 1) - a2 * b2);

        while (y >= 0) {
            plotPoints(pixelWriter, centerX, centerY, x, y, color);
            if (p > 0) {
                y--;
                p -= 2 * a2 * y + a2;
            } else {
                y--;
                x++;
                p += 2 * b2 * x - 2 * a2 * y - a2;
            }
        }
    }

    private static void plotPoints(PixelWriter pixelWriter, int centerX, int centerY, int x, int y, Color color) {
        pixelWriter.setColor(centerX + x, centerY + y, color);
        pixelWriter.setColor(centerX - x, centerY + y, color);
        pixelWriter.setColor(centerX + x, centerY - y, color);
        pixelWriter.setColor(centerX - x, centerY - y, color);
    }
}