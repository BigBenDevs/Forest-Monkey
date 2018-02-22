import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The hawk moves from right to left, hunting the Monkey.  If the hawk makes contact with the
 * monkey, the game is over.
 * 
 * @author (Benjamin Presley) 
 * @version (2.0)
 */
public class Hawk extends Actor
{
    /**
     * Act - do whatever the Hawk wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(Greenfoot.getRandomNumber(5)-6);
        lookForMonkey();
        removeHawk();
        
    }    
    
    /**
     * Check and see if the hawk is at the left edge of the world.  
     */
    public boolean atWorldEdge()
    {
        if(getX()==0)
        {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Remove hawk if it is at the edge of screen
     */
    public void removeHawk()
    {
        if (atWorldEdge()==true)
        {
            getWorld().removeObject(this);
        }
    }
    
    /**
     * If touching Monkey, end game
     */
        public void lookForMonkey()
    {
        if(isTouching(Monkey.class))
        {
            removeTouching(Monkey.class);
            Greenfoot.playSound("hawk.wav");
            Greenfoot.stop();
            Greenfoot.setWorld(new GameOver());
        }
    }   
}
