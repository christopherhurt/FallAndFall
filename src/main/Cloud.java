package main;


import java.util.Random;

import main.Texture;
import main.TexturedGameObject;

public class Cloud extends TexturedGameObject {
    
    private static final float CLOUD_RANGE = .1f;
    
    private static Random ran = new Random();
    private static float width = (float) (ran.nextInt((int) (CLOUD_RANGE * 10)) / 100.0) + .1f;
    private static float height = width;
    private static float x = (float) (ran.nextInt(100) / 100.0);
    
    public Cloud(String id) {
        super(x, 1f, 0, Runner.UPWARD_SPEED, 0, 0, width, height, id, new Texture("tempChar.png"));
    }
    
}
