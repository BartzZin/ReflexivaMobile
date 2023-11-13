package com.lucaslara.reflucaslara

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class Mapa : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
    override fun onMapReady(googleMap: GoogleMap) {
       mMap = googleMap

        // Add a marker in Sydney and move the camera
        val beltrao = LatLng(-26.0862373,-53.0508969)
        mMap.addMarker(MarkerOptions()
            .position(beltrao)
            .title("Francisco Beltrão"))
        val zoomLevel = 13.0f

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(beltrao, zoomLevel))
    }

}
