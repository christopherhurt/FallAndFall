package main;

import java.awt.Color;
import java.util.Random;

public class Spawner extends ColoredGameObject {
    
    private float probability;
    private static final float PLANE_OFFSET = Camera.getY() + .75f;
    private static final float OFFSET_RANGE = .75f;
    private static final float PROB_UPDATE = .0000001f;
    private Random ran;
    private float prob;
    
    public Spawner(float probability) {
        super(0, 0, 0, 0, 0, 0, 0, 0, "spawner", Color.RED);
        this.probability = probability;
        ran = new Random();
    }
    
    @Override
    public void update() {
        setY(Camera.getY());
        prob = (float) Math.random();
        if (prob < probability) {
            Game.addObjectToScene("game", new Bird("bird"));
        }
        prob = (float) Math.random();
        if (prob < probability) {
            float offset = (float) (Math.random() * OFFSET_RANGE);
            Game.addObjectToScene("game", new AirPlane("airplane", offset + PLANE_OFFSET));
        }
        prob += PROB_UPDATE;
    }

}
