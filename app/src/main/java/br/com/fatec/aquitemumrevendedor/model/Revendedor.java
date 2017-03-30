package br.com.fatec.aquitemumrevendedor.model;

import java.util.ArrayList;

/**
 * Created by User on 30/03/2017.
 */

public class Revendedor {

    String nome;
    double latitude;
    double longitude;
    ArrayList<String> revendas;



    public Revendedor(String nome, double latitude, double longitude, ArrayList<String> jsonArray) {
        super();
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
        this.revendas = jsonArray;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public ArrayList<String> getRevendas() {
        return revendas;
    }

    public void setRevendas(ArrayList<String> revendas) {
        this.revendas = revendas;
    }

    public String toString(){
        String str = "Revendedor:"+nome +" Latitude:"+ latitude +" Longitude:"+longitude+" Revendas:"+revendas ;

        return str;
    }
}
