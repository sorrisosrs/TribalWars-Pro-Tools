package net.wesleynascimento.twpt.factories;

import net.wesleynascimento.twpt.Configuration;

/**
 * Created by Wesley Nascimento on 15/10/2014.
 */
public class ConfigFactory {

    private static Configuration config;

    public Configuration newConfig(){
        return new Configuration();
    }

    public Configuration getLoadedConfig(){
        if( config == null ){
            config = newConfig();
        }
        return config;
    }
}
