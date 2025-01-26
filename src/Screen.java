import javax.swing.*;

public class Screen extends JFrame {
    public Screen() {
        setSize(Const.WINDOW_WIDTH, Const.WINDOW_HEIGHT);
        setLocation(500, 100);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
