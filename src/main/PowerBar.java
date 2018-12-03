package main;

import java.awt.Color;
import java.util.Random;

public class PowerBar extends ColoredGameObject {

    private static final float x = .7f;
    private static final float y = .15f;
    private static final float vX = 0;
    private static final float vY = 0;
    private static final float aX = 0;
    private static final float aY = 0;
    private static final float h = .02f;
    private static final float POW_MULT = 0.024f;
    
    private int maxPow;
    private static int currPow;
    private int mult;
    private static boolean moving = true;
    
    public PowerBar(
        String id,
        Color color,
        int maxPow) 
    {
        super(x, y, vX, vY, aX, aY, 0, h, id, color);
        this.maxPow = maxPow;
        Random rand = new Random();
        currPow = rand.nextInt(maxPow + 1);
        setWidth(currPow * POW_MULT);
        mult = 1;
    }

    
    public static int stopPowerBar()
    {
        moving = false;
        return currPow;
    }
    
    @Override
    public void update()
    {
        if (moving)
        {
            if (currPow == maxPow)
            {
                mult = -1;
            }
            else if (currPow == 0)
            {
                mult = 1;
            }
            currPow += mult;
            setWidth(currPow * POW_MULT);
        }
    }
    
}
