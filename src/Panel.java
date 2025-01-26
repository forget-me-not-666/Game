import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Panel extends JPanel implements Runnable {
    private BufferedImage imageH;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (imageH != null)
            g.drawImage(imageH, Main.character.getX(), Main.character.getY(), null);
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

                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
