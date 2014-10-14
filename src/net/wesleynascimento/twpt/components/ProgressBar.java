package net.wesleynascimento.twpt.components;

import net.wesleynascimento.twpt.enums.Colors;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Wesley on 31/08/2014.
 */
public class ProgressBar extends JPanel {

    private double percentage = 1.0;

    public ProgressBar(){
        this.setOpaque( true );
    }

    @Override
    public void paint(Graphics g) {

        g.setColor(Colors.PROGRESSBAR.toColor());
        g.fillRect(0, getHeight() / 2 - 2, (int)(getWidth() * percentage) - 2, 4);

        g.setColor(Colors.PROGRESSBAR_BORDER.toColor());
        g.drawRect(0, getHeight() / 2 - 2, getWidth() - 2, 4);
    }

    public void reset(){
        this.percentage = 0.0;
    }

    public void changeProgress(double percentage){
        if( percentage <= 1.0 && percentage >= 0.0){
            this.percentage = percentage;
        }
    }

    public void changeProgress(int percentage){
        this.changeProgress( (double) (percentage / 100) );
    }
}
