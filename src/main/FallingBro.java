package main;

import java.awt.event.KeyEvent;

public class FallingBro extends AnimatedGameObject 
{
    private static final float SPEED = 0.0002f;
    
    public FallingBro(
        float x,
        float y,
        float vX,
        float vY,
        float aX,
        float aY,
        float w,
        float h,
        String id,
        Animation animation) 
    {
        super(x, y, vX, vY, aX, aY, w, h, id, animation);
    }

    @Override
    public void update()
    {
        if (leftBound() && getVelX() < 0)
        {
            setVelX(0);
            setAccX(0);
        }
        if (rightBound() && getVelX() > 0)
        {
            setVelX(0);
            setAccX(0);
        }
        
        if (Input.isKeyPressed(KeyEvent.VK_LEFT) && !leftBound())
        {
            setAccX(-SPEED);
        }
        if (Input.isKeyReleased(KeyEvent.VK_LEFT))
        {
            setAccX(0);
        }
        if (Input.isKeyPressed(KeyEvent.VK_RIGHT) && !rightBound())
        {
            setAccX(SPEED);
        }
        if (Input.isKeyReleased(KeyEvent.VK_RIGHT))
        {
            setAccX(0);
        }
        if (Input.isKeyPressed(KeyEvent.VK_UP))
        {
            setAccY(-SPEED);
        }
        if (Input.isKeyReleased(KeyEvent.VK_UP))
        {
            setAccY(0);
        }
        if (Input.isKeyPressed(KeyEvent.VK_DOWN))
        {
            setAccY(SPEED);
        }
        if (Input.isKeyReleased(KeyEvent.VK_DOWN))
        {
            setAccY(0);
        }
    }
    
    private boolean leftBound()
    {
        return getX() <= .0001f;
    }
    
    private boolean rightBound()
    {
        return getX() >= 1 - getWidth() -.0001f;
    }
}
