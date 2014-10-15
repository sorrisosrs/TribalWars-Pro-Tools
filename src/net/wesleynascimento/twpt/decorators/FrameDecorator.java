package net.wesleynascimento.twpt.decorators;

import net.wesleynascimento.twpt.components.IconButton;
import net.wesleynascimento.twpt.components.TWLabel;
import net.wesleynascimento.twpt.enums.Colors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Wesley on 30/08/2014.
 *
 * Decorator que indica os principais padroes para todos os filhos de Frames
 */
public abstract class FrameDecorator extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

    protected static FrameDecorator currentFrame;

    protected int ySpacing = 20; //All components must start after
    protected int yMouse = 0, xMouse = 0;
    protected boolean isClosable;

    protected Container container;

    //Setup all default style for frames
    public FrameDecorator(String frameTitle, int width, int height, boolean isClosable){
        super(frameTitle);
        this.setResizable( false ); //Never a frame ill be resizable!
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.isClosable = isClosable;

        container = getContentPane();
        container.setLayout(null);
        container.setBackground( Colors.BACKGROUND_DARK.toColor() );

        JPanel topPanel = new JPanel();
        topPanel.setBounds(0, 0, width, ySpacing);
        topPanel.setBackground( Colors.BACKGROUND_WHITE.toColor() );


        if( isClosable ){
            IconButton close = new IconButton("close.png");
            close.setBounds(width - 37, 0, 37, ySpacing);
            close.setActionCommand("close");
            close.addActionListener(this);

            IconButton minimize = new IconButton("minimize.png");
            minimize.setBounds(width - 37 - 37  - 2, 0, 37, ySpacing);
            minimize.setActionCommand("minimize");
            minimize.addActionListener( this );

            TWLabel title = new TWLabel( frameTitle, 12);
            title.setBounds(0, 0, width, ySpacing);
            title.setForeground(Color.BLACK);

            container.add( close );
            container.add( minimize );
            container.add( title );
            container.add( topPanel );
        } else {
            ySpacing = 0;
        }

        setSize(width, height);
        createComponents();
        addMouseListener(this);
        addMouseMotionListener(this);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public abstract void createComponents();

    @Override
    public void setVisible(boolean status){
        if( status ) {
            super.setVisible( true );
            if( currentFrame != null){
                currentFrame.setVisible( false );
            }
            currentFrame = this;
        }
    }

    public static FrameDecorator getCurrentFrame(){
        return currentFrame;
    }

    /*
	 * IMPLEMENTED METHODS
	 */
    @Override
    public void mouseDragged(MouseEvent e) {
        setLocation(e.getXOnScreen() - xMouse, e.getYOnScreen()	- yMouse);
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent event) {
    }

    @Override
    public void mouseExited(MouseEvent event) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        xMouse = e.getX();
        yMouse = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch ( event.getActionCommand() ){
            case "close":
                System.exit( -1 );
                break;
            case "minimize":
                setState( 1 );
                break;
        }

    }
}
