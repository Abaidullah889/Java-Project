package walking.game;

import walking.game.WalkingBoard;
import walking.game.util.Direction;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class WalkingBoardTest 
{

    @Test
    public void testSimpleInit() 
    {
        WalkingBoard testBoard = new WalkingBoard(3);
        assertEquals(3, testBoard.getTiles().length);
        assertEquals(3, testBoard.getTiles()[0].length);
    }

    @Test
    public void testSimpleInit_getTiles() 
    {
        
        WalkingBoard testBoard = new WalkingBoard(3);
        int[][] tiles = testBoard.getTiles();

        for (int i = 0; i < tiles.length; i++) 
        {
            for (int j = 0; j < tiles[i].length; j++) 
            {
                assertEquals(WalkingBoard.BASE_TILE_SCORE, tiles[i][j]);
            }
        }
    }


    @Test
    public void testSimpleInit_edges() 
    {
        WalkingBoard testBoard = new WalkingBoard(3);
        int[][] tiles = testBoard.getTiles();
        assertEquals(WalkingBoard.BASE_TILE_SCORE, tiles[0][0]);
        assertEquals(WalkingBoard.BASE_TILE_SCORE, tiles[tiles.length - 1][tiles.length - 1]);
    }


    @ParameterizedTest
    //@ValueSource(ints = {0, 1, 2})
    @CsvSource({ "0,1,3","1,2,6","2,3,10" })
    public void testCustomInit(int x, int y, int expected)
    {
        int[][] customTiles = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9,10}};
        WalkingBoard testBoard = new WalkingBoard(customTiles);
        assertEquals(expected, testBoard.getTile(x, y));
    }


    @Test
    public void testCustomInit_modification() 
    {
        int[][] customTiles = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        WalkingBoard board = new WalkingBoard(customTiles);
        customTiles[1][1] = 10;
        assertEquals(5, board.getTiles()[1][1]);
    }

    @Test
    public void testCustomInit_TilesModification() 
    {
        int[][] customTiles = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        WalkingBoard board = new WalkingBoard(customTiles);
        int[][] copy = board.getTiles();
        copy[2][2] = 20;
        assertEquals(9, board.getTiles()[2][2]);
    }

    @Test
    public void testMoves() 
    {
        WalkingBoard board = new WalkingBoard(8);

        board.moveAndSet(Direction.RIGHT, 0);
        assertEquals(WalkingBoard.BASE_TILE_SCORE, board.getTiles()[0][0]);
        assertEquals(0, board.getTiles()[0][1]);



        board.moveAndSet(Direction.DOWN, 1);
        assertEquals(0 ,board.getTiles()[0][1]);
        assertEquals(1, board.getTiles()[1][1]);

        board.moveAndSet(Direction.UP, 2);
        assertEquals(1, board.getTiles()[1][1]);
        assertEquals(2, board.getTiles()[0][1]);

        assertEquals(0, board.getPosition()[0]);
        assertEquals(1, board.getPosition()[1]);

        board.moveAndSet(Direction.LEFT, 3);
        assertEquals(2, board.getTiles()[0][1]);
        assertEquals(3, board.getTiles()[0][0]);

        board.moveAndSet(Direction.UP, 4);
        assertEquals(3, board.getTiles()[0][0]);
        
    }
}
