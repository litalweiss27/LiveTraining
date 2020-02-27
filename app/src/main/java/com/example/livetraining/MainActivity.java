package com.example.livetraining;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.view.ViewParent;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    ExternalIntents externalIntents;
    DatabaseAPI firebase;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("TEST");
       // firebase = new DatabaseAPI(firebaseDatabase, databaseReference);
     //   imageView = new imageView();
    }

    public void OpenCamera(View view) {
        dispatchTakePictureIntent();
  //      Intent cameraIntent = new Intent("android.media.action.IMAGE_CAPTURE");
       // Intent cameraIntent = externalIntents.GetCameraIntent();
    //    startActivity(cameraIntent);
    }
    public void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent("android.media.action.IMAGE_CAPTURE");
      // if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
      //  startActivity(takePictureIntent);
        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
     //   }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            //the app crash in this command
         //   imageView.setImageBitmap(imageBitmap);
        }
    }

    public void SaveToDatabase(View view)
    {
        String name = "Lital";
        String when = "9:00-10:00";
        FireData fireData = new FireData();
        fireData.setDamage("killed");
        fireData.setWeaponName("M16");
        fireData.setWhoFired("player 1");
        fireData.setWhoFire("player 2");
        //firebase.databaseReference.push().setValue(fireData);
        firebase.SendObjectToDatabase(fireData);
    }

    //events handling database changes
 /*   @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {}

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {}

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

    @Override
    public void onCancelled(DatabaseError databaseError) {}

  */
    /** Check if this device has a camera */
 /*   private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }
*/
}
