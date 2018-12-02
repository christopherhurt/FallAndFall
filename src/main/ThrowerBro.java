package main;

import java.awt.Color;

public class ThrowerBro extends ColoredGameObject {
    
    private static final float WIDTH = 0.07f;
    private static final float HEIGHT = WIDTH * 2;
    private static final float X = 0.25f;
    
    private static final Color TEX_HOLDING = Color.RED; // TODO
    private static final Color TEX_THROWING = Color.BLUE;
    
    public ThrowerBro(GameObject building) {
        super(X, building.getY() - HEIGHT, 0, 0, 0, 0, WIDTH, HEIGHT, "throwerBro", TEX_HOLDING);
    }
    
    public void setThrowing() {
        setColor(TEX_THROWING); // TODO: set texture
    }
    
}
