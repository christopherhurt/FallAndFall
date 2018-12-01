package main;

import java.awt.Color;
import java.util.Random;

public class Runner {
    
    private static final int WINDOW_WIDTH = 1600;
    private static final int WINDOW_HEIGHT = 1600;
    private static final int MAX_FPS = 60;
    public static final float UPWARD_SPEED = -.005f;
    
    public static void main(String[] args) 
    {
        Game.createScene("game");
        
        TexturedGameObject gameBackground = new TexturedGameObject(0, 0, 0, 0, 0, 0, 1, 1, "gameBackground", new Texture("tempBackground.png"));
        TexturedGameObject fallingChar = new TexturedGameObject(0, 0, .005f, 0, 0, .0001f, .1f, .1f, "fallingDUMASS", new Texture("tempChar.png"));
        Game.addObjectToScene("game", gameBackground);
        Game.addObjectToScene("game", fallingChar);
        Cloud cloud = new Cloud("cloud1", "tempCloud.png");
        Game.addObjectToScene("game", cloud);
        Animation birdAnim = new Animation(0, new Texture("tempBird.png"));
        Bird bird = new Bird("bird", birdAnim);
        Game.addObjectToScene("game", bird);
        
        Game.start(WINDOW_WIDTH, WINDOW_HEIGHT, "eatmuhass", null, MAX_FPS, Color.CYAN);
    }
    
}
