package net.wesleynascimento.twpt.beans;

import com.google.gson.Gson;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wesley Nascimento on 14/10/2014.
 */
public class World {
    private String name;
    private double speed;
    private double unitSpeed;
    private int fake_limit;
    private int coin_wood;
    private int coin_stone;
    private int coin_iron;
    private boolean church;

    private List<Unit> units = new ArrayList<Unit>();

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return new Gson().toJson( this );
    }
}
