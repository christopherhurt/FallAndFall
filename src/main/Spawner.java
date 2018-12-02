package main;

import java.awt.Color;

public class Spawner extends ColoredGameObject {
    
    private float birdProbability;
    private float planeProbability;
    private static final float PLANE_OFFSET = Camera.getY() + .75f;
    private static final float OFFSET_RANGE = .75f;
    private static final float PROB_UPDATE = .0000001f;
    private float prob;
    
    public Spawner(float birdProbability, float planeProbability) {
        super(0, 0, 0, 0, 0, 0, 0, 0, "spawner", Color.RED);
        this.birdProbability = birdProbability;
        this.planeProbability = planeProbability;
    }
    
    @Override
    public void update() {
        setY(Camera.getY());
        prob = (float) Math.random();
        if (prob < birdProbability) {
            Game.addObjectToScene("game", new Bird("bird"));
        }
        prob = (float) Math.random();
        if (prob < planeProbability) {
            float offset = (float) (Math.random() * OFFSET_RANGE);
            Game.addObjectToScene("game", new AirPlane("airplane", offset + PLANE_OFFSET));
        }
        prob += PROB_UPDATE;
    }

}
