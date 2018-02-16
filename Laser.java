import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Laser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Laser extends Actor
{
    List<Bug> b;
    /**
     * Act - do whatever the Laser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Laser()
    {
        getImage().scale(10,10);
    }
    public void act() 
    {
        move(10);
        if(isAtEdge() || hitBug())
            getWorld().removeObject(this);
    }    
    public boolean hitBug()
    {
        b = getObjectsInRange(20, Bug.class);
        if(b.size()>0)
        {
            //play dead bug sound
            Greenfoot.playSound("deadbug.wav");
            if(b.get(0).getClass() == BadBug.class)
            {
                Bug b1 = new Bug(b.get(0).getSpeed());
                b1.turn(((int)Math.random()*360));
                //b1.addSpeed(2);    
                Bug b2 = new Bug(b.get(0).getSpeed());
                b2.turn(((int)Math.random()*360));
                //b2.addSpeed(2); 
                Bug b3 = new Bug(b.get(0).getSpeed());
                b3.turn(((int)Math.random()*360));
                //b3.addSpeed(2); 
                getWorld().addObject(b1,b.get(0).getX(),b.get(0).getY());
                getWorld().addObject(b2,b.get(0).getX(),b.get(0).getY());
                getWorld().addObject(b3,b.get(0).getX(),b.get(0).getY());
            }
            MyWorld w =(MyWorld)getWorld();
            w.getScore().addScore();
            getWorld().removeObject(b.get(0));
            return true;
        }
        return false;
    }
}
