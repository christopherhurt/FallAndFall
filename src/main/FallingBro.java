package main;

import java.awt.event.KeyEvent;

public class FallingBro extends AnimatedGameObject 
{
    private static final float SPEED = 0.0002f;
    private static final float SIZE = 0.05f;
    
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
    }

    @Override
    public void update()
    {
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
        if (Input.isKeyPressed(KeyEvent.VK_UP) && !topBound())
        {
            setAccY(-SPEED);
        }
        if (Input.isKeyReleased(KeyEvent.VK_UP))
        {
            setAccY(0);
        }
        if (Input.isKeyPressed(KeyEvent.VK_DOWN) && !bottomBound())
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
