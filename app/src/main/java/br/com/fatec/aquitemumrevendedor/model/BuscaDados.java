package br.com.fatec.aquitemumrevendedor.model;

import android.os.AsyncTask;

import java.util.List;

/**
 * Created by User on 30/03/2017.
 */

public class BuscaDados extends AsyncTask<Void, Void, List<Revendedor>> {

    private  List<Revendedor> dados;

    //Reto
    public List<Revendedor> getDados() {
        return dados;
    }

    @Override
    protected List<Revendedor> doInBackground(Void... params) {

        Connection con = new Connection();

        try {
            dados = con.sendGet();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dados;
    }



}