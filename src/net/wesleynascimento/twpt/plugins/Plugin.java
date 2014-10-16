package net.wesleynascimento.twpt.plugins;

import net.wesleynascimento.twpt.interfaces.PanelPlugable;

import javax.swing.*;

/**
 * Created by Wesley Nascimento on 13/10/2014.
 */
public class Plugin implements PanelPlugable {

    private double version;
    private String name;
    private String description;

    public Plugin(String name, String description, double version){
        this.name = name;
        this.description = description;
        this.version = version;
    }

    /**
     * Must be Overrided by child plugins
     */
    public void onLoad(){
        System.out.println("Plugin " + name + " loaded!");
    }

    /**
     * Must be Overrided by child plugins
     */
    public void onUnload(){
        System.out.println("Plugin " + name + " unloaded!");
    }

    /**
     * Must be Overrided by child plugins to receive the APP plugin panel
     * @param panel
     */
    public void onPluginOpen(JPanel panel){

    }

    public String getTitle(){
        return name;
    }

    @Override
    public String getLineTwo() {
        return description;
    }

    @Override
    public String getLineThree() {
        return "Versão: " + version;
    }

    @Override
    public void onClick() {
        //Get the PluginPanel and execute child onPluginOpen
    }

}
