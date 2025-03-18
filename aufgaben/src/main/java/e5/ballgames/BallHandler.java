package e5.ballgames;

import java.awt.*;
import java.util.Random;

public class BallHandler {

    private int screenY;
    private int screenX;

    private Ball ball;
    private Random random = new Random();

    public BallHandler(final int screenX, final int screenY) {
        this.screenX = screenX;
        this.screenY = screenY;
        this.ball = new Ball(randomColor(), randomNumber(screenX,0), randomNumber(screenY,0), randomNumber(50,20));
    }

    private Color randomColor() {
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    private int randomNumber(final int max, final int min) {
        return random.nextInt((max - min) + 1) + min;
    }

    private void animateGravity() {
        double velocityY = 0;
        double gravity = 0.5;
        double yPosition = ball.getY();

        while (yPosition < screenY - 5) {
            velocityY += gravity;
            yPosition += velocityY;

            ball.move(0, (int) velocityY);

            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
