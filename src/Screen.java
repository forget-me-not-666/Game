import javax.swing.*;

public class Screen extends JFrame {
    public Screen() {

        setSize(Const.WINDOW_WIDTH, Const.WINDOW_HEIGHT);
           setLocation(0, 0);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
