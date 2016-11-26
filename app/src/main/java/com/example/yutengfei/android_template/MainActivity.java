package com.example.yutengfei.android_template;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.yutengfei.android_template.Initializer.MainActivityInilizer;
import com.example.yutengfei.android_template.Utility.AppConstant;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG="MainActiviy";

    private MainActivityInilizer mMainActivityInitializer; // hold the reference of Initializer for this MainActicity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        this.mMainActivityInitializer= new MainActivityInilizer(this);
        this.mMainActivityInitializer.initiate();

    }

    /* capture up home as selected */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(this.mMainActivityInitializer.getToggle().onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.navigation_item_1:
                Toast.makeText(MainActivity.this,"New ",Toast.LENGTH_LONG).show();
                Log.d(TAG,"1");
                Intent intent = new Intent(this,ProfileActivity.class);
                startActivity(intent);
                break;

            case R.id.navigation_item_2:
                Toast.makeText(MainActivity.this,"New ",Toast.LENGTH_LONG).show();
                Log.d(TAG,"1");
                break;

            case R.id.navigation_item_3:
                Toast.makeText(MainActivity.this,"New ",Toast.LENGTH_LONG).show();
                Log.d(TAG,"1");
                break;

            default:

                break;
        }

        if(this.mMainActivityInitializer.isDrawerOpen())
            this.mMainActivityInitializer.closeDrawer();

        return false;
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        intent.putExtra(AppConstant.REQUEST_CODE, requestCode);
        super.startActivityForResult(intent, requestCode);
    }

    /*

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode != RESULT_OK){
            Log.d(TAG, "result is not OK");
            return ;
        }


        if(requestCode == ARcamearActivity.MEDIA_TYPE_IMAGE) {
            Uri imageUri = data.getData();
            String path = imageUri.getPath();
            this.saveImagePath(path);
            this.setImageBitmap(path);
        }

        if( requestCode == ARcamearActivity.MEDIA_TYPE_ALBUM){
            if(data == null)
                Log.d(TAG, "Reuslt image data is null");

            Uri imageUri = data.getData();
            String path = this.getUriPath(imageUri);
            if(path == null){
                Log.d(TAG, "Album image path is null");
            }
            this.saveImagePath(path);
            this.setImageBitmap(path);
        }


    }

    */


    /*
    private void setImageBitmap(String path){
        saveImagePath(path);
        Bitmap bitmap = BitmapFactory.decodeFile(path);
        Bitmap bitmapC = Util.GetBitmapClippedCircle(bitmap);

        Drawable drawable = this.mImageView.getDrawable();
        Bitmap imageBitmap = ((BitmapDrawable)drawable).getBitmap();
        if(imageBitmap.equals(bitmapC)){
            return;
        }
        this.mImageView.setImageBitmap(bitmapC);

        return;
    }
    */
/*
    private void saveImagePath(String path) {
        //TODO:: save the image path to local dirctory for next start-up
        File userFile = this.mFileUtil.getUserFile();
        try {
            JsonNode root = this.mMapper.readTree(userFile);
            ((ObjectNode)root).put(AppConstant.USER_HEADER_PICTURE,path);
            this.mMapper.writeValue(userFile,root);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

*/
}