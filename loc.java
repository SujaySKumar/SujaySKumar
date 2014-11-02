package com.example.smstest;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

public class loc extends MainActivity implements LocationListener  {

	

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		String str = "Latitude: "+location.getLatitude()+"Longitude: "+location.getLongitude();
				  
				                Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		Toast.makeText(getBaseContext(), "Gps turned off ", Toast.LENGTH_LONG).show();
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		Toast.makeText(getBaseContext(), "Gps turned on ", Toast.LENGTH_LONG).show();
		
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}
	

}
