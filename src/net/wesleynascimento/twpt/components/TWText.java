package net.wesleynascimento.twpt.components;

import net.wesleynascimento.twpt.enums.Colors;
import net.wesleynascimento.twpt.factories.FontFactory;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created by Administrador on 14/10/2014.
 */
public class TWText extends JTextField implements FocusListener {

    private String placeholder = "";
    private boolean hasFocus = false;
    private Icon icon;
    private Insets dummyInsets;

    public TWText(){
        this("");
    }

    public TWText(String value){
        setText(value);
        this.setForeground( Colors.DEFAULT_FOREGROUND.toColor() );
        this.setBackground( Colors.BACKGROUND_WHITE.toColor() );
        this.addFocusListener( this );
        Border border = BorderFactory.createLineBorder(Colors.PROGRESSBAR_BORDER.toColor(), 1);
        setBorder(border);
        setFont( new FontFactory().getDefaultFont() );
        JTextField dummy = new JTextField();
        this.dummyInsets = border.getBorderInsets(dummy);
    }

    public void setPlaceholder( String placeholder){
        this.placeholder = placeholder;
    }

    public void setIcon(String path, String desc){
        this.icon = createImageIcon(path, desc);
    }

    @Override
    public void paintComponent(Graphics g){
        setMargin(new Insets(5, 5, 5, 5));
        super.paintComponent(g);

        int textX = 5;

        if(this.icon!=null){
            int iconWidth = icon.getIconWidth();
            int iconHeight = icon.getIconHeight();
            int x = dummyInsets.left + 5;
            textX = x + iconWidth + 5;
            int y = (this.getHeight() - iconHeight)/2;
            icon.paintIcon(this, g, x, y);
        }

        Font f = getFont();
        if ( !hasFocus && getText().equals("") && f != null ) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor( Color.GRAY );

            FontMetrics fm = getFontMetrics(getFont());

            Font italic = getFont().deriveFont(Font.ITALIC);
            g2d.setFont(italic);

            RenderingHints hints = g2d.getRenderingHints();
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2d.drawString( placeholder, textX, getHeight() / 2 + (fm.getMaxAscent() - fm.getMaxDescent()) / 2);
            g2d.setRenderingHints(hints);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        this.hasFocus = true;
        this.repaint();
    }

    @Override
    public void focusLost(FocusEvent e) {
        this.hasFocus = false;
        this.repaint();
    }

    private ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
