package net.wesleynascimento.twpt.components;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Created by Wesley on 31/08/2014.
 */
public class IconButton extends TransparentButton  {

    public IconButton(String iconPath){
        super();
        /*
        Image image = Toolkit.getDefaultToolkit().getImage( getClass().getResource("/resources/" + iconPath) );
        ImageIcon icon = new ImageIcon( image );
        this.setIcon(icon);
        */
        setTransparency(0.7F);
        setHoverTransparency(1.0F);
        setBorder(BorderFactory.createEmptyBorder());
        setContentAreaFilled(false);
    }
}
