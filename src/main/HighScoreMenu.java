package main;

import java.awt.Color;
import java.awt.Font;

public class HighScoreMenu {

    private Menu highScoreMenu;
    
    public HighScoreMenu(String name)
    {
        highScoreMenu = new Menu(name);
        highScoreMenu.addLabel(new HighScoreMenuLabel("0", "Arial", Font.PLAIN, .05f, Color.BLACK, .8f, .1f, "score"));
    }
    
    public void incrementScore(int increment)
    {
        highScoreMenu.getLabel("score").setText("" + (Integer.parseInt(highScoreMenu.getLabel("score").getText()) + increment));
    }
}
