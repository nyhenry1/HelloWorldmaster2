package com.android.morehealth;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity {
 GoogleMap map;
 double latitude = 37.7484578;
 double longitude = -122.4347305;
 double latitude2 = 37.7815694;
 double longitude2 = -122.4402237;
 LatLng latlon = null;
 LatLng latlon2 = null;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
  // TODO Auto-generated method stub
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_map);
  latlon = new LatLng(latitude, longitude);
  latlon2 = new LatLng(latitude2, longitude2);
  
  setUpMapIfNeeded(); // Required to check the availability of Maps

 }

 @Override
 protected void onResume() {
  super.onResume();
  setUpMapIfNeeded();
 }

 private void setUpMapIfNeeded() {
  if (map == null) {
   /*
    * I avoid Crashing, if Google_Play_Services is not Updated or
    * Unavailable
    */
   map = ((SupportMapFragment) getSupportFragmentManager()
     .findFragmentById(R.id.map)).getMap();
   /*
    * To make sure map is loaded
    */
   if (map != null) {
    setUpMap();
   }
  }
 }

 private void setUpMap() {
  /*
   * Add a Marker Adding marker
   */
  map.addMarker(new MarkerOptions().position(latlon) 

  /*
   * Add Title when clicked on marker
   */
  .title("" +
  		"San Francisco General Hospital")
  /*
   * Add Snippet when clicked on marker
   */
  .snippet("Public Hospital"));

  /*
   * Add a Marker Adding marker
   */
  map.addMarker(new MarkerOptions().position(latlon2)

  /*
   * Add Title when clicked on marker
   */
  .title("" +
  		"San Francisco Kaiser Permamente")
  /*
   * Add Snippet when clicked on marker
   */
  .snippet("Private Hospital"));
  /*
   * NormalMapView
   */
  map.setMapType(GoogleMap.MAP_TYPE_NORMAL); // Normal MapView

  /*
   * Move Camera to Snippet Location
   */
  float zoom = 11;
  map.moveCamera(CameraUpdateFactory.newLatLngZoom(latlon, zoom)); // toPosition,
                   // ZoomLevel
 }

 @Override
 protected void onPause() {
  super.onPause();
 }

 @Override
 protected void onDestroy() {
  super.onDestroy();
 }

 @Override
 public void onLowMemory() {
  super.onLowMemory();
 }

 @Override
 public void onSaveInstanceState(Bundle outState) {
  super.onSaveInstanceState(outState);
 }
}