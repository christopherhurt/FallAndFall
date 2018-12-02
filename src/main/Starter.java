package main;

public class Starter {
    
    public static void start(float vX, float vY, int throwScore) {
        Game.clearScene("game");
        Spawner spawner = new Spawner(Runner.SPAWN_PROBABILITY_BIRD, Runner.SPAWN_PROBABILITY_AIRPLANE);
        Game.addObjectToScene("game", spawner);
        
        Background gameBackground = new Background(0);
        Game.addObjectToScene("game", gameBackground);

        HighScoreMenu score = new HighScoreMenu("score");
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
    }

}
