import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Food here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Food extends Others
{
    /**
     * Act - do whatever the Food wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        move(3);
        if(Math.random() < .1)
            turn((int)Math.random()*90-45);
        if(getX() < 2 || getX() > getWorld().getWidth() -2)
            turn(180);
        if(getY() < 2 || getY() > getWorld().getHeight() -2)
            turn(180);    
        
    }    
}
