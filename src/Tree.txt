import javax.swing.*;
import java.awt.*;
import java.util.stream.IntStream;

public class Tree extends JPanel {

    private int x;
    private int y;

    public Tree(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void drawTree(Graphics g) {
        g.setColor(new Color(72, 35, 3));
        g.fillRect(x + 5,y,20,30);
        int[] pointsX = {x-50,x+15,x+80};
        int[] pointsY = {y,y-50,y};
        g.setColor(new Color(115, 255, 0));
        g.fillPolygon(pointsX,pointsY,3);
        IntStream.range(0, pointsY.length).forEach(i -> pointsY[i] = pointsY[i] - 40);
        g.fillPolygon(pointsX,pointsY,3);
        IntStream.range(0, pointsY.length).forEach(i -> pointsY[i] = pointsY[i] - 40);
        g.fillPolygon(pointsX,pointsY,3);
    }
}
