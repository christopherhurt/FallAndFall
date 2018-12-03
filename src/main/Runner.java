package main;

import java.awt.Color;

public class Runner {
    
    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 600;
    public static final int MAX_FPS = 60;

    public static final float UPWARD_SPEED = -.005f;
    
    public static final float SPAWN_PROBABILITY_BIRD = .01f;
    public static final float SPAWN_PROBABILITY_AIRPLANE = .005f;
    
    public static void main(String[] args) 
    {
        MainMenu.init();
        GameOverMenu.init();
        Game.createScene("throwScene");
        Game.createScene("game");
        
        MainMenu.construct();
        
        Game.start(WINDOW_WIDTH, WINDOW_HEIGHT, "Fall and Fall", "icon.png", MAX_FPS, Color.RED);
    }
    
}
