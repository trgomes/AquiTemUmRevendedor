package br.com.fatec.aquitemumrevendedor;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import java.util.List;
import java.util.concurrent.TimeUnit;

import br.com.fatec.aquitemumrevendedor.model.GPS;
import br.com.fatec.aquitemumrevendedor.model.Revendedor;


import static br.com.fatec.aquitemumrevendedor.ActPrincipal.bd;


public class MapsFragment extends SupportMapFragment implements OnMapReadyCallback{

    private GoogleMap mMap;


    private double latitude;
    private double longitude;

    public MapsFragment(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        //Define o zoom minimo
        mMap.setMinZoomPreference(13);
        //Habilita controle de zoom
        mMap.getUiSettings().setZoomControlsEnabled(true);

        mMap.setMyLocationEnabled(true);

        List<Revendedor> revendedores = bd.getDados();

        for(Revendedor r : revendedores){
//            Log.i("RETORNO => ", r.getLatitude() + " " + r.getLongitude());

            //Cria marcadores
            LatLng local = new LatLng(r.getLatitude(), r.getLongitude());
            MarkerOptions marker = new MarkerOptions();
            marker.position(local);
            marker.title(r.getNome());
            marker.snippet(String.valueOf(r.getRevendas()));
            mMap.addMarker(marker);
            //Define a cor do marker
//            mMap.addMarker(marker).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(local));
        }

        // Posição da posição atual do usuário
        LatLng local = new LatLng(this.latitude, this.longitude);
        //Define o foco da camera no local atual ao abrir o programa
        mMap.moveCamera(CameraUpdateFactory.newLatLng(local));

    }


}
