package net.wesleynascimento.twpt.components;

import net.wesleynascimento.twpt.factories.FontFactory;
import net.wesleynascimento.twpt.enums.Colors;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;

/**
 * Created by Wesley Nascimento on 13/10/2014.
 */
public class TWButton extends JButton implements MouseListener {
    /**
     * Cores em degrade do botão "ataque" localizado na praça,
     *
     * #947A62 0%, #7B5C3D 22%, #6C4824 30%, #6C4824 100%
     *
     */

    protected float[] fractions = {0.0f, 0.22f, 0.3f, 1.0f};
    protected Color[] colors = {Colors.hex2Color("#947A62"), Colors.hex2Color("#7B5C3D"), Colors.hex2Color("#6C4824"), Colors.hex2Color("#6C4824")};

    protected LinearGradientPaint paintColor = new LinearGradientPaint(new Point2D.Double(0, 0), new Point2D.Double(0, 100), fractions, colors);

    protected Color backgroundUnable = Color.lightGray;
    protected Color backgroundPressed = Colors.BUTTON_BACKGROUND_PRESSED.toColor();

    protected Color foregroundNormal = Color.WHITE;
    protected Color foregroundUnable = Color.darkGray;
    protected Color foregroundOver = null;


    protected Color borderNormal = Color.black;
    protected Color borderUnable = Color.darkGray;

    private boolean isOver = false;
    private boolean isPressed = false;

    public TWButton() {
        setBackground(new Color(220, 220, 220));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 0);
        setBorder(border);
        addMouseListener(this);
        setContentAreaFilled(false);
    }

    public TWButton(String label) {

        this();
        setText(label);

        /*
        font-family: Verdana,Arial;
        font-size: 12px;
        font-weight: bold;
         */
        Font font = new FontFactory().getDefaultFont().deriveFont(Font.BOLD, 12);
        this.setFont( font );
    }

    public TWButton(String label, ActionListener al, String command){
        this(label);
        this.addActionListener( al );
        this.setActionCommand(command);
    }

    public TWButton(Icon icon) {

        this();
        setIcon(icon);

    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //Se estiver desativo
        if( !isEnabled() ){
            g2d.setColor( backgroundUnable );
        }
        //Se estiver sendo pressionado
        else if (isPressed && backgroundPressed != null){
            g2d.setColor( backgroundPressed );
        }
        //Se estiver normal!
        else {
            g2d.setPaint(paintColor);
        }
        g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 5, 5);

        //Desenha a borda do botão
        if (!isEnabled()) {
            g2d.setColor(borderUnable);
        } else {
            g2d.setColor(borderNormal);
        }
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 5, 5);

        //Se o mouse estiver em cima
        if (isOver || isDefaultButton()) {
            g2d.setColor(borderUnable);
            g2d.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, 5, 5);
        }

        //Escreve o texto centralizado
        if(!isEnabled()) {
            g2d.setColor( foregroundUnable );
        } else if (isOver && foregroundOver != null) {
            g2d.setColor(foregroundOver);
        } else {
            g2d.setColor( foregroundNormal );
        }

        Font f = getFont();
        if (f != null) {
            FontMetrics fm = getFontMetrics(getFont());
            g2d.drawString( getText(), getWidth() / 2 - fm.stringWidth( getText()) / 2, getHeight() / 2 + (fm.getMaxAscent() - fm.getMaxDescent()) / 2);
        }

        if (getIcon() != null) {
            getIcon().paintIcon(this, g2d, getWidth() / 2 - getIcon().getIconWidth()/ 2,
                    getHeight() / 2 - getIcon().getIconHeight()/ 2);
        }
    }

    /**
     * O tamanho preferido do botão.
     */
    @Override
    public Dimension getPreferredSize() {
        // Permite a edição de tamanho apenas para botões com ícones
        if (getIcon() != null)
            return super.getPreferredSize();

        // Caso tenha texto maior do que o tamanho padrão, ajusta com 10 de cada lado
        if (super.getPreferredSize().width > 60)
            return new Dimension(super.getPreferredSize().width + 20, 25);
        else
            return new Dimension(80, 25);

    }

    /**
     * O tamanho minimo para o botão,
     * Previne que o botão fique apertado...
     */
    @Override
    public Dimension getMinimumSize() {
        // Permite a edição de tamanho apenas para botões com ícones
        if (getIcon() == null)
            return new Dimension(80, 25);
        else
            return super.getMinimumSize();
    }

    @Override
    public void doClick() {
        isPressed = true;
        super.doClick();
    }

    public void mouseClicked(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {
        isPressed = true;
        isOver = false;
    }

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {
        if (!isPressed)
            isOver = true;
        isPressed = false;
    }

    public void mouseExited(MouseEvent e) {
        isOver = false;
        isPressed = false;
    }
}
