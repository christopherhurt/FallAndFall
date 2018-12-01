package main;

import java.awt.Color;

public class Runner {
    
    private static final float CAMERA_SPEED = 0.003f;
    private static final int WINDOW_WIDTH = 1600;
    private static final int WINDOW_HEIGHT = 1600;
    private static final int MAX_FPS = 60;
    
    public static void main(String[] args) 
    {
        Game.createScene("game");
        TexturedGameObject gameBackground = new TexturedGameObject(0, 0, 0, 0, 0, 0, 1, 1, "gameBackground", new Texture("tempBackground.png"));
        Game.addObjectToScene("game", gameBackground);
        
        Game.start(WINDOW_WIDTH, WINDOW_HEIGHT, "eatmuhass", null, MAX_FPS, Color.CYAN);
    }
    
}
