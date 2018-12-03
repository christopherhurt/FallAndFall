package main;

import java.awt.Color;
import java.awt.Font;

public class Starter {
    
    private static final float SPACE_TEXT_X = .7f;
    private static final float SACRIFICE_TEXT_X = SPACE_TEXT_X - .0035f;
    private static final float SPACE_TEXT_Y = .05f;
    private static final float TEXT_Y_SEPARATOR = .05f;
    private static final float SACRIFICE_TEXT_Y = SPACE_TEXT_Y + TEXT_Y_SEPARATOR;
    
    
    public static void startThrowScene() {
        Game.clearScene("throwScene");
        
        GameObject background = new TexturedGameObject(0, -4, 0, 0, 0, 0, 1, 8, "throwSceneBackground", new Texture("sprites/background.png"));
        Game.addObjectToScene("throwScene", background);
        
        GameObject building = new ColoredGameObject(0, 0.6f, 0, 0, 0, 0, 0.35f, 0.4f, "building", Color.GRAY); // TODO: texture
        Game.addObjectToScene("throwScene", building);
        
        ThrowerBro thrower = new ThrowerBro(building);
        Game.addObjectToScene("throwScene", thrower);
        
        GameObject thrownPlayer = new ThrownBro(thrower);
        Game.addObjectToScene("throwScene", thrownPlayer);
        
        GameObject powerBar = new PowerBar("power", Color.red, 10);
        Game.addObjectToScene("throwScene", powerBar);
        
        MenuLabel pressSpace = new MenuLabel("PRESS SPACE", "Arial", Font.PLAIN, .03f, Color.BLACK, SPACE_TEXT_X, SPACE_TEXT_Y, "press space");
        MenuLabel toSacrifice = new MenuLabel("TO SACRIFICE!", "Arial", Font.PLAIN, .03f, Color.BLACK, SACRIFICE_TEXT_X, SACRIFICE_TEXT_Y, "to sacrifice");
        Menu power = new Menu("power ins");
        power.addLabel(pressSpace);
        power.addLabel(toSacrifice);
        Game.attachMenuToScene("throwScene", power);
        
        Game.setCurrentScene("throwScene");
    }
    
    public static void startFallScene(float vX, float vY, int throwScore) {
        Game.clearScene("game");
        Spawner spawner = new Spawner(Runner.SPAWN_PROBABILITY_BIRD, Runner.SPAWN_PROBABILITY_AIRPLANE);
        Game.addObjectToScene("game", spawner);
        
        Background gameBackground = new Background(0);
        Game.addObjectToScene("game", gameBackground);
        
        HighScoreMenu score = new HighScoreMenu("score", throwScore);
        Game.attachMenuToScene("game", score.getMenu());
        
        SpriteSheet fallingBroSprite = new SpriteSheet("sprites/player.png", 4, 8);
        Texture t0F = fallingBroSprite.getTexture(0, 0);
        Texture t1F = fallingBroSprite.getTexture(0, 1);
        Texture t2F = fallingBroSprite.getTexture(0, 2);
        Texture t3F = fallingBroSprite.getTexture(0, 3);
        Texture t4F = fallingBroSprite.getTexture(0, 4);
        Texture t5F = fallingBroSprite.getTexture(0, 5);
        Texture t6F = fallingBroSprite.getTexture(0, 6);
        Animation fallingBroAnim = new Animation(.5f, t0F, t1F, t2F, t3F, t2F, t1F, t0F, t4F, t5F, t6F, t5F, t4F);
        FallingBro fallingBro = new FallingBro(-.1f, -.1f, vX, vY, -0.00001f, 0.00001f, "fallingDUMASS", fallingBroAnim); 
        Game.addObjectToScene("game", fallingBro);
        
        Game.setCurrentScene("game");
    }
    
}
