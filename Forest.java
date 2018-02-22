import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Main world for Forest Monkey.  
 * 
 * @author (Benjamin Presley) 
 * @version (2.0)
 */
public class Forest extends World
{
    private int hawkSpawner;
    GreenfootSound backgroundMusic = new GreenfootSound("SunsetOnTheBeach.mp3");
    Score score = new Score();
    /**
     * Constructor for objects of class Forest.
     * 
     */
    public Forest()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        backgroundMusic.playLoop();
        backgroundMusic.setVolume(25);
        prepare();
    }
    
    public Score getScore()
    {
        return score;
    }
    
    private void runHawkSpawner()
    {
        hawkSpawner = (hawkSpawner+1)%200;
        if (hawkSpawner == 0) spawnHawk();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Monkey monkey = new Monkey();
        addObject(monkey,500,768);
        Snake snake = new Snake();
        addObject(snake,122,606);
        Snake snake2 = new Snake();
        addObject(snake2,933,441);
        Banana banana = new Banana();
        addObject(banana,143,170);
        Banana banana2 = new Banana();
        addObject(banana2,319,537);
        Banana banana3 = new Banana();
        addObject(banana3,879,262);
        Banana banana4 = new Banana();
        addObject(banana4,915,677);
        banana2.setLocation(374,433);
        Banana banana5 = new Banana();
        addObject(banana5,532,104);
        Banana banana6 = new Banana();
        addObject(banana6,585,184);
        addObject(score, 546, 37);
    }
    
    /**
    * Run the Hawk spawner
    */
    public void act()
    {
        runHawkSpawner();
        
    }    
    
    /**
    * Spawn Hawk at random times and speeds
    */
    private void spawnHawk()
    {
        addObject(new Hawk(), getWidth() - 1, Greenfoot.getRandomNumber(getHeight())); 
    }
}
