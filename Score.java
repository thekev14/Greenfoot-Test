import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Labels
{
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int score = 0;
    private static int highScore = 0;
    MyWorld w;
    public void act() 
    {
        w = (MyWorld)getWorld();
        setImage(new GreenfootImage("Score: " + this.score + "   Level: "+ w.getLevel()+"   High Score: "+highScore, 30, Color.BLACK, new Color(0,0,0,0)));
    }
    public void addScore()
    {
        this.score++;
    }
    public int getScore()
    {
        return score;
    }
    public void resetScore()
    {
        if(score > highScore)
            highScore = score;
        score = 0;
    }
}
