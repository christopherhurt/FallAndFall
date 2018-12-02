package main;

import java.util.Random;

public class AirPlane extends TexturedGameObject {

    private static float HORIZONTAL_SPEED = .005f;
    private static Random ran = new Random();
    private static float height = .1f;
    private static float width = 4 * height;
    private static int direction = ran.nextInt(2);
    
    public AirPlane(String id, SpriteSheet sprites) {
        super((float)(((2 * direction - 1) * (ran.nextInt(6) * .1)) + direction),
            1.5f,
            (-2 * direction + 1) * HORIZONTAL_SPEED,
            (float)((ran.nextInt(3) + 8) * .1 * Runner.UPWARD_SPEED),
            0, 0, width, height, id, sprites.getTexture(0, direction));
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
