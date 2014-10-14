package net.wesleynascimento.twpt.plugins;

import javax.swing.*;

/**
 * Created by Wesley Nascimento on 13/10/2014.
 */
public abstract class Plugin {

    public abstract void onLoad();
    public abstract void onUnload();

    //Entrega um JPanel limpa para esse metodo.
    public abstract void onPluginOpen(JPanel panel);
}
