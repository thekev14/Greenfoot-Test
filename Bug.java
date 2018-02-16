import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Bug extends Others
{
    /**
     * Act - do whatever the Bug wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int i = 1;
    private int speed = 1;
    public Bug()
    {
        getImage().scale((int)(119*.5),(int)(155*.5));
    }
    public Bug(int speed)
    {
        getImage().scale((int)(119*.5),(int)(155*.5));
        if(this.speed < 4)
            this.speed +=speed;
    }
    public void act() 
    {
        animateSpider();
        move(speed);
        if(Math.random() < .1)
            turn((int)(Math.random()*30));
        if(getX() < 2 || getX() > getWorld().getWidth() -4)
            turn(180);
        if(getY() < 2 || getY() > getWorld().getHeight() -4)
            turn(180);  
    }    
    public void animateSpider()
    {
        if(i<10)
            setImage("spiders_0000_Layer-1_0"+i+".png");
        else
            setImage("spiders_0000_Layer-1_"+i+".png");
        getImage().rotate(90);
        getImage().scale((int)(119*.5),(int)(155*.5));
        i++;
        if(i==20)
            i=1;
    }
    public int getSpeed()
    {
        return this.speed;
    }
    public void addSpeed(int speed)
    {
        this.speed += speed;
    }
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
}
