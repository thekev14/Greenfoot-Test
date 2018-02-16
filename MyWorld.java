import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Score score = new Score();
    Lives lives = new Lives();
    private int frames = 0;
    private PowerUp p;
    private int level = 1;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {   
        super(900, 600, 1); 
        //resetGame();
        setPaintOrder(Labels.class, Fly.class,Laser.class, Bug.class, PowerUp.class);
        prepare();
        p = new PowerUp();
        //String x = Greenfoot.ask("enter number");
    }
    public void act()
    {
        List<Bug> bugs = getObjects(Bug.class);
        List<Food> ants = getObjects(Food.class);
        if(frames == 300 && bugs.size()>0)
        {
            addObject(new BadBug(bugs.get(0).getSpeed()), bugs.get(0).getX(), bugs.get(0).getY());
            removeObject(bugs.get(0));
            frames = 0;
            newPowerUp();
        }
        if(frames==150 && p != null)
            removeObject(p);
        if(ants.size()==0)
        {
            nextLevel();
            frames = 0;
        }
        frames++;
    }
    public void resetGame()
    {
        lives.resetLives();
        score.resetScore();
        level = 1;
        
        prepare();
    }
    public Score getScore()
    {
        return score;
    }
    public Lives getLives()
    {
        return lives;
    }
    public void respawn()
    {
        if(lives.getLives() > 0)
        {
            boolean openSpace = true;
            Fly fly = new Fly();
            List <Bug> bugs = getObjects(Bug.class);
            for(int i = 0;i < bugs.size();i++)
            {
                if(bugs.get(i).getX() > 25 && bugs.get(i).getX() < 225 && bugs.get(i).getY() > 0 && bugs.get(i).getY() < 200)
                    openSpace = false;
            }
            if(openSpace)
                addObject(fly, 125, 100);
        }
        if(lives.getLives() == 0)
        {
            //Greenfoot.stop();
            addObject(new Start(),getWidth()/2, getHeight()/2);
        }
    }
    private void newPowerUp()
    {
        p = new PowerUp();
        addObject(p, (int)(Math.random()*getWidth()), (int)(Math.random()*getHeight()));
    }
    public int getLevel()
    {
        return level;
    }
    public void nextLevel()
    {
        Greenfoot.delay(60);
        level++;
        frames = 0;
        setLevel();
    }
    public void setLevel()
    {
        for(int i = 0; i<level*5; i++) addObject(new Food(),(int)(Math.random()*getWidth()), (int)(Math.random()*getHeight())); 
        for(int i = 0; i<level; i++) addObject(new Bug(),(int)(Math.random()*getWidth()), (int)(Math.random()*getHeight())); 
    }
    private void prepare()
    {   
        List <Actor> actors = getObjects(Actor.class);
        for(Actor a:actors)
            removeObject(a);
        getBackground().scale(1100, 900);        
        Fly fly = new Fly();
        addObject(fly,90,90);
        Lives lives = new Lives();
        addObject(lives,100,20);
        Score score = new Score();
        addObject(score,650,20);
        setLevel();
    }
}
