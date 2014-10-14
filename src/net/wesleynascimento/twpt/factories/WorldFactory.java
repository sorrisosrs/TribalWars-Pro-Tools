package net.wesleynascimento.twpt.factories;

import net.wesleynascimento.twpt.beans.World;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by Wesley Nascimento on 14/10/2014.
 */
public class WorldFactory {

    public World getWorldByName(String worldName, String server) throws MalformedURLException {
        StringBuilder builder = new StringBuilder();
        builder.append("http://").append( worldName ).append(".").append(server).append("/interface.php?func=get_config");

        URL url = new URL( builder.toString() );
        //url.openStream();
        return null;
    }

    public World getWorldFromJSON(JSONObject json){
        return null;
    }
}
