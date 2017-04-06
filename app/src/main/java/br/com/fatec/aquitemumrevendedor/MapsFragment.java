package br.com.fatec.aquitemumrevendedor;

import android.content.Context;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import java.util.List;

import br.com.fatec.aquitemumrevendedor.model.Revendedor;

import static android.content.ContentValues.TAG;
import static br.com.fatec.aquitemumrevendedor.ActPrincipal.bd;

public class MapsFragment extends SupportMapFragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LocationManager locationManager;

    private static final String TAG = "MapsFragment";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        try {
            locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
            Criteria criteria = new Criteria();

            String provider = locationManager.getBestProvider(criteria, true);

            mMap = googleMap;
            //Define o zoom minimo
            mMap.setMinZoomPreference(14);
            //Habilita controle de zoom
            mMap.getUiSettings().setZoomControlsEnabled(true);

            mMap.setMyLocationEnabled(true);


        }
        catch (SecurityException ex){
            Log.i(TAG, "Error", ex);
        }

        List<Revendedor> revendedores = bd.getDados();

        for(Revendedor r : revendedores){
//            Log.i("RETORNO => ", r.getLatitude() + " " + r.getLongitude());

            //Cria marcador
            LatLng local = new LatLng(r.getLatitude(), r.getLongitude());
            MarkerOptions marker = new MarkerOptions();
            marker.position(local);
            marker.title(r.getNome());
            marker.snippet(String.valueOf(r.getRevendas()));
            mMap.addMarker(marker);
            //Define a cor do marker
//            mMap.addMarker(marker).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(local));
        }

    }
}
