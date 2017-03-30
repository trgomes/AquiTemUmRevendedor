package br.com.fatec.aquitemumrevendedor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;
import java.util.concurrent.ExecutionException;

import br.com.fatec.aquitemumrevendedor.model.Connection;
import br.com.fatec.aquitemumrevendedor.model.Consulta;
import br.com.fatec.aquitemumrevendedor.model.Revendedor;

public class MainActivity extends AppCompatActivity {

    private Connection con = new Connection();
    private static final String TAG = "Thiago";

    private List<Revendedor> revendedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Consulta c = new Consulta();

        List<Revendedor> resp = null;

        try {
            resp = c.execute().get();
            Log.i(TAG, String.valueOf(resp));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
