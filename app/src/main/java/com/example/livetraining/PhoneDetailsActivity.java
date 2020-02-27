package com.example.livetraining;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.location.LocationManager;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Date;

import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class PhoneDetailsActivity extends AppCompatActivity {


    TelephonyManager phoneMgr;
    LocationManager locationManager;
    MyLocationListener locationListener;
    TextView mobileIdTextView;
    TextView mobileNumberTextView;
    TextView mobileGPSTextView;
    TextView mobileTimeTextView;
    TextView mobileIpTextView;
    TextView macAddressTextView;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReferenceCurrent;
    DatabaseReference databaseReferenceHistory;
    DatabaseAPI firebase;

  //  @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_details);

        phoneMgr = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        locationListener = new MyLocationListener();
        try {
            locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER, 1000, 0, locationListener);
            locationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER, 1000, 0, locationListener);
        }
        catch(SecurityException e)
        {
            System.out.println("SecurityException " + e);
        }

        InitializeTextViews();
        UpdateTextViewsWithPhoneDetails();

       // UpdateNonEventData();

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReferenceCurrent = firebaseDatabase.getReference().child("Current");
        databaseReferenceHistory = firebaseDatabase.getReference().child("History");
        //firebase = new DatabaseAPI(firebaseDatabase, databaseReferenceCurrent);
    }

    void InitializeTextViews()
    {
       mobileIdTextView =  findViewById(R.id.mobileIdValueTextView);
       mobileNumberTextView = findViewById(R.id.mobileNumberValueTextView);
       mobileGPSTextView = findViewById(R.id.mobileGPSValueTextView);
       mobileTimeTextView = findViewById(R.id.mobileTimeValueTextView);
       mobileIpTextView =  findViewById(R.id.mobileIpValueTextView);
       macAddressTextView =  findViewById(R.id.macAddressValueTextView);
    }

    void UpdateTextViewsWithPhoneDetails()
    {
        mobileIdTextView.setText(GetDeviceId());
        mobileNumberTextView.setText(GetPhoneNumber());
        mobileTimeTextView.setText(GetCurrentTime());
    }

    String GetDeviceId() {
        try
        {
            String tmDevice = "" + phoneMgr.getDeviceId();
     //       String tmSerial = "" + phoneMgr.getSimSerialNumber();
       //     String androidId = "" + android.provider.Settings.Secure.getString(getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);

        //    UUID deviceUuid = new UUID(androidId.hashCode(), ((long) tmDevice.hashCode() << 32) | tmSerial.hashCode());
        //    String deviceId = deviceUuid.toString();
            return tmDevice;
        }
        catch(SecurityException e)
        {
            System.out.println("SecurityException " + e);
        }
        return null;
    }

    String GetPhoneNumber() {
        try
        {
            String phoneNumber = phoneMgr.getLine1Number();
            return phoneNumber;
        }
        catch(SecurityException e)
        {
            System.out.println("SecurityException " + e);
        }
        return null;
    }

    String GetCurrentTime()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
        String currentDateandTime = sdf.format(new Date());
        return currentDateandTime;
    }

    void SetLatestLocation()
    {
        mobileGPSTextView.setText(locationListener.GetLatestLocation());
    }

    public void SaveToFirebase(View view) {
        FireData fireData = new FireData();
        fireData.setDamage("shaby");
        fireData.setWeaponName("M16");
        fireData.setWhoFired("player 1");
        fireData.setWhoFire("player 2");

    //    firebase.SendObjectToDatabase(fireData);
     //   databaseReferenceHistory.push().setValue(fireData);
        String key = databaseReferenceHistory.push().getKey();
        databaseReferenceCurrent.child(fireData.getWhoFired()).setValue(fireData);
    }
}
