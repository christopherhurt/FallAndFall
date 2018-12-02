package main;


public class Bird extends AnimatedGameObject {
    
    private static float width = .1f;
    private static float height = width;
    private static SpriteSheet birdSprite = new SpriteSheet("sprites/bird.png", 8, 8);
    private static Texture t0B = birdSprite.getTexture(0, 0);
    private static Texture t1B = birdSprite.getTexture(0, 1);
    private static Texture t2B = birdSprite.getTexture(0, 2);
    private static Animation birdAnim = new Animation(.5f, t0B, t1B, t2B);
    private static final float OFFSET = Camera.getY() + 1f + .1f;
    
    public Bird(String id) {
        super(getRandomX(), OFFSET, 0, Runner.UPWARD_SPEED, 0, 0, width, height, id, birdAnim);
    }
    
    @Override
    public void update()
    {
        if (getY() <= 0 - getHeight())
        {
            Game.removeObjectFromScene("game", this);
        }
    }
    
    private static float getRandomX() {
        return (float) (Math.random() * (1 - width));
    }
}
