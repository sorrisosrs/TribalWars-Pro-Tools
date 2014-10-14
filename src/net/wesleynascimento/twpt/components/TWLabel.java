package net.wesleynascimento.twpt.components;

import net.wesleynascimento.twpt.factories.FontFactory;
import net.wesleynascimento.twpt.enums.Colors;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Wesley on 31/08/2014.
 */
public class TWLabel extends JLabel {

    public TWLabel(String text, int fontSize){
        super( text );
        Font font = new FontFactory().getDefaultFont().deriveFont( Font.BOLD, fontSize);
        setFont( font );
        setForeground( Colors.DEFAULT_FOREGROUND.toColor());
    }

    public TWLabel(String text){
        this(text, 9);
    }

    public TWLabel(){
        this("", 9);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font f = getFont();
        if (f != null) {
            FontMetrics fm = getFontMetrics(getFont());
            g2d.drawString( getText(), getWidth() / 2 - fm.stringWidth( getText()) / 2, getHeight() / 2 + (fm.getMaxAscent() - fm.getMaxDescent()) / 2);
        }
    }
}
