package main;

import java.awt.Color;
import java.awt.event.KeyEvent;

public class ThrownBro extends ColoredGameObject {
    
    private static final float WIDTH = 0.14f;
    private static final float HEIGHT = WIDTH / 2;
    private static final float THROWER_OFFSET_X = -0.02f;
    private static final float THROWER_OFFSET_Y = -0.02f;
    
    private static final Color HELD_TEX = Color.GREEN; // TODO
    private static final Color THROWN_TEX = Color.YELLOW;
    
    private static final float THROW_VEL_MULTIPLIER = 0.01f;
    private static final float THROW_SCORE_MULTIPLIER = 500f;
    private static final float FALL_ACCEL = 0.0005f;
    private static final float INIT_FALL_MULTIPLIER = 0.25f;
    private static final float THROW_DELAY = 0f;
    
    private ThrowerBro throwerBro;
    private boolean thrown;
    private boolean moving;
    private int throwScore;
    private long throwTime;
    
    public ThrownBro(ThrowerBro throwerBro) {
        super(calcX(throwerBro), calcY(throwerBro), 0, 0, 0, 0, WIDTH, HEIGHT, "thrownBro", HELD_TEX);
        this.throwerBro = throwerBro;
        thrown = false;
        moving = false;
        throwScore = 0;
        throwTime = 0;
    }
    
    private static float calcX(GameObject throwerBro) {
        float throwerCenter = throwerBro.getX() + throwerBro.getWidth() / 2;
        float thrownCenter = throwerCenter + THROWER_OFFSET_X;
        float thrownX = thrownCenter - WIDTH / 2;
        return thrownX;
    }
    
    private static float calcY(GameObject throwerBro) {
        float throwerCenter = throwerBro.getY() + throwerBro.getHeight() / 2;
        float thrownCenter = throwerCenter + THROWER_OFFSET_Y;
        float thrownY = thrownCenter - HEIGHT / 2;
        return thrownY;
    }
    
    private void setThrown() {
        setColor(THROWN_TEX); // TODO: set texture
    }
    
    @Override
    public void update() {
        if(!thrown && Input.isKeyPressed(KeyEvent.VK_SPACE)) {
            throwTime = System.currentTimeMillis();
            throwScore = (int)THROW_SCORE_MULTIPLIER; // TODO: depend on throw strength
            thrown = true;
        } else if(thrown) {
            if(getY() >= 1) {
                Starter.startFallScene(getVelX() * INIT_FALL_MULTIPLIER, getVelY() * INIT_FALL_MULTIPLIER, throwScore);
            } else if(!moving && System.currentTimeMillis() - throwTime >= (long)(THROW_DELAY * 1000)) {
                // TODO: change velocity to depend on throw strength
                setVelX(THROW_VEL_MULTIPLIER);
                setVelY(-THROW_VEL_MULTIPLIER);
                setAccY(FALL_ACCEL);
                setThrown();
                throwerBro.setThrowing();
                moving = true;
            }
        }
    }
    
}
