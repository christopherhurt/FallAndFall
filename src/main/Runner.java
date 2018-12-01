package main;

import java.awt.Color;

public class Runner {
    
    private static final int WINDOW_WIDTH = 1600;
    private static final int WINDOW_HEIGHT = 1600;
    private static final int MAX_FPS = 60;

    public static final float CHAR_INITIAL_X = 0;
    public static final float CHAR_INITIAL_Y = 0;
    public static final float CHAR_INITIAL_VELX = 0.004f;
    public static final float CHAR_INITIAL_VELY = 0.0015f;
    public static final float CHAR_INITIAL_ACCX = -0.00001f;
    public static final float CHAR_INITIAL_ACCY = 0.00001f;
    public static final float CHAR_INITIAL_WIDTH = 0.1f;
    public static final float CHAR_INITIAL_HEIGHT = 0.1f;
    
    public static void main(String[] args) 
    {
        Game.createScene("game");
        
        TexturedGameObject gameBackground = new TexturedGameObject(0, 0, 0, 0, 0, 0, 1, 1, "gameBackground", new Texture("tempBackground.png"));
        FallingBro fallingBro = new FallingBro(CHAR_INITIAL_X, CHAR_INITIAL_Y, CHAR_INITIAL_VELX, CHAR_INITIAL_VELY, CHAR_INITIAL_ACCX, CHAR_INITIAL_ACCY, CHAR_INITIAL_WIDTH, CHAR_INITIAL_HEIGHT, "fallingDUMASS", new Animation(0, new Texture("tempChar.png")), true);
        Game.addObjectToScene("game", gameBackground);
        Game.addObjectToScene("game", fallingBro);
        
        Game.start(WINDOW_WIDTH, WINDOW_HEIGHT, "eatmuhass", null, MAX_FPS, Color.CYAN);
    }
    
}
