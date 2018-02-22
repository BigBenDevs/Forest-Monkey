import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The snake is one of the enemies.  It will randomly move around.  If the snake
 * makes contact with the monkey, the game ends.
 * 
 * @author (Benjamin Presley) 
 * @version (2.0)
 */
public class Snake extends Actor
{
    public void act ()
    {
        turnAtEdge();
        move(2); //sets speed of movement.  Adjust int param to change speed.
        randomTurn();
        lookForMonkey();
    }

    /**
     * Look for the monkey actor.  If contact is made, end game.
     */    
    public void lookForMonkey()
    {
        if(isTouching(Monkey.class))
        {
            removeTouching(Monkey.class);
            Greenfoot.playSound("snakeBite.wav");
            Greenfoot.stop();
            Greenfoot.setWorld(new GameOver());
        }
    }
    
    /**
     * Selects a random number for turning
     */
    public void randomTurn()
    {
        if (Greenfoot.getRandomNumber(100)<10)
        {
            turn(Greenfoot.getRandomNumber(90)-45);
        } 
    }
    
    /**
     * Turns snake when at edge of world
     */
    public void turnAtEdge()
    {
        if ( isAtEdge() )
        {
            turn(45);
        } 
    }    
}
