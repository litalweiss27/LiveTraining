package com.example.livetraining;
import android.location.LocationListener;
import android.location.Location;
import android.os.Bundle;

public class MyLocationListener implements LocationListener {

    String longitude;
    String latitude;
   // UpdateTextViewWithCurrentLocation updateTextViewWithCurrentLocation;

    @Override
    public void onLocationChanged(Location loc)
    {

   /*     editLocation.setText("");
        pb.setVisibility(View.INVISIBLE);
        Toast.makeText(
                getBaseContext(),
                "Location changed: Lat: " + loc.getLatitude() + " Lng: "
                        + loc.getLongitude(), Toast.LENGTH_SHORT).show();*/
        longitude = "Longitude: " + loc.getLongitude();
        latitude = "Latitude: " + loc.getLatitude();

        /*------- To get city name from coordinates -------- */
   /*     String cityName = null;
        Geocoder gcd = new Geocoder(getBaseContext(), Locale.getDefault());
        List<Address> addresses;
        try {
            addresses = gcd.getFromLocation(loc.getLatitude(),
                    loc.getLongitude(), 1);
            if (addresses.size() > 0) {
                System.out.println(addresses.get(0).getLocality());
                cityName = addresses.get(0).getLocality();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        String s = longitude + "\n" + latitude + "\n\nMy Current City is: "
                + cityName;
        editLocation.setText(s);*/
    //    Log.v(TAG, "IN ON LOCATION CHANGE, lat=" + latitude + ", lon=" + longitude);
      //  UpdateTextViewWithCurrentLocation(GetLatestLocation());
    }

    @Override
    public void onProviderDisabled(String provider) {}

    @Override
    public void onProviderEnabled(String provider) {}

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {}

    public String GetLatestLocation()
    {
        if (longitude != null && latitude != null)
            return longitude + " ; " + latitude;
        return null;
    }
}
