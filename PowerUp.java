import greenfoot.*;
import java.util.*;
/**
 * Write a description of class PowerUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerUp extends Actor
{
    // instance variables - replace the example below with your own
    private int type;
    private int frames=1;
    private Color c;
    public PowerUp()
    {
        type = (int)(Math.random()*4);
        spawnPowerUp();
    }
    public void spawnPowerUp()
    {
        //PowerUp pu = new PowerUp();
        switch(type)
        {
            case 0://freeze spiders
                setImage("powerup_0000_Layer-1_09.png");
            break;
            case 1://reset spider speed
                setImage("powerup_0000_Layer-1_02.png");
            break;
            case 2://rapid fire                
                setImage("powerup_0000_Layer-1_03.png");
            break;
            case 3://rapid spiders                
                setImage("powerup_0000_Layer-1_08.png");
            break;
        }
        getImage().scale(50,50);
    }
    public void specialPower()
    {
        List<Bug> spiders = getWorld().getObjects(Bug.class);
        List<Fly> fly = getWorld().getObjects(Fly.class);
        switch(type)
        {
            case 0://freeze spiders 
                for(Bug b:spiders)
                    b.setSpeed(0);
            break;
            case 1://reset spider speed
                for(Bug b:spiders)
                    b.setSpeed(2);
            break;
            case 2://rapid fire                
                fly.get(0).setRapidFire();
            break;
            case 3:
                for(Bug b:spiders)
                    b.setSpeed(6);
            break;
        }
    }
    

}
