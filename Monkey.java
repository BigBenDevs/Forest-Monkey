import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The monkey is the main character.  It must navigate the world and eat the bananas
 * while avoiding the snakes and hawks.  Getting eaten by a snake or hawk will end the
 * game.  Eat all 5 bananas and win the game.
 * 
 * @author (Benjamin Presley) 
 * @version (2.0)
 */
public class Monkey extends Actor
{
    /**
     * Act - do whatever the Monkey wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        isKeyDown();
        lookForBanana();
        endGame();
    }    

    /**
     * Move monkey using "Up","Down","Left","Right" keys
     */
    public void isKeyDown()
    {
        //Move up
        if(Greenfoot.isKeyDown("Up"))
            setLocation(getX(), getY()-2);
        //Move Down
        if(Greenfoot.isKeyDown("Down"))
            setLocation(getX(), getY()+2);
        //Move Left
        if(Greenfoot.isKeyDown("Left"))
            move(-2);
        //Move Right
        if(Greenfoot.isKeyDown("Right"))
            move(2);
    }

    /**
     * Collect the bananas when touching
     */
    public void lookForBanana()
    {
        Actor banana = getOneIntersectingObject(Banana.class);
        if(banana!=null)
        {
            World myWorld = getWorld();
            Forest forest = (Forest)myWorld;
            removeTouching(Banana.class);
            Greenfoot.playSound("introbeep.wav");
            Score score = forest.getScore();
            score.addScore(); 
        }
    }  
    
    public void endGame()
    {
        if (getWorld().getObjects(Banana.class).isEmpty())
        {
            Greenfoot.stop();
            Greenfoot.setWorld(new Winner());
        }
    }   
}
