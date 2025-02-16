import java.awt.*;

public class Hero {
    final int JUMP_SPEED = -10;
    private int x = 100, y = 100;
    private int jumpSpeedFactor = 20;
    private int speedX;
    private int speedY = Const.SPEED;

    private boolean jumped = false, movingLeft = false, movingRight = false;

    private Direction direction = Direction.NON;
    private Rectangle floor = new Rectangle(x, y + Const.CHARACTER_HEIGHT-20, Const.CHARACTER_WIDTH, 10);
    private Rectangle first = new Rectangle(110, 194, Const.PLATFORM_WIDTH, Const.PLATFORM_HEIGHT);

    public void update() {
        x += speedX;
        y += speedY;
        floor.setBounds(x, y + Const.CHARACTER_HEIGHT-20, Const.CHARACTER_WIDTH, 10);
        first.setBounds(0, 794, 124, 20);
        collision();
    }

    private void collision() {
        if (floor.intersects(Main.floor)) {
            y = Main.floor.y - Const.CHARACTER_HEIGHT;
            floor.setBounds(x, y + Const.CHARACTER_HEIGHT-20, Const.CHARACTER_WIDTH, 10);
        }

    }

    public void moveRight() {
        direction = Direction.RIGHT;
        speedX = Const.SPEED;
    }

    public void moveLeft() {
        direction = Direction.LEFT;
        speedX = -Const.SPEED;
    }

    public void stop() {
        direction = Direction.NON;
        speedX = 0;
        speedY = 0;
    }

    public void jump() {
        if (!jumped) {
            y -= jumpSpeedFactor;
            jumped = true;
        }
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle getRec() {
        return floor;
    }

    public Rectangle getFirst() {
        return first;
    }

    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }
}
