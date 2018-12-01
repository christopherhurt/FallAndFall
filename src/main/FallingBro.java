package main;

import java.awt.event.KeyEvent;

public class FallingBro extends AnimatedGameObject 
{
    private boolean initialAnim;

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
        Animation animation,
        boolean initialAnim) 
    {
        super(x, y, vX, vY, aX, aY, w, h, id, animation);
        this.initialAnim = initialAnim;
    }

    @Override
    public void update()
    {
        if (initialAnim)
        {
            if (getX() >= .45 && getX() <= .55)
            {
                setVelX(0);
                setVelY(0);
                setAccX(0);
                setAccY(0);
                initialAnim = false;
            }
            return;
        }
        
        if (Input.isButtonDown(KeyEvent.VK_LEFT))
        {
            setVelX(-.004f);
        }
        if (Input.isButtonReleased(KeyEvent.VK_LEFT)) 
        {
            setVelX(0);
        }
        if (Input.isButtonDown(KeyEvent.VK_RIGHT))
        {
            setVelX(.004f);
        }
        if (Input.isButtonReleased(KeyEvent.VK_RIGHT)) 
        {
            setVelX(0);
        }
    }
}
