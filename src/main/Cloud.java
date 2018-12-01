package main;

import main.Texture;
import main.TexturedGameObject;

public class Cloud extends TexturedGameObject {
    
    public static final int NOTE1 = 0;
    public static final int NOTE2 = 1;
    public static final int NOTE3 = 2;
    public static final int NOTE4 = 3;
    
    private static final Texture NOTE1_TEX = Utils.BUTTON_SHEET.getTexture(0, 0);
    private static final Texture NOTE2_TEX = Utils.BUTTON_SHEET.getTexture(0, 1);
    private static final Texture NOTE3_TEX = Utils.BUTTON_SHEET.getTexture(0, 2);
    private static final Texture NOTE4_TEX = Utils.BUTTON_SHEET.getTexture(0, 3);
    
    private int type;
    
    public Cloud(String id) {
        super(.5f, 1f, 0f, .003f, 0f, 0f, .1f, .1f, "cloud", );
    }
    
}
