package net.wesleynascimento.twpt.beans;

import org.json.JSONObject;

/**
 * Created by Wesley Nascimento on 14/10/2014.
 */
public class World {
    public String name;
    public double speed;
    public double unitSpeed;
    public int fake_limit;
    public int coin_wood;
    public int coin_stone;
    public int coin_iron;
    public boolean church;

    public void setName(String name){
        this.name = name;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Speed: ").append( speed ).append("\n");
        sb.append("Name: ").append( name).append("\n");
        return sb.toString();
    }
}
