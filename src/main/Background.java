package main;

public class Background extends TexturedGameObject { 
    
    private boolean past;
    private static final float OFFSET = 0.1f;
    
    public Background(float y) {
        super(0, y, 0, 0, 0, 0, 1, 1, "gameBackground", new Texture("sprites/background.png"));
        past = false;
    }
    
    @Override
    public void update() {
        if (!past && getY() < 1 + OFFSET - getHeight()) {
            Game.addObjectToScene("game", new Background(getY() + getHeight()));
            Game.readdObjects("bird");
            Game.readdObjects("fallingDUMASS");
            //Game.readdObjects("airplane");
            past = true;
        }
        if (getY() < -1 * getHeight()) {
            Game.removeObjectFromScene("game", this);
        }
    }

}
