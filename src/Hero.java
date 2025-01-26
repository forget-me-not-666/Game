import java.awt.*;

public class Hero {
    private int x = 100, y = 100;
    private int speedX;
    private int speedY;
    private Direction direction = Direction.NON;
    private Rectangle rec = new Rectangle(x, y, 100, 50);

    public void update() {
        x += speedX;
        y += speedY;
        rec.setBounds(x, y, 10, 50);
    }

    public void moveRight() {
        direction = Direction.RIGHT;
        speedX = Const.SPEED;
    }

    public void moveLeft() {
        direction = Direction.LEFT;
        speedY = Const.SPEED;
    }

    public void stop() {
        direction = Direction.NON;
        speedX = 0;
        speedY = 0;
    }

    public int getSpeedX() {
        return speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle getRec() {
        return rec;
    }
}
