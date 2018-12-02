package main;

public class GameOverMenu {
    
    public static void init() {
        Game.createScene("gameOverMenu");
    }
    
    public static void construct() {
        Game.clearScene("gameOverMenu");
        
        GameObject background = new TexturedGameObject(0, 0, 0, 0, 0, 0, 1, 8, "gameOverMenuBackground", new Texture("sprites/background.png"));
        Game.addObjectToScene("gameOverMenu", background);
        
        final float messageWidth = 0.4f; // TODO: adjust these
        final float messageHeight = 0.1f;
        final float messageY = 0.25f;
        GameObject title = new TexturedGameObject((1 - messageWidth) / 2, messageY, 0, 0, 0, 0, messageWidth, messageHeight, "mainMenuTitle", new Texture("sprites/bird.png")); // TODO
        Game.addObjectToScene("mainMenu", title);
        
        Menu menu = new Menu("gameOverMenu");
        menu.addButton(new RestartButton());
        Game.attachMenuToScene("gameOverMenu", menu);
        
        Game.setCurrentScene("gameOverMenu");
    }
    
    private static class RestartButton extends TexturedMenuButton {
        
        private static final float HEIGHT = 0.1f; // TODO: adjust these
        private static final float WIDTH = HEIGHT * 88f / 25f;
        private static final float Y = 0.6f;
        
        private static final Texture UNHOVERED_TEX = new Texture("menus/restartButtonUnhovered.png"); // TODO
        private static final Texture HOVERED_TEX = new Texture("menus/restartButtonHovered.png");
        private static final Texture CLICKED_TEX = new Texture("menus/restartButtonClicked.png");
        
        public RestartButton() {
            super((1 - WIDTH) / 2, Y, WIDTH, HEIGHT, UNHOVERED_TEX, HOVERED_TEX, CLICKED_TEX, "restartButton");
        }
        
        @Override
        public void update() {
            if(isClicked()) { // TODO: restart the game
                Starter.start(0.004f, 0.0015f, 0);
            }
        }
        
    }
    
}
