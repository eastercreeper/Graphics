import javax.swing.*;
import java.awt.*;

public class HelloGraphics extends JPanel {

    public void paintComponent(Graphics g) {
        //background
        g.setColor(Color.BLACK);
        g.fillRect(0,0,600,600);

        g.setColor(Color.RED);
        g.fillOval(200,200,100,100);

        g.setColor(new Color(196,14,190));
        g.fillRect(100,100,30,30);

        g.drawLine(0,0,600,600);

        g.setColor(new Color(91, 7, 227));

        g.drawLine(0,300,600,300);

        g.setFont(new Font("LEMONMILK-Regular", Font.BOLD,50));
        g.drawString("Ronen hi",40,500);

        for(int i = 0; i < 3; i++) {
            g.drawOval(50 * i * 2,100,100,100);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ronen is tall");
        frame.setSize(600,600);
        frame.setLocation(50,0);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(new HelloGraphics());
        frame.setVisible(true);
    }
}
