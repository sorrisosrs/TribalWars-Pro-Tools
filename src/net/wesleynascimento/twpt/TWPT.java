package net.wesleynascimento.twpt;

import net.wesleynascimento.twpt.decorators.FrameDecorator;
import net.wesleynascimento.twpt.frames.TWPTFrame;

/**
 * Created by Wesley on 30/08/2014.
 */
public class TWPT {

    private boolean debug = false;

    public static void main(String[] args){
        new TWPT().start();
    }

    public void start(){
        FrameDecorator frame = new TWPTFrame();
        frame.setVisible(true);
    }
}
