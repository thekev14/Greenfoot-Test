import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Lives here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lives extends Labels
{
    /**
     * Act - do whatever the Lives wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int lives = 3;
    //private static boolean over = false;
    public void act() 
    {
        MyWorld w = (MyWorld)getWorld();
        w = (MyWorld)getWorld();
        List<Food> ants = getWorld().getObjects(Food.class);          
        if(lives > 0 )
            setImage(new GreenfootImage("Lives: " + this.lives, 30, Color.BLACK, new Color(0,0,0,0)));
        else 
        {
            setImage(new GreenfootImage("GAME OVER", 30, Color.BLACK, new Color(0,0,0,0)));
            //Greenfoot.playSound("dead.wav");           
        }
        if(w.getObjects(Fly.class).size() == 0 && w.getLives().getLives() > 0)
            w.respawn();
    }
    public void die()
    {
        this.lives--;
    }
    public int getLives()
    {
        return lives;
    }
    public void resetLives()
    {
        lives = 3;
        //over = false;
    }
   
}
