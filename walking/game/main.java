package walking.game;
import java.io.Console;

import walking.game.WalkingBoardWithPlayers;
public class main {

    public static void main(String args[])
    {
        WalkingBoardWithPlayers board = new WalkingBoardWithPlayers(5, 3);
        print(board);
        int[] scores = board.walk(3, 4, 2);
         System.out.println();
         System.out.println();
         System.out.println("After");
         print(board);
         System.out.println();
         System.err.println(scores[0] + " " +scores[1] + " " + scores[2]) ;



         

    }

    public static void print(WalkingBoardWithPlayers board)
    {
        for(int i=0;i<board.getTiles().length;i++)
         {
            for(int j=0;j<board.getTiles()[i].length;j++)
            {
                System.out.print(board.getTile(i, j) + " ");
            }
            System.out.println();
         }
    }
    
}
