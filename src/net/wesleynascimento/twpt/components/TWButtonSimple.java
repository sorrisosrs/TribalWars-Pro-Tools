package net.wesleynascimento.twpt.components;

import net.wesleynascimento.twpt.enums.Colors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

/**
 * Created by Wesley Nascimento on 14/10/2014.
 */
public class TWButtonSimple extends TWButton {

    public TWButtonSimple() {
        super();
        this.foregroundNormal = Colors.hex2Color("#603000");
        this.borderNormal = Colors.hex2Color("#7d510f");
        this.foregroundOver = Colors.hex2Color("#e01f0f");
        this.backgroundPressed = Colors.hex2Color("#e8ddc2");

        float[] fractions = {0.0f, 0.22f, 1.0f};
        Color[] colors = {Colors.hex2Color("#FFFFFF"), Colors.hex2Color("#e3d5b3"), Colors.hex2Color("#e3d5b3")};

        this.paintColor = new LinearGradientPaint(new Point2D.Double(0, 0), new Point2D.Double(0, 100), fractions, colors);
    }

    public TWButtonSimple(String label) {
        this();
        setText(label);
    }

    public TWButtonSimple(String label, ActionListener al, String command) {
        this(label);
        addActionListener( al );
        setActionCommand( command );
    }

    public TWButtonSimple(Icon icon) {
        this();
        setIcon(icon);
    }
}
