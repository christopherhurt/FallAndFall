package main;

import java.awt.Graphics2D;
import java.util.Random;

public class AirPlane extends TexturedGameObject {

    private static float HORIZONTAL_SPEED = .005f;
    private static float MAX_OFFSCREEN_DIST = 0.5f;
    private static float SPEED_MULTIPLIER = 0.8f;
    private static Random ran = new Random();
    private static float height = .05f;
    private static float hitScale = 1.5f;
    private static float width = 4 * height * hitScale;
    private static SpriteSheet planeSprite = new SpriteSheet("sprites/plane.png", 8, 2);
    private static Texture planeRightTex = planeSprite.getTexture(0, 0);
    private static Texture planeLeftText = planeSprite.getTexture(0, 1);
    private int direction;
    
    public AirPlane(String id, float y) {
        super(0, 0, 0, 0, 0, 0, width, height, id, null);
        direction = ran.nextInt(2);
        float offscreenDist = (float)(Math.random() * MAX_OFFSCREEN_DIST);
        setX(direction == 0 ? -width - offscreenDist : 1 + offscreenDist);
        setY(y);
        setVelX((-2 * direction + 1) * HORIZONTAL_SPEED);
        setVelY((float)(Math.random() * SPEED_MULTIPLIER * Runner.UPWARD_SPEED));
        setTexture(direction == 0 ? planeRightTex : planeLeftText);
    }
    
    @Override
    public void update()
    {
        if (getY() < -getHeight())
        {
            Game.removeObjectFromScene("game", this);
        }
    }
    
    @Override
    public void render(Graphics2D g) {
        Texture tex = direction == 0 ? planeRightTex : planeLeftText;
        int x = (int)(Runner.WINDOW_WIDTH * getX());
        int y = (int)(Runner.WINDOW_HEIGHT * (getY() - height * (hitScale - 1)));
        int w = (int)(Runner.WINDOW_WIDTH * getWidth());
        int h = (int)(Runner.WINDOW_HEIGHT * (getHeight() + height * (hitScale - 1)));
        g.drawImage(tex.getImage(), x, y, w, h, null);
        g.drawRect(x, (int)(Runner.WINDOW_HEIGHT * getY()), w, (int)(Runner.WINDOW_HEIGHT * getHeight())); // TODO
    }
    
}
