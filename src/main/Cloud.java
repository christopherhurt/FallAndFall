package main;


import java.util.Random;

public class Cloud extends TexturedGameObject {
    
    private static final float CLOUD_RANGE = .1f;
    
    private static Random ran = new Random();
    private static float width = (float) (ran.nextInt((int) (CLOUD_RANGE * 10)) / 100.0) + .1f;
    private static float height = width;
    private static float x = (float) (ran.nextInt(100 - (int) (100 * width)) / (100.0 - 100 * width));
    
    public Cloud(String id, String tex) {
        super(x, 1f, 0, Runner.UPWARD_SPEED, 0, 0, width, height, id, new Texture(tex));
    }
    
}
