package com.example.yutengfei.android_template.Utility;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;



public class ARcamearActivity extends Activity {
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private static final int CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE = 200;
    private static final int CAPTURE_ALBUM_ACTIVITY_REQUEST_CODE = 300;

    private Uri fileUri;
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;
    public static final int MEDIA_TYPE_ALBUM = 3;

    public  static final  String RESULT = "RESULT";
    public  static final  String ACTION = "ACTION";



    private static final String TAG="ARcamear";


    private int mKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
        this.mKey = getIntent().getIntExtra(AppConstant.REQUEST_CODE,0);
        this.switchKey();

    }

    private void switchKey() {

        switch (this.mKey) {
            case MEDIA_TYPE_ALBUM:
                /*Take album*/
                Intent intentAlbum = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intentAlbum.setType("image/*");
                startActivityForResult(intentAlbum.createChooser(intentAlbum, "Select File"), CAPTURE_ALBUM_ACTIVITY_REQUEST_CODE);
                break;

            case MEDIA_TYPE_IMAGE:
                /*Take photo*/
                // create Intent to take a picture and return control to the calling application
                Intent intentPhoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                this.fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE); // create a file to save the image
                intentPhoto.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name
                // start the image capture Intent
                startActivityForResult(intentPhoto, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
                break;

            default:
                Log.d(TAG, "Default");
                finish();
                break;
        }
    }


    /** Create a file Uri for saving an image or video */
    private  Uri getOutputMediaFileUri(int type){
        return Uri.fromFile(getOutputMediaFile(type));
    }

    /** Create a File for saving an image or video */
    private  File getOutputMediaFile(int type){
        Log.d(TAG,"getOutputMediaFile()");
        File mediaStorageDir = new File(getExternalFilesDir(
                Environment.DIRECTORY_PICTURES), "MyCameraApp");
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.
        //   File mediaStorageDir = new File("/ArDir");
        // Create the storage directory if it does not exist
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d(TAG, "failed to create directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE){
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_"+ timeStamp + ".jpg");
        } else if(type == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "VID_"+ timeStamp + ".mp4");
        } else {
            return null;
        }

        return mediaFile;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode != RESULT_OK){
            Log.d(TAG,"Result code is not OK");
            setResult(Activity.RESULT_CANCELED,null);
            finish();
        }

        if( requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            Intent intent = new Intent();
            intent.setData(this.fileUri);
            setResult(Activity.RESULT_OK, intent);
            finish();
        }

        if( requestCode == CAPTURE_ALBUM_ACTIVITY_REQUEST_CODE){
            setResult(Activity.RESULT_OK,data);
            finish();
        }
    }




}