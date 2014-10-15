package org.json;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;

/**
 * Created by Wesley on 02/09/2014.
 */
public class JSONFactory {
    /**
     * Read a string and return a json object or a throws
     *
     * @param string String path of JSON
     * @return JSONObject
     * @throws IOException
     */
    public JSONObject getJSON(String string) throws IOException {
        if (string.startsWith("http")) {
            return getJSON(new URL(string));
        } else {
            return getJSON(new File(string));
        }
    }

    /**
     * Read and return a JSON from file
     *
     * @param file File
     * @return JSONObject
     * @throws IOException
     * @throws JSONException
     */
    public JSONObject getJSON(File file) throws IOException, JSONException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int cp;
        while ((cp = reader.read()) != -1) {
            sb.append((char) cp);
        }
        return new JSONObject(sb.toString());
    }

    /**
     * Read and return a JSON from URL
     *
     * @param url URL
     * @return JSONObject
     * @throws IOException
     */
    public JSONObject getJSON(URL url) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        int cp;
        while ((cp = reader.read()) != -1) {
            sb.append((char) cp);
        }
        return new JSONObject(sb.toString());
    }

    /**
     * Save a JSON as file!
     *
     * @param json JSONObject
     * @param file File
     * @throws IOException
     */
    public void createJSONFile(JSONObject json, File file) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.append(json.toString(4));
        writer.flush();
        writer.close();
    }
}
