package main;

import java.awt.Color;

public class Runner {
    
    private static final int WINDOW_WIDTH = 1600;
    private static final int WINDOW_HEIGHT = 1600;
    private static final int MAX_FPS = 60;
    
    public static void main(String[] args) 
    {
        Game.createScene("game");
        
        TexturedGameObject gameBackground = new TexturedGameObject(0, 0, 0, 0, 0, 0, 1, 1, "gameBackground", new Texture("tempBackground.png"));
        TexturedGameObject fallingChar = new TexturedGameObject(0, 0, .005f, 0, 0, .0001f, .1f, .1f, "fallingDUMASS", new Texture("tempChar.png"));
        Game.addObjectToScene("game", gameBackground);
        Game.addObjectToScene("game", fallingChar);
        
        Game.start(WINDOW_WIDTH, WINDOW_HEIGHT, "eatmuhass", null, MAX_FPS, Color.CYAN);
    }
    
}
