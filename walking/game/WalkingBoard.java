package walking.game;

import walking.game.util.Direction;

public class WalkingBoard
{
    private int[][] tiles;
    private int x;
    private int y;
    public static final int BASE_TILE_SCORE = 3;


    public WalkingBoard(int size)
    {
        this.tiles= new int[size][size];
        this.x = 0;
        this.y = 0;

        for(int i=0;i<tiles.length;i++)
        {
            for(int j=0;j<tiles[i].length;j++)
            {
                tiles[i][j] = BASE_TILE_SCORE;
            }
        }
    }

    public WalkingBoard(int[][] tiles)
    {
        this.tiles = new int[tiles.length][];
        this.x = 0;
        this.y=0;

        for(int i=0;i<tiles.length;i++)
        {
            this.tiles[i] = new int[tiles[i].length];
            for(int j=0;j<tiles[i].length;j++)
            {
                if(tiles[i][j] > BASE_TILE_SCORE)
                {
                    this.tiles[i][j] = tiles[i][j];
                }
                else
                {
                    this.tiles[i][j] = BASE_TILE_SCORE;
                }
            }
        }
    }

    public int[][] getTiles() 
    {
        
        int[][] copy = new int[tiles.length][tiles.length];
        for (int i = 0; i < tiles.length; i++) 
        {
            for(int j=0;j<tiles[i].length;j++)
            {
                copy[i][j] = this.tiles[i][j];
            }
        }

        return copy;
    }

    public int[] getPosition()
    {
        return new int[]{this.x,this.y};
    }

    public boolean isValidPosition(int x,int y)
    {
        return (x >=0 && x < this.tiles.length && y >= 0 && y < this.tiles[x].length);
    }

    public int getTile(int x,int y)
    {
        if(isValidPosition(x, y))
        {
            return this.tiles[x][y];

        }
        
        throw new IllegalArgumentException("the given values are not valid");
        
    }

    public static int getXStep(walking.game.util.Direction direction)
    {
        if(direction == Direction.RIGHT)
        {
            return 1;
        }
        else if(direction == Direction.LEFT)
        {
            return -1;
        }

        return 0;
    }

    public static int getYStep(walking.game.util.Direction direction)
    {
        if(direction == Direction.UP)
        {
            return -1;
        }
        else if(direction == Direction.DOWN)
        {
            return 1;
        }
        return 0;
    }

    public int moveAndSet(walking.game.util.Direction direction , int value)
    {

        int newX = this.x + (getYStep(direction));
        int newY = this.y + (getXStep(direction));
        

        if(!isValidPosition(newX, newY))
        {
            return 0;
        }

        int oldValue = getTile(newX, newY);
        this.tiles[newX][newY] = value;
        this.x = newX;
        this.y = newY;

        return oldValue;
    }


}