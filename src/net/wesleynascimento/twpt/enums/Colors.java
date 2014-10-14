package net.wesleynascimento.twpt.enums;

import java.awt.*;

/**
 * Created by Wesley on 31/08/2014.
 */
public enum Colors {
    BACKGROUND_LIGHT(new Color(251, 235, 201)),
    BACKGROUND_DARK(new Color(196, 166, 106)),
    PROGRESSBAR(new Color(146, 194, 0)),
    PROGRESSBAR_BORDER( hex2Color("#dfbc79") ),
    DEFAULT_FOREGROUND( hex2Color("#603000") ),
    DEFAULT_FOREGRAUND_HOVER( hex2Color("#e01f0f") ),
    BUTTON_BACKGROUND_PRESSED( hex2Color("#947A62") );

    private Color color;

    private Colors(Color color){
        this.color = color;
    }

    private Colors(String hexColor){
        this( hex2Color( hexColor ));
    }

    /**
     * Convert a Hex String in a Color object
     * @param hex - The Hexadecimal String
     * @return Color
     */
    public static Color hex2Color(String hex){
        return new Color(
                Integer.valueOf( hex.substring(1, 3), 16 ),
                Integer.valueOf( hex.substring(3, 5), 16 ),
                Integer.valueOf( hex.substring(5, 7), 16)
        );
    }

    public Color toColor(){
        return color;
    }
}
