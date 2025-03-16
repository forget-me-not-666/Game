import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Panel extends JPanel implements Runnable {
    private final BufferedImage hero;
    private final Image background = new ImageIcon("image/background.png").getImage();
    private final Image end = new ImageIcon("image/end.png").getImage();
    private final Image star = new ImageIcon("image/star.png").getImage();
    static Rectangle[] platforms = new Rectangle[8];
    static Rectangle[] stars = new Rectangle[8];


    public Panel() {
        try {
            hero = ImageIO.read(new File("image/dinya_1.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        platforms[0] = new Rectangle(-68, 795, Const.PLATFORM_WIDTH, Const.PLATFORM_HEIGHT);
        platforms[1] = new Rectangle(481, 643, Const.PLATFORM_WIDTH, Const.PLATFORM_HEIGHT);
        platforms[2] = new Rectangle(686, 882, Const.PLATFORM_WIDTH, Const.PLATFORM_HEIGHT);
        platforms[3] = new Rectangle(885, 785, Const.PLATFORM_WIDTH, Const.PLATFORM_HEIGHT);
        platforms[4] = new Rectangle(1091, 785, Const.PLATFORM_WIDTH, Const.PLATFORM_HEIGHT);
        platforms[5] = new Rectangle(1296, 642, Const.PLATFORM_WIDTH, Const.PLATFORM_HEIGHT);
        platforms[6] = new Rectangle(1500, 747, Const.PLATFORM_WIDTH, Const.PLATFORM_HEIGHT);
        platforms[7] = new Rectangle(1687, 896, Const.PLATFORM_WIDTH, Const.PLATFORM_HEIGHT);

        stars[0] = new Rectangle(0, 0, 0, 0);
        for (int i = 1; i < stars.length; i++) {
            stars[i] = new Rectangle(platforms[i].x + 48, platforms[i].y - Const.STAR, Const.STAR, Const.STAR);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background, 0, 0, null);
        if (stars[7].isEmpty())
            g.drawImage(end, 0, 0, null);
        for (int i = 1; i < stars.length; i++) {
            g.drawImage(star, stars[i].x, stars[i].y, null);
        }
        for (int i = 0; i < platforms.length; i++) {
            g.drawRect(i == 0 ? -68 : platforms[i].x, platforms[i].y, platforms[i].width, platforms[i].height);
        }
        for (int i = 1; i < stars.length; i++) {
            g.drawRect(stars[i].x, stars[i].y, stars[i].width, stars[i].height);
        }
        if (hero != null)
            g.drawImage(hero, Main.character.getX(), Main.character.getY(), null);
        g.drawRect(Main.character.getRec().x, Main.character.getRec().y, Main.character.getRec().width, Main.character.getRec().height);
        g.drawRect(Main.floor.x, Main.floor.y, Main.floor.width, Main.floor.height);
    }

    private void update() {
        Main.character.update();
    }

    @Override
    public void run() {
        while (true) {
            try {
                update();
                repaint();

                Thread.sleep(25);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


