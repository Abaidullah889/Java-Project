package walking.game;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;

import java.beans.Transient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WalkingBoardWithPlayersTest 
{


    @Test
    public void walk1()
    {
        WalkingBoardWithPlayers board = new WalkingBoardWithPlayers(3, 2);
        int[] scores = board.walk(2,3,1);
        int[] expectScore = new int[]{3+3+1+1+1+0,0+1+0+1+1+0};

        int[][] expected = { {3 ,0 ,1}
                            ,{3 ,3 ,0}
                            ,{0 ,0 ,1}};


        for(int i=0;i<expected.length;i++)
        {
            for(int j=0;j<expected[i].length;j++)
            {
                assertEquals(expected[i][j],board.getTile(i, j));
            }
        }
        assertArrayEquals(expectScore,scores);
        assertThrows(IllegalArgumentException.class ,()->board.getTile(7,7));

    }


    @Test
    public void walk2()
    {
        
        WalkingBoardWithPlayers board = new WalkingBoardWithPlayers(5, 3);
        int[] scores = board.walk(3, 4, 2);
        int[] expectedScore = new int[]{3+3+3+0+0+0+0+1,0+1+2+0+1+2+3+0+1,3+3+3+3+1+1};



        

        int[][] expected = 
        {{3, 0, 1, 2, 0}
        ,{3, 3, 3, 3, 0}
        ,{3, 3, 3, 3, 1}
        ,{3, 3, 3, 3, 2}
        ,{1, 0, 1, 0, 3}};
        
        for(int i=0;i<expected.length;i++)
        {
            for(int j=0;j<expected[i].length;j++)
            {
                assertEquals(expected[i][j],board.getTile(i, j));
            }
        }                  
                           
        assertArrayEquals(expectedScore,scores);

        //assertThrows(IllegalArgumentException.class ,()->board.getTile(8,8));

    }
    
}