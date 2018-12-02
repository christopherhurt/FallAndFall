package main;

import java.util.Random;

public class Bird extends AnimatedGameObject {
    
    private static Random ran = new Random();
    private static float width = .05f;
    private static float height = width;
    private static float x = (float) (ran.nextInt(100 - (int) (100 * width)) / (100.0 - 100 * width));
    
    public Bird(String id, Animation anim) {
        super(x, 1f, 0, Runner.UPWARD_SPEED, 0, 0, width, height, id, anim);
    }
    
    @Override
    public void update()
    {
        if (getY() <= 0 - getHeight())
        {
            Game.removeObjectFromScene("game", this);
        }
    }
}
