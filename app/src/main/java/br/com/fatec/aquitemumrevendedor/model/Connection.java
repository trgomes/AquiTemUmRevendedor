package br.com.fatec.aquitemumrevendedor.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by User on 30/03/2017.
 */

public class Connection {

    private final String USER_AGENT = "Mozilla/5.0";


    // HTTP GET request
    public List<Revendedor> sendGet() throws Exception {

//        String url = "https://api.myjson.com/bins/cm2pf";
        String url = "https://api.myjson.com/bins/1cps4v";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONObject ob = new JSONObject(response.toString());

        List<Revendedor> found = findAllItems(ob.getJSONArray("Revendedores"));

        return found;
    }

    public List<Revendedor> findAllItems(JSONArray response) throws JSONException {

        List<Revendedor> found = new LinkedList<Revendedor>();


        for (int i = 0; i < response.length(); i++) {
            JSONObject obj = response.getJSONObject(i);
            ArrayList<String> revenda = new ArrayList<>();

            //Monta o array de revandas por vendedors
            if(obj.getJSONArray("revenda").length() > 0){

                for(int x = 0; x < obj.getJSONArray("revenda").length(); x++){
                    revenda.add(obj.getJSONArray("revenda").getString(x));
                }
            }

            found.add(new Revendedor(obj.getLong("id"), obj.getString("nome"), obj.getDouble("latitude"), obj.getDouble("longitude"), revenda));

        }

        return found;
    }
}
