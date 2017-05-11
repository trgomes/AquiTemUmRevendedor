package br.com.fatec.aquitemumrevendedor.model;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

/**
 * Created by User on 27/04/2017.
 */

public class GPS implements LocationListener{

    private static final String TAG = "Localização>>>>>";

    private GoogleMap map;
    private List<Marker> otherMarkers;
//    private Calculation calc = new Calculation();

    public GPS(GoogleMap map){

        this.map = map;
//        this.otherMarkers = markers;
    }

    @Override
    public void onLocationChanged(Location location) {

        Log.i(TAG,"latitude => "+ location.getLatitude() +" \nLongitude =>"+location.getLongitude());

        Marker m = new Marker(location.getLatitude(), location.getLongitude(), "");
//        Double distance = calc.CalculationByDistance(new LatLng(location.getLatitude(), location.getLongitude()), new LatLng(this.otherMarkers.get(0).getLat(), this.otherMarkers.get(0).getLon()));
//        Integer km = distance.intValue();



        LatLng local = new LatLng(location.getLatitude(), location.getLongitude());
        map.addMarker(new MarkerOptions().position(new LatLng(m.getLat(), m.getLon())).title("I am here!"));
        map.moveCamera(CameraUpdateFactory.newLatLng(local));

    }



}
