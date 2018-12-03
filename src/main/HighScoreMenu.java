package main;

import java.awt.Color;
import java.awt.Font;

public class HighScoreMenu {

    private static Menu highScoreMenu;
    private static int initialScore;
    
    public HighScoreMenu(String name, int initialScore)
    {
        highScoreMenu = new Menu(name);
        highScoreMenu.addLabel(new MenuLabel("Score:", "Arial", Font.PLAIN, .03f, Color.BLACK, .9f, .05f, "label"));
        highScoreMenu.addLabel(new MenuLabel("0", "Arial", Font.PLAIN, .03f, Color.BLACK, .9f, .1f, "score"));
        HighScoreMenu.initialScore = initialScore;
        setScore(initialScore);
    }
    
    public static int getScore()
    {
        return Integer.parseInt(highScoreMenu.getLabel("score").getText());
    }
    
    public static void setScore(int score)
    {
        highScoreMenu.getLabel("score").setText("" + (initialScore + score));
    }
    
    public Menu getMenu()
    {
        return highScoreMenu;
    }
}
