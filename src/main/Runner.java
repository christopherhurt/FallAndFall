package main;

import java.awt.Color;

public class Runner {
    
    public static final int WINDOW_WIDTH = 1600;
    public static final int WINDOW_HEIGHT = 1600;
    private static final int MAX_FPS = 60;

    public static final float UPWARD_SPEED = -.005f;
    
    public static void main(String[] args) 
    {
        Game.createScene("game");
        
        TexturedGameObject gameBackground = new TexturedGameObject(0, 0, 0, 0, 0, 0, 1, 1, "gameBackground", new Texture("tempBackground.png"));
        Game.addObjectToScene("game", gameBackground);
        
        FallingBro fallingBro = new FallingBro(0, 0, 0.004f, 0.0015f, -0.00001f, 0.00001f, 0.1f, 0.1f, "fallingDUMASS", new Animation(0, new Texture("tempChar.png")));     
        Game.addObjectToScene("game", fallingBro);
        
        Cloud cloud = new Cloud("cloud1", "tempCloud.png");
        Game.addObjectToScene("game", cloud);
        
        Bird bird = new Bird("bird", new Animation(0, new Texture("tempBird.png")));
        Game.addObjectToScene("game", bird);
        
        Game.start(WINDOW_WIDTH, WINDOW_HEIGHT, "eatmuhass", null, MAX_FPS, Color.CYAN);
    }
    
}
