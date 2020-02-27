package com.example.livetraining;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class ExternalIntents extends AppCompatActivity{

    static final int REQUEST_IMAGE_CAPTURE = 1;

   public void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }


 /*   public Intent GetCameraIntent()
    {
        Intent cameraIntent = new Intent("android.media.action.IMAGE_CAPTURE");
        return cameraIntent;
    }
    */
}
