package main;

public class ThrowerBro extends TexturedGameObject {
    
    private static final float WIDTH = 0.07f;
    private static final float HEIGHT = WIDTH * 2;
    private static final float X = 0.25f;
    
    private static final SpriteSheet throwerBroSS = new SpriteSheet("sprites/throwerBro.png", 4, 8);
    private static final Texture TEX_HOLDING = throwerBroSS.getTexture(0, 0);
    private static final Texture TEX_THROWING = throwerBroSS.getTexture(0, 1);
    
    public ThrowerBro(GameObject building) {
        super(X, building.getY() - HEIGHT, 0, 0, 0, 0, WIDTH, HEIGHT, "throwerBro", TEX_HOLDING);
    }
    
    public void setThrowing() {
        setTexture(TEX_THROWING);
    }
    
}
