package e5.ballgames;

import java.awt.*;

public class Ball {

    private Color color;
    private int x;
    private int y;
    private int radius;

    public Ball(Color color, int x, int y, int radius) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public void move(final int x, final int y) {
        this.x += x;
        this.y += y;
    }
}
