package main;

import java.util.List;

public class Background extends TexturedGameObject {
    
    private boolean past;
    private static final float OFFSET = 0.1f;
    
    public Background(float y) {
        super(0, y, 0, Runner.UPWARD_SPEED, 0, 0, 1, 8, "gameBackground", new Texture("sprites/background.png"));
        past = false;
    }
    
    @Override
    public void update() {
        if (!past && getY() < 1 + OFFSET - getHeight()) {
            List<GameObject> objList = Game.getObjectList("game");
            objList.add(0, new Background(getY() + getHeight()));
            past = true;
        }
        if (getY() < -getHeight()) {
            Game.removeObjectFromScene("game", this);
        }
    }

}
