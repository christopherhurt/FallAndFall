package main;

import java.awt.event.KeyEvent;
import java.util.List;

public class FallingBro extends AnimatedGameObject 
{
    private static final float SPEED = 0.0002f;
    private static final float SIZE = 0.05f;
    private boolean initialAnimation;
    
    public FallingBro(
        float x,
        float y,
        float vX,
        float vY,
        float aX,
        float aY,
        String id,
        Animation animation) 
    {
        super(x, y, vX, vY, aX, aY, SIZE, 2 * SIZE, id, animation);
        initialAnimation = true;
    }

    @Override
    public void update()
    {
        if (initialAnimation)
        {
            if (getX() >= 0 && getY() >= 0)
            {
                initialAnimation = false;
            }
            return;
        }
        
        if (leftBound() && getVelX() < 0)
        {
            setX(0);
            setVelX(0);
        }
        if (rightBound() && getVelX() > 0)
        {
            setX(1 - getWidth());
            setVelX(0);
        }
        if (topBound() && getVelY() < 0)
        {
            setY(0);
            setVelY(0);
        }
        if (bottomBound() && getVelY() > 0)
        {
            setY(1 - getHeight());
            setVelY(0);
        }
        
        List<GameObject> objs = Game.getObjectList("game");
        for (GameObject obj : objs)
        {
            if (obj != this && obj.getClass() != Background.class && !obj.getBounds().intersection(this.getBounds()).isEmpty())
            {
                Game.setPaused(true);
            }
        }
        
        float sumX = 0;
        if (Input.isKeyDown(KeyEvent.VK_LEFT) && !leftBound())
        {
            sumX -= SPEED;
        }
        if (Input.isKeyDown(KeyEvent.VK_RIGHT) && !rightBound())
        {
            sumX += SPEED;
        }
        
        float sumY = 0;
        if (Input.isKeyDown(KeyEvent.VK_UP) && !topBound())
        {
            sumY -= SPEED;
        }
        if (Input.isKeyDown(KeyEvent.VK_DOWN) && !bottomBound())
        {
            sumY += SPEED;
        }
        
        setAccX(sumX);
        setAccY(sumY);
    }
    
    private boolean leftBound()
    {
        return getX() <= 0;
    }
    
    private boolean rightBound()
    {
        return getX() >= 1 - getWidth();
    }
    
    private boolean topBound()
    {
        return getY() <= 0;
    }
    
    private boolean bottomBound()
    {
        return getY() >= 1 - getHeight();
    }
}
