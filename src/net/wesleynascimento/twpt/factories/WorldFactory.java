package net.wesleynascimento.twpt.factories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.wesleynascimento.twpt.beans.World;
import org.json.JSONException;
import org.json.JSONML;
import org.json.JSONObject;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by Wesley Nascimento on 14/10/2014.
 */
public class WorldFactory {

    public URL getWorldXmlURL(String worldName, String server) throws MalformedURLException {
        StringBuilder builder = new StringBuilder();
        builder.append("http://").append( worldName ).append(".").append(server).append("/interface.php?func=get_config");

        return new URL( builder.toString() );
    }

    /**
     * Convert a world object to JSONObject
     * @param world
     * @return
     */
    public JSONObject getWorldJSON( World world ){
        Field fields[] = world.getClass().getDeclaredFields();
        JSONObject json = new JSONObject();
        try {
            for( Field field : fields){
                    json.put( field.getName(), field.get( world ));
            }
        } catch (IllegalAccessException e) {
            //Do nothing, because GSON will complate this field will a default type value
        }
        return json;
    }

    public World getWorldFromJSON(JSONObject json){
        Gson gson = new GsonBuilder().create();

        World world = gson.fromJson( json.toString(), World.class );
        return world;
    }

    /**
     * Convert a remote XML to a JSONObject
     * @param url
     * @return
     * @throws IOException
     * @throws JSONException
     */
    public JSONObject getJSONFromXML(URL url) throws IOException, JSONException {
        return JSONML.toJSONObject( readRemoteBytes( url ) );
    }

    /**
     * Read a remote file, and return a String
     * @param url
     * @return
     */
    private String readRemoteBytes(URL url) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        int cp;
        while ((cp = reader.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    /**
     * Convert a remote XML to world object
     * @param url
     * @return
     */
    public World getWorldFromXML(URL url){


        return null;
    }
}
