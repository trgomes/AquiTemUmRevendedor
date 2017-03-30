package br.com.fatec.aquitemumrevendedor.model;

import android.os.AsyncTask;

import java.util.List;

/**
 * Created by User on 30/03/2017.
 */

public class Consulta extends AsyncTask<Void, Void, List<Revendedor>> {


    @Override
    protected List<Revendedor> doInBackground(Void... params) {

        Connection con = new Connection();

        List<Revendedor> txt = null;
        try {
            txt = con.sendGet();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return txt;
    }
}