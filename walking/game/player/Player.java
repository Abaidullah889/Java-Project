package walking.game.player;

import walking.game.util.Direction;

public class Player 
{
    private int score;
    protected Direction direction;



    public Player()
    {
        this.score =0;
        this.direction = Direction.UP;
    }
    public int getScore()
    {
        return this.score;
    }

    public walking.game.util.Direction getDirection()
    {
        return this.direction;
    }

    public void addToScore(int score)
    {
        this.score = score;
    }

    public void turn()
    {
        this.direction = this.direction.ordinal() == 3 ? Direction.UP : Direction.values()[this.direction.ordinal() + 1];
    }


}
