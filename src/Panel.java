import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Panel extends JPanel implements Runnable {
    private BufferedImage hero;

    public Panel() {
        try {
            hero = ImageIO.read(new File("image/cat.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
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

                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
