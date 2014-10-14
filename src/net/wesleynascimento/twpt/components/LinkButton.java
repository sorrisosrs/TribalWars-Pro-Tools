package net.wesleynascimento.twpt.components;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LinkButton extends JButton {
    private static final long serialVersionUID = 8415038817435411359L;
    private static final Color LINK_COLOR = Color.blue;
    private static final Border LINK_BORDER = BorderFactory.createEmptyBorder(0, 0, 1, 0);
    private static final Border HOVER_BORDER = BorderFactory.createMatteBorder(0, 0, 1, 0, LINK_COLOR);

    public LinkButton() {
        setupLink();
    }

    public LinkButton(Action a) {
        super(a);
        setupLink();
    }

    public LinkButton(Icon icon) {
        super(icon);
        setupLink();
    }

    public LinkButton(String text, Icon icon) {
        super(text, icon);
        setupLink();
    }

    public LinkButton(String text) {
        super(text);
        setupLink();
    }

    public void setupLink() {
        setBorder(LINK_BORDER);
        setForeground(LINK_COLOR);
        setCursor(Cursor.getPredefinedCursor(12));
        setFocusPainted(false);
        setRequestFocusEnabled(false);
        setContentAreaFilled(false);
        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                ((JComponent) e.getComponent()).setBorder(LinkButton.HOVER_BORDER);
            }

            public void mouseReleased(MouseEvent e) {
                ((JComponent) e.getComponent()).setBorder(LinkButton.LINK_BORDER);
            }

            public void mouseExited(MouseEvent e) {
                ((JComponent) e.getComponent()).setBorder(LinkButton.LINK_BORDER);
            }
        });
    }
}