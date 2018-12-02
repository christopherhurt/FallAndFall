package main;

import java.awt.Color;

public class Runner {
    
    public static final int WINDOW_WIDTH = 1000;
    public static final int WINDOW_HEIGHT = 1000;
    public static final int MAX_FPS = 60;

    public static final float UPWARD_SPEED = -.005f;
    
    public static final float SPAWN_PROBABILITY_BIRD = .01f;
    public static final float SPAWN_PROBABILITY_AIRPLANE = .005f;
    
    public static void main(String[] args) 
    {
        Game.createScene("game");
        
        Starter.start(0.004f, 0.0015f, 0);
        
        Game.start(WINDOW_WIDTH, WINDOW_HEIGHT, "eatmuhass", null, MAX_FPS, Color.CYAN);
    }
    
}
