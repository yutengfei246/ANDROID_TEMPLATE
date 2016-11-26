package com.example.yutengfei.android_template.Utility;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

/**
 * Created by yutengfei on 27/08/16.
 */
public class ListenerUtility {

    public static final int NAVIGATION_PHOTO = 10;
    public static final int NAVIGATION_ALBUM = 20;

    private Activity mActivity;

    public ListenerUtility(Activity activity){
        this.mActivity = activity;
    }


    public void setListener(View view, int type){
        this.swichingType(type,view);
    }

    private void swichingType(int type, View view) {
        switch (type){
            case NAVIGATION_PHOTO:
                this.navigationTakeImageListener(view);
                break;
            case NAVIGATION_ALBUM:
                this.navigationTakeAlbumListener(view);
                break;
            default:
                break;
        }

    }

    private void navigationTakeAlbumListener(View view) {
        view.setOnClickListener(this.navigationTakeAlbumListener());
    }

    private View.OnClickListener navigationTakeAlbumListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListenerUtility.this.mActivity,ARcamearActivity.class);
                ListenerUtility.this.mActivity.startActivityForResult(intent, ARcamearActivity.MEDIA_TYPE_ALBUM);
            }
        };
    }

    private void navigationTakeImageListener(View view){
        view.setOnClickListener(this.navigationTakeImageListener());
    }

    private View.OnClickListener navigationTakeImageListener(){
        return new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListenerUtility.this.mActivity,ARcamearActivity.class);
                ListenerUtility.this.mActivity.startActivityForResult(intent,ARcamearActivity.MEDIA_TYPE_IMAGE);
            }
        };
    }

}
