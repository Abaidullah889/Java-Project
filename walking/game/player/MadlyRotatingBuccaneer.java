package walking.game.player;

import walking.game.util.Direction;

public class MadlyRotatingBuccaneer extends Player
{
    private int turnCount;

    public MadlyRotatingBuccaneer()
    {
        super();
        turnCount = 0;
    }

    @Override
    public void turn()
    {
        switch (turnCount % 4) 
        {
            case 0:
                break;
            case 1:
                this.direction = this.direction.ordinal() == 3 ? Direction.UP : Direction.values()[this.direction.ordinal() + 1];
                break;
            case 2:
                this.direction = Direction.values()[(this.direction.ordinal() + 2) % 4];
                break;
            case 3:
                this.direction = this.direction.ordinal() == 3 ? Direction.UP : Direction.values()[this.direction.ordinal() + 1];
                break;
        }

        turnCount++;
    }

}
