package walking.game;

import walking.game.player.MadlyRotatingBuccaneer;
import walking.game.player.*;

public class WalkingBoardWithPlayers extends WalkingBoard 
{

    private Player[] players;
    private int round;
    public static final int SCORE_EACH_STEP = 13;


    public WalkingBoardWithPlayers(int[][] board,int playerCount)
    {
        super(board);
        round =0;
        initPlayers(playerCount);
    }
    public WalkingBoardWithPlayers(int size,int playerCount)
    {
        super(size);
        round =0;
        initPlayers(playerCount);
        
    }
    private void initPlayers(int playerCount)
    {
        if(playerCount < 2) throw new IllegalArgumentException("Number of players must be at least 2");
        
        players = new Player[playerCount];
        players[0] = new MadlyRotatingBuccaneer();

        for(int i=1;i<playerCount;i++)
        {
            players[i] = new Player();
        }
    }
    public int[] walk(int...stepCounts)
    {

        // if(stepCounts.length != players.length)
        // {
        //     throw new IllegalArgumentException("length of stepCounts is not equal to the length of players");
        // }

        int scores[] = new int[players.length];
        


        for(int i=0;i<stepCounts.length;i++)
        {
            for(int j=0;j<players.length;j++)
            {
                int score = 0;
                Player p = players[j];
                p.turn();
                
                for(int k=0;k<stepCounts[i];k++)
                {
                    int totalSteps = Math.min(k, SCORE_EACH_STEP);
                    moveAndSet(p.getDirection(), totalSteps);
                    score += getTile(getPosition()[0], getPosition()[1]);
                    
                }
                
                players[j].addToScore(score);
                scores[j] += score;
            }
        }




        // previous Implementation


        // for(int currentPlayer =0 ;currentPlayer < players.length; currentPlayer++)
        // {
        //     int score =players[currentPlayer].getScore();

        //     for(int i=0;i<totalSteps;i++)
        //     {
        //         players[currentPlayer].turn();
        //         moveAndSet(players[currentPlayer].getDirection(),i);
        //         score = getTile(getPosition()[0], getPosition()[1]);
        //         players[currentPlayer].addToScore(score);
        //         scores[currentPlayer] += score;

        //     }
            
        // }

        round++;
        return scores;
    }
    
}
