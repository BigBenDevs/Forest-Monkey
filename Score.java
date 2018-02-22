import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class Score provides a visual score count of bananas eaten.  Player needs to eat
 * 5 bananas to win.
 * 
 * @author (Benjamin Presley) 
 * @version (2.0)
 */
public class Score extends Actor
{
    int score=0; //Set starting score to 0
    /**
     * Create a green scoreboard with transparent background
     */
    public void act() 
    {
        setImage(new GreenfootImage("Bananas Eaten =  " + score, 32, Color.GREEN, new Color (0,0,0,0)));
    }    
     
    public void addScore()
    {
        score++;
    }   
}
