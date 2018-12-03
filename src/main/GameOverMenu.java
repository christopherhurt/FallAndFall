package main;

import java.awt.Color;
import java.awt.Font;

public class GameOverMenu {
    
    public static void init() {
        Game.createScene("gameOverMenu");
    }
    
    public static void construct(int finalScore) {
        Game.clearScene("gameOverMenu");
        
        GameObject background = new TexturedGameObject(0, -4, 0, 0, 0, 0, 1, 8, "gameOverMenuBackground", new Texture("sprites/background.png"));
        Game.addObjectToScene("gameOverMenu", background);
        
        final float messageHeight = 0.1f;
        final float messageWidth = messageHeight * 106f / 26f;
        final float messageY = 0.25f;
        GameObject message = new TexturedGameObject((1 - messageWidth) / 2, messageY, 0, 0, 0, 0, messageWidth, messageHeight, "mainMenuTitle", new Texture("menus/gameOverBanner.png"));
        Game.addObjectToScene("gameOverMenu", message);
        
        Menu menu = new Menu("gameOverMenu");
        MenuLabel scoreLabel = new MenuLabel("Score: " + finalScore, "arial", Font.PLAIN, 0.05f, Color.BLACK, 0.38f, 0.5f, "gameOverScoreLabel");
        menu.addLabel(scoreLabel);
        menu.addButton(new RestartButton());
        Game.attachMenuToScene("gameOverMenu", menu);
        
        Game.setCurrentScene("gameOverMenu");
    }
    
    private static class RestartButton extends TexturedMenuButton {
        
        private static final float HEIGHT = 0.1f;
        private static final float WIDTH = HEIGHT * 88f / 25f;
        private static final float Y = 0.6f;
        
        private static final Texture UNHOVERED_TEX = new Texture("menus/restartButtonUnhovered.png");
        private static final Texture HOVERED_TEX = new Texture("menus/restartButtonHovered.png");
        private static final Texture CLICKED_TEX = new Texture("menus/restartButtonClicked.png");
        
        public RestartButton() {
            super((1 - WIDTH) / 2, Y, WIDTH, HEIGHT, UNHOVERED_TEX, HOVERED_TEX, CLICKED_TEX, "restartButton");
        }
        
        @Override
        public void update() {
            if(isClicked()) {
                Starter.startThrowScene();
            }
        }
        
    }
    
}
