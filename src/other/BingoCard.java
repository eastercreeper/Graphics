package other;

public class BingoCard {
    String [][] card = new String[6][5];
    public BingoCard() {

    }

    public void displayCard() {
        for(int rows = 0; rows < 6; rows++) {
            for(int cols = 0; cols < 5; cols++) {
                card[rows][cols] = (int) (Math.random()*5) + " ";
            }
        }
        card[0][0] = "b ";
        card[0][1] = "i ";
        card[0][2] = "n ";
        card[0][3] = "g ";
        card[0][4] = "o ";

        for(int rows = 0; rows < 6; rows++) {
            for(int cols = 0; cols < 5; cols++) {
               System.out.print(card[rows][cols]);
                System.out.print(" ");

            }
            System.out.println(" ");
        }
    }
}
