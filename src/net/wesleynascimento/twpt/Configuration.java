package net.wesleynascimento.twpt;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONFactory;
import org.json.JSONObject;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

/**
 * Classe responsavel por manipular as configurações baseadas em JSON
 *
 * @author Wesley Nascimento
 * @date 08/08/2014
 */
public class Configuration {
    private static final String configString = "config.json";

    private JSONObject config;
    private File configFile;

    public Configuration() {
        configFile = new File(new File(Configuration.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile(), configString);
        loadConfig();
    }

    public void saveConfig() {
        try {
            new JSONFactory().createJSONFile(config, configFile);
        } catch (IOException e) {
            throw new RuntimeException( e );
        }
    }

    private void loadConfig() {
        try {
            JSONFactory factory = new JSONFactory();
            if (!configFile.exists()) {
                factory.createJSONFile(new JSONObject("{}"), configFile);
            }
            config = factory.getJSON(configFile);
        } catch (IOException e) {
            config = new JSONObject("{}");
        }
    }

    public JSONObject getConfig() {
        return config;
    }

    /**
     * Getter simples de valores.
     *
     * @param chave - Chave do subobjeto
     * @return Objeto - Um objeto java
     */
    public Object getConfig(String chave) {
        try {
            return config.getJSONObject(chave);
        } catch (JSONException e) {
        }
        return null;
    }

    /**
     * Retorna uma String de configuração
     *
     * @param chave - A chave do subobjeto
     * @param def   - Valor padrão, caso não tenha nada salvo!
     * @return String -
     */
    public String getConfig(String chave, String def) {
        try {
            return config.getString(chave);
        }
        //Retorna o padrão, caso não encontre o valor no arquivo
        catch (JSONException e) {
            return def;
        }
    }

    public double getConfig(String chave, double def) {
        try {
            return config.getDouble(chave);
        } catch (JSONException e) {
            return def;
        }
    }

    public int getConfig(String chave, int def) {
        try {
            return config.getInt(chave);
        } catch (JSONException e) {
            return def;
        }
    }

    public boolean getConfig(String chave, boolean def) {
        try {
            return config.getBoolean(chave);
        } catch (JSONException e) {
            return def;
        }
    }

    public JSONObject getConfig(String chave, JSONObject def) {
        try {
            return config.getJSONObject(chave);
        } catch (JSONException e) {
            return def;
        }
    }

    public JSONArray getConfig(String chave, JSONArray def) {
        try {
            return config.getJSONArray(chave);
        } catch (JSONException e) {
            return def;
        }
    }

    /**
     * Setter unico para valores
     *
     * @param chave - Chave do keyset
     * @param valor - Objeto qualquer
     */
    public void setConfig(String chave, Object valor) {
        try {
            config.put(chave, valor);
        }
        //Faz nada se der erro :(
        catch (JSONException e) {

        }
        //salva o arquivo :)
        finally {
            saveConfig();
        }
    }
}

