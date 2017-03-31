package br.com.fatec.aquitemumrevendedor.model;

import java.util.ArrayList;

/**
 * Created by User on 30/03/2017.
 */

public class Revendedor {

    private long id;
    private String nome;
    private double latitude;
    private double longitude;
    private ArrayList<String> revendas;



    public Revendedor(long id, String nome, double latitude, double longitude, ArrayList<String> revendas) {
        super();
        this.id = id;
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
        this.revendas = revendas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        String str = "ID: "+ this.id +
                " Revendedor:"+ this.nome +
                " Latitude:"+ this.latitude +
                " Longitude:"+ this.longitude +
                " Revendas:"+ this.revendas ;

        return str;
    }
}
