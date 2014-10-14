package net.wesleynascimento.twpt.frames;

import net.wesleynascimento.twpt.decorators.FrameDecorator;
import net.wesleynascimento.twpt.components.TWButton;

import java.awt.event.ActionEvent;

/**
 * Created by Wesley on 30/08/2014.
 */
public class TWPTFrame extends FrameDecorator {

    public TWPTFrame(){
        super("Tribal Wars Pro Tools", 1024, 768, true);
    }

    @Override
    public void createComponents() {
        TWButton selectWorldButton = new TWButton("Selecionar Mundo", this, "open_select_world_frame");
        selectWorldButton.setBounds(10, ySpacing + 10, 110, 30);

        TWButton about = new TWButton("Sobre", this, "open_about_framw");
        about.setBounds(110 + 20, ySpacing + 10, 110, 30);

        container.add( selectWorldButton );
        container.add( about );
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        super.actionPerformed( event );
        switch ( event.getActionCommand() ){
            case "open_select_world_frame":
                new WorldSelectionFrame().setVisible( true );
                break;
        }
    }
}
