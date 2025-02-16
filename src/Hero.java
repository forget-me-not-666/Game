import java.awt.*;

public class Hero {
    final int JUMP_SPEED = -15;
    private int x = 100, y = 100;
    private int jumpSpeedFactor = 1;
    private int speedX = Const.SPEED;
    private int speedY = Const.SPEED;

    private boolean jumped = false, movingLeft = false, movingRight = false;

    private Direction direction = Direction.NON;
    private Rectangle rec = new Rectangle(x, y + Const.CHARACTER_HEIGHT - 10, Const.CHARACTER_WIDTH, 10);

    public void update() {
        x += speedX;
        y += speedY;
        rec.setBounds(x, y + Const.CHARACTER_HEIGHT - 10, Const.CHARACTER_WIDTH, 10);
        collision();
    }

    private void collision() {
        if (rec.contains(Main.floor)) {
            y = Main.floor.y - Const.CHARACTER_HEIGHT;
        }
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

    public void jump() {
        if (!jumped ) {
            System.out.println(JUMP_SPEED * jumpSpeedFactor);
            speedY = JUMP_SPEED * jumpSpeedFactor;
            jumped = true;
        }
    }

    public void stopRight(){
        movingRight = false;
        stop();
    }

    public void stopLeft(){
        movingLeft = false;
        stop();
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

    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }
}
