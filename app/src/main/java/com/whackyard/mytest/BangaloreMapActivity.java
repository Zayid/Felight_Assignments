package com.whackyard.mytest;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class BangaloreMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private TextView mCurrentLocTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangalore_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mCurrentLocTxt = (TextView) findViewById(R.id.latlongLocation);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng felight = new LatLng(12.916528, 77.601339);
        mMap.addMarker(new MarkerOptions()
                .position(felight)
                .title("Felight Java & Testing Training Institute")
                .snippet("No.15, Adjacent To Jayadeva Hospital, 100 Feet Main Road, BTM, 2nd Stage")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.felight)));
        mMap.addCircle(new CircleOptions()
                .center(new LatLng(12.916528, 77.601339))
                .radius(20)
                .strokeColor(Color.GRAY)
                .fillColor(R.color.map_circle));

        LatLng myHome = new LatLng(12.903651, 77.621945);
        mMap.addMarker(new MarkerOptions()
                .position(myHome)
                .title("My Room")
                .snippet("3A, Savithri Sathana, Virat nagar, Bommanahallii")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.residence)));
        mMap.addCircle(new CircleOptions()
                .center(new LatLng(12.903651, 77.621945))
                .radius(20)
                .strokeColor(Color.GRAY)
                .fillColor(R.color.map_circle));

        mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(12.905330, 77.624829), new LatLng(12.905330, 77.620012), new LatLng(12.901837, 77.620012), new LatLng(12.901837, 77.624829))
                .strokeColor(Color.TRANSPARENT)
                .fillColor(R.color.colorPrimary)
        );

        mMap.moveCamera(CameraUpdateFactory.newLatLng(myHome));
    }

    @Override
    protected void onStart() {
        super.onStart();
        mCurrentLocTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(getBaseContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getBaseContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }
                mMap.setMyLocationEnabled(true);
                mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
                    @Override
                    public void onMyLocationChange(Location location) {
                        mMap.addMarker(new MarkerOptions().position(new LatLng(location.getLatitude(), location.getLongitude())).title("My Location"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(),location.getLongitude()),10));
                        mMap.setOnMyLocationChangeListener(null);
                        mCurrentLocTxt.setText(" Latitude : "+location.getLatitude()+"   Longitude : "+location.getLongitude());
                    }
                });
            }
        });
    }
}
