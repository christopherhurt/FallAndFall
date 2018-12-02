package main;

import java.util.Random;

public class AirPlane extends TexturedGameObject {

    private static float HORIZONTAL_SPEED = .005f;
    private static Random ran = new Random();
    private static float height = .1f;
    private static float width = 4 * height;
    private static SpriteSheet planeSprite = new SpriteSheet("sprites/plane.png", 8, 2);
    private int direction = ran.nextInt(2);
    
    public AirPlane(String id, float y) {
        super(0, 0, 0, 0, 0, 0, width, height, id, null);
        setX((float)(((2 * direction - 1) * (ran.nextInt(6) * .1)) + direction));
        setY(y);
        setVelX((-2 * direction + 1) * HORIZONTAL_SPEED);
        setVelY((float)((ran.nextInt(3) + 8) * .1 * Runner.UPWARD_SPEED));
        setTexture(planeSprite.getTexture(0, direction));
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
