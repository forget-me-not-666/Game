import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

public class Main {
    public static Hero character = new Hero();
    static Floor floor = new Floor();


    private static int index = 0;

    public static void main(String[] args) {
        Screen screen = new Screen();
        Panel panel = new Panel();
        Thread thread = new Thread(panel);
        thread.start();

        screen.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if (e.getKeyCode() == KeyEvent.VK_D) {
//                    character.moveRight();
//                }
//                if (e.getKeyCode() == KeyEvent.VK_A) {
//                    character.moveLeft();
//                }
//                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
//                    character.setMovingLeft(false);
//                    character.setMovingRight(false);
//                    character.jump();
//                }
//
//                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
//                    System.exit(0);
//                }
//            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ESCAPE -> System.exit(0);
                    case KeyEvent.VK_SPACE -> {
                        character.setMovingLeft(false);
                        character.setMovingRight(false);
                        character.jump();
                    }
                    case KeyEvent.VK_D -> character.moveRight();
                    case KeyEvent.VK_A -> character.moveLeft();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_D, KeyEvent.VK_A -> character.stop();
                    case KeyEvent.VK_SPACE -> {
                        character.stop();
                        character.setMovingLeft(false);
                        character.setMovingRight(false);
                    }
                }
            }
        });

        screen.add(panel);

//      screen.addKeyListener(panel);


        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}