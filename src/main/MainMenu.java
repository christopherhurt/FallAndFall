package main;

public class MainMenu {
    
    public static void init() {
        Game.createScene("mainMenu");
    }
    
    public static void construct() {
        Game.clearScene("mainMenu");
        
        GameObject background = new TexturedGameObject(0, 0, 0, 0, 0, 0, 1, 8, "mainMenuBackground", new Texture("sprites/background.png"));
        Game.addObjectToScene("mainMenu", background);
        
        final float titleWidth = 0.4f; // TODO: adjust these
        final float titleHeight = 0.1f;
        final float titleY = 0.25f;
        GameObject title = new TexturedGameObject((1 - titleWidth) / 2, titleY, 0, 0, 0, 0, titleWidth, titleHeight, "mainMenuTitle", new Texture("sprites/tempBackground.png")); // TODO
        Game.addObjectToScene("mainMenu", title);
        
        Menu menu = new Menu("mainMenu");
        menu.addButton(new StartButton());
        Game.attachMenuToScene("mainMenu", menu);
        
        Game.setCurrentScene("mainMenu");
    }
    
    private static class StartButton extends TexturedMenuButton {
        
        private static final float WIDTH = 0.4f; // TODO: adjust these
        private static final float HEIGHT = 0.1f;
        private static final float Y = 0.6f;
        
        private static final Texture UNHOVERED_TEX = new Texture("tempBirg.png"); // TODO
        private static final Texture HOVERED_TEX = new Texture("tempChar.png");
        private static final Texture CLICKED_TEX = new Texture("tempCloud.png");
        
        public StartButton() {
            super((1 - WIDTH) / 2, Y, WIDTH, HEIGHT, UNHOVERED_TEX, HOVERED_TEX, CLICKED_TEX, "startButton");
        }
        
        @Override
        public void update() {
            if(isClicked()) { // TODO: start the game
                
            }
        }
        
    }
    
}
