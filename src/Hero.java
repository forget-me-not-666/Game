import java.awt.*;


public class Hero {
    private int x = 5, y = 300;
    private int jumpSpeedFactor = 40;
    private int speedX;
    private int speedY = Const.SPEED;

    private boolean jumped = false;

    private Rectangle rec = new Rectangle(x + 80, y + Const.CHARACTER_HEIGHT - 10, 70, 10);

    public void update() {
        x += speedX;
        y += speedY;
        if(jumped && speedY < Const.SPEED) {
            speedY += 1;
        }
        rec.setBounds(x + 80, y + Const.CHARACTER_HEIGHT - 10, 70, 10);
        collision();
    }

    private void collision() {
        if (rec.intersects(Main.floor)) {
            y = Main.floor.y - Const.CHARACTER_HEIGHT;
            rec.setBounds(x + 80, y + Const.CHARACTER_HEIGHT - 10, 70, 10);
            jumped = false;
            speedY = Const.SPEED;
        }
        for(Rectangle plat : Panel.platforms){
            if (rec.intersects(plat) && speedY >= 0) {
                y = plat.y - Const.CHARACTER_HEIGHT;
                rec.setBounds(x + 80, y + Const.CHARACTER_HEIGHT - 10, 70, 10);
                jumped = false;
                speedY = Const.SPEED;
            }
        }
    }

    public void moveRight() {
        speedX = Const.SPEED;
    }

    public void moveLeft() {
        speedX = -Const.SPEED;
    }

    public void stop() {
        speedX = 0;
    }

    public void jump() {
        if (!jumped) {
            speedY -= jumpSpeedFactor;
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
        return rec;
    }

}
