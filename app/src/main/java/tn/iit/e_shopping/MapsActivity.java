package tn.iit.e_shopping;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import tn.iit.e_shopping.Activity.AjouterProduit;
import tn.iit.e_shopping.Activity.Inscription;
import tn.iit.e_shopping.Activity.ListesProduit;
import tn.iit.e_shopping.Activity.Login;
import tn.iit.e_shopping.database.DataBaseHelper;

public class MapsActivity extends ActionBarActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.man_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.login:
                Intent  inte=new Intent(getApplicationContext(), Login.class);
                startActivity(inte);
                return true;
            case R.id.inscription:
                Intent  in=new Intent(getApplicationContext(), Inscription.class);
                startActivity(in);
                return true;
            case R.id.liste:
                Intent  iin=new Intent(getApplicationContext(), ListesProduit.class);
                startActivity(iin);
                return true;
            case R.id.ajouter_produit:
                Intent  iit=new Intent(getApplicationContext(), AjouterProduit.class);
                startActivity(iit);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng sfax = new LatLng(34.738135, 10.760847);
        LatLng monoprix = new LatLng(34.739935, 10.760247);
        LatLng carrefour = new LatLng(34.738535, 10.760347);
        LatLng magasin = new LatLng(38.738235, 10.760947);
        mMap.addMarker(new MarkerOptions().position(monoprix).title("monoprix "));
        mMap.addMarker(new MarkerOptions().position(carrefour).title("carrefour market "));
        mMap.addMarker(new MarkerOptions().position(magasin).title("magasin general "));
        mMap.addMarker(new MarkerOptions().position(sfax).title("mon position"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sfax));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(magasin));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(carrefour));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(monoprix));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);
    }
}
