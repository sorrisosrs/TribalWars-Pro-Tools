package net.wesleynascimento.twpt.factories;

import java.awt.*;

/**
 * Created by Wesley Nascimento on 14/10/2014.
 */
public class FontFactory {

    public String DEFAULT_FONT = "Helvetica,Arial";

    public Font getFont(String fontName){
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.getAllFonts();

        return new Font(fontName, Font.PLAIN, 12);
    }

    public Font getDefaultFont(){
        return getFont( DEFAULT_FONT );
    }
}
