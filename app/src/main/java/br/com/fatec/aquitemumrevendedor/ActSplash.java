package br.com.fatec.aquitemumrevendedor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActSplash extends AppCompatActivity {

    //Variavel Global


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread timerThread = new Thread(){

            public void run(){
                try {
                    sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(ActSplash.this, ActPrincipal.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

//        BuscaDados bd = new BuscaDados();
//
//        List<Revendedor> resp = null;
//
//
//        try {
//            //            resp = bd.execute().get();
//            bd.execute().get();
//
//            //              bd.execute();
////            Log.i(TAG, String.valueOf(resp));
//            Log.i(TAG, String.valueOf(bd.getDados()));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

}
