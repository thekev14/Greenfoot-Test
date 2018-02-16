import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BadBug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BadBug extends Bug
{
    public BadBug()
    {
        
    }
    public BadBug(int speed)
    {
        super(speed);
    }
    public void act() 
    {
        super.act(); 
        getImage().scale(119,155);
        //move(super.getSpeed());
        Fly fly = new Fly();
        if(getObjectsInRange(300, Fly.class).size() > 0)
            fly = (Fly)(getObjectsInRange(300, Fly.class)).get(0);
        else
            fly = null;
        if(fly != null)
            turnTowards(fly.getX(), fly.getY());      
    }    
}
