package main;

import java.awt.event.KeyEvent;

public class ThrownBro extends TexturedGameObject {
    
    private static final float WIDTH = 0.14f;
    private static final float HEIGHT = WIDTH / 2;
    private static final float THROWER_OFFSET_X = -0.015f;
    private static final float THROWER_OFFSET_Y = -0.077f;
    
    private static final SpriteSheet thrownBroSS = new SpriteSheet("sprites/thrownBro.png", 8, 4);
    private static final Texture HELD_TEX = thrownBroSS.getTexture(0, 0);
    private static final Texture THROWN_TEX = thrownBroSS.getTexture(0, 1);
    
    private static final float THROW_VEL_MULTIPLIER = 0.01f;
    private static final float THROW_SCORE_MULTIPLIER = 50f;
    private static final float FALL_ACCEL = 0.0005f;
    private static final float INIT_FALL_MULTIPLIER = 0.001f;
    private static final float THROW_DELAY = 0f;
    
    private ThrowerBro throwerBro;
    private boolean thrown;
    private boolean moving;
    private int throwScore;
    private long throwTime;
    private int thrownSpeed;
    
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
        setTexture(THROWN_TEX);
    }
    
    @Override
    public void update() {
        if(!thrown && Input.isKeyPressed(KeyEvent.VK_SPACE)) {
            throwTime = System.currentTimeMillis();
            thrownSpeed = ((PowerBar)(Game.getGameObjects("power").get(0))).stopPowerBar();
            throwScore = thrownSpeed * (int)THROW_SCORE_MULTIPLIER; // TODO: depend on throw strength
            thrown = true;
        } else if(thrown) {
            if(getY() >= 1) {
                Starter.startFallScene(thrownSpeed * INIT_FALL_MULTIPLIER, thrownSpeed * INIT_FALL_MULTIPLIER, throwScore);
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
