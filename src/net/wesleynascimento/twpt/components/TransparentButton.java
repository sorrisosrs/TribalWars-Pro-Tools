package net.wesleynascimento.twpt.components;

import javax.swing.*;
import java.awt.*;

public class TransparentButton extends JButton
        implements Transparent {
    private static final long serialVersionUID = 1L;
    private final TransparentComponent transparency = new TransparentComponent(this);

    public TransparentButton() {
        setBorder(null);
        setRolloverEnabled(true);
        setFocusable(false);
        setContentAreaFilled(false);
        setOpaque(false);
    }

    public void setIcon(Icon icon) {
        super.setIcon(icon);
        setRolloverIcon(getIcon());
        setSelectedIcon(getIcon());
        setDisabledIcon(getIcon());
        setPressedIcon(getIcon());
    }

    public void paint(Graphics g) {
        g = this.transparency.setup(g);
        super.paint(g);
        this.transparency.cleanup(g);
    }

    public float getTransparency() {
        return this.transparency.getTransparency();
    }

    public void setTransparency(float t) {
        this.transparency.setTransparency(t);
    }

    public float getHoverTransparency() {
        return this.transparency.getHoverTransparency();
    }

    public void setHoverTransparency(float t) {
        this.transparency.setHoverTransparency(t);
    }
}