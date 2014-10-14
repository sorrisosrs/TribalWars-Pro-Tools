package net.wesleynascimento.twpt.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class TransparentComponent
        implements MouseListener {
    private final JComponent parent;
    private float transparency = 1.0F;
    private float hoverTransparency = 1.0F;
    private boolean hovering = false;
    private final boolean repaint;

    public TransparentComponent(JComponent component) {
        this.parent = component;
        this.parent.addMouseListener(this);
        this.repaint = true;
    }

    public TransparentComponent(JComponent component, boolean repaint) {
        this.parent = component;
        this.parent.addMouseListener(this);
        this.repaint = repaint;
    }

    public float getTransparency() {
        return this.transparency;
    }

    public void setTransparency(float t) {
        if ((t > 1.0F) || (t < 0.0F)) {
            throw new IllegalArgumentException("Value out of range");
        }
        this.transparency = t;
    }

    public float getHoverTransparency() {
        return this.hoverTransparency;
    }

    public void setHoverTransparency(float t) {
        if ((t > 1.0F) || (t < 0.0F)) {
            throw new IllegalArgumentException("Value out of range");
        }
        this.hoverTransparency = t;
    }

    public Graphics setup(Graphics g) {
        float t;
        if (this.hovering)
            t = getHoverTransparency();
        else {
            t = getTransparency();
        }
        Graphics2D copy = (Graphics2D) g.create();
        copy.setComposite(AlphaComposite.getInstance(3, t));
        return copy;
    }

    public Graphics cleanup(Graphics g) {
        g.dispose();
        return g;
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
        if (e.getComponent() == this.parent) {
            this.hovering = true;
            if (this.repaint)
                this.parent.repaint();
        }
    }

    public void mouseExited(MouseEvent e) {
        if (e.getComponent() == this.parent) {
            this.hovering = false;
            if (this.repaint)
                this.parent.repaint();
        }
    }
}