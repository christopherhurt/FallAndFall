package main;

import java.awt.Color;

public class Runner {
    
    public static final int WINDOW_WIDTH = 1000;
    public static final int WINDOW_HEIGHT = 1000;
    private static final int MAX_FPS = 60;

    public static final float UPWARD_SPEED = -.005f;
    
    public static void main(String[] args) 
    {
        Game.createScene("game");
        
        Background gameBackground = new Background(0);
        Game.addObjectToScene("game", gameBackground);

        SpriteSheet fallingBroSprite = new SpriteSheet("sprites/player.png", 4, 8);
        Texture t0F = fallingBroSprite.getTexture(0, 0);
        Texture t1F = fallingBroSprite.getTexture(0, 1);
        Texture t2F = fallingBroSprite.getTexture(0, 2);
        Texture t3F = fallingBroSprite.getTexture(0, 3);
        Texture t4F = fallingBroSprite.getTexture(0, 4);
        Texture t5F = fallingBroSprite.getTexture(0, 5);
        Texture t6F = fallingBroSprite.getTexture(0, 6);
        Animation fallingBroAnim = new Animation(.5f, t0F, t1F, t2F, t3F, t2F, t1F, t0F, t4F, t5F, t6F, t5F, t4F);
        FallingBro fallingBro = new FallingBro(0, 0, 0.004f, 0.0015f, -0.00001f, 0.00001f, "fallingDUMASS", fallingBroAnim);   
        Game.addObjectToScene("game", fallingBro);
        
        Bird bird = new Bird("bird", new Animation(0, new Texture("sprites/tempBird.png")));
        Game.addObjectToScene("game", bird);
        
        Game.start(WINDOW_WIDTH, WINDOW_HEIGHT, "eatmuhass", null, MAX_FPS, Color.CYAN);
    }
    
}
