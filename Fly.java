import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Fly here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fly extends Actor
{   
    MyWorld w = (MyWorld)getWorld();
    private boolean changeFly = true;
    private boolean delayFire = true;
    private int i = 0;
    private boolean rapidFire = false;
    private int bullets = 60;
    /**
     * Act - do whatever the Fly wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   
        fly();
        fire();
        eat();
        die();
    }
    public void fly()
    {
        if(Greenfoot.isKeyDown("right"))    
            turn(5);
        if(Greenfoot.isKeyDown("left"))
            turn(-5);
        if(Greenfoot.isKeyDown("up"))    
            move(5);
    }
    public void setRapidFire()
    {
        rapidFire = true;
    }
    public void fire()
    {
        if(!rapidFire)
        {
            if(Greenfoot.isKeyDown("space") && delayFire)    
            {
                Laser l = new Laser();
                Greenfoot.playSound("laser.wav");
                getWorld().addObject(l, getX(), getY()); 
                l.setRotation(getRotation());
                delayFire = !delayFire;
            }
            else if(Greenfoot.isKeyDown("space") && !delayFire)
            {
                if(i>10)
                {
                    delayFire = !delayFire;
                    i=0;
                }
            }
            else
                i++;
        }
        else
        {
            if(Greenfoot.isKeyDown("space"))    
            {
                Laser l = new Laser();
                Greenfoot.playSound("laser.wav");
                getWorld().addObject(l, getX(), getY()); 
                l.setRotation(getRotation());
            }
            bullets--;
            if(bullets==0)
            {
                rapidFire = false;
                bullets = 60;
            }
        }
    }
    public void move(int x)
    {
        if(getX() <= 0)
        {
            setLocation(getWorld().getWidth(), getY());
        }
        else if(getX() >= getWorld().getWidth()-1)
        {
            setLocation(0, getY());
        }
        else if(getY() <= 0)
        {
            setLocation(getX(),getWorld().getHeight());
        }
        else if(getY() >= getWorld().getHeight()-1)
        {
            setLocation(getX(), 0);
        }
        super.move(x);
        if(changeFly)
        {
            changeFly = !changeFly;
            setImage("fly2.png");
        }
        else
        {
            changeFly = !changeFly;
            setImage("fly.png"); 
        }
    }
    public void eat()
    {
        w = (MyWorld)getWorld();
        List <Food> ant = getObjectsInRange(30, Food.class);
        if(ant.size() > 0)
        {
            Greenfoot.playSound("bite.wav");
            w.getScore().addScore();
            w.removeObject(ant.remove(0));
        }
        powerUp();
    }
    public void die()
    {
        w = (MyWorld)getWorld();
        List <Bug> bug = getObjectsInRange(30, Bug.class);
        if(bug.size() > 0)
        {
            Greenfoot.playSound("squish.wav");
            w.getLives().die();
            w.removeObject(this);
            w.respawn();
        }
    }
    public void powerUp()
    {
        w = (MyWorld)getWorld();
        List <PowerUp> p = getObjectsInRange(20, PowerUp.class);
        if(p.size() > 0)
        {
            Greenfoot.playSound("win.wav");
            p.get(0).specialPower();
            w.removeObject(p.remove(0));
        }
    }

}
