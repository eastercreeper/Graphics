import javax.swing.*;

public class Interest {
    static double p;
    static double a;
    static double r;
    static double t;
    static double n;
    public static void main(String[] args) throws Exception {
        p = Double.parseDouble(JOptionPane.showInputDialog("Please enter an amount owed"));
        r = Double.parseDouble(JOptionPane.showInputDialog("Enter the rate of interest"));
        n = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount of times paying a year"));
        t = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount of years")) + 1;

        for (int i = 0; i <t; i++) {
            System.out.println("Amount owed on year " + i +" " + p*(Math.pow((1+r/n),n*i)));
        }

    }
}


