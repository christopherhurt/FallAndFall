package main;

import java.awt.Color;
import java.awt.Font;

public class HighScoreMenu {

    private static Menu highScoreMenu;
    
    public HighScoreMenu(String name)
    {
        highScoreMenu = new Menu(name);
        highScoreMenu.addLabel(new MenuLabel("Score:", "Arial", Font.PLAIN, .03f, Color.BLACK, .9f, .05f, "label"));
        highScoreMenu.addLabel(new HighScoreMenuLabel("0", "Arial", Font.PLAIN, .03f, Color.BLACK, .9f, .1f, "score"));
    }
    
    public static int getScore()
    {
        return Integer.parseInt(highScoreMenu.getLabel("score").getText());
    }
    
    public static void setScore(int score)
    {
        highScoreMenu.getLabel("score").setText("" + score);
    }
    
    public Menu getMenu()
    {
        return highScoreMenu;
    }
}
