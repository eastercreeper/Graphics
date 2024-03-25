package rocket;

import javax.swing.*;
import java.awt.*;

public class RocketRonen extends JPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.setSize(1000, 800);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new RocketRonen());
        frame.setVisible(true);

    }
    public void paintComponent(Graphics g) {
        Rocket rocket = new Rocket(100,100,100,100);
        rocket.drawRocket(g);
    }
}
