package net.wesleynascimento.twpt;

import net.wesleynascimento.twpt.beans.World;
import net.wesleynascimento.twpt.decorators.FrameDecorator;
import net.wesleynascimento.twpt.factories.WorldFactory;
import net.wesleynascimento.twpt.frames.TWPTFrame;
import net.wesleynascimento.twpt.frames.UpdateFrame;
import net.wesleynascimento.twpt.frames.WorldSelectionFrame;
import org.json.JSONObject;

/**
 * Created by Wesley on 30/08/2014.
 */
public class TWPT {

    private boolean debug = false;

    public static void main(String[] args){
        new TWPT().start();
    }

    public void start(){
        UpdateFrame frame = new UpdateFrame();
        frame.setVisible(true);
        frame.start();

    }
}
