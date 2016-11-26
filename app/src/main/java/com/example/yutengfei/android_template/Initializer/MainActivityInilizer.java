package com.example.yutengfei.android_template.Initializer;

import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.content.CursorLoader;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.yutengfei.android_template.Adapter._PagerAdapter;
import com.example.yutengfei.android_template.Fragment.PagerFragment;
import com.example.yutengfei.android_template.MainActivity;
import com.example.yutengfei.android_template.R;
import com.example.yutengfei.android_template.Utility.FileUtil;
import com.example.yutengfei.android_template.Utility.ListenerUtility;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by yutengfei on 26/11/16.
 */
public class MainActivityInilizer {
    private static String TAG = "MainActivityInilizer";

    private  MainActivity mainActicity;

    private DrawerLayout mDrawLayout;
    private ActionBarDrawerToggle mToggle;
    private NavigationView mNavivationView;
    private ListenerUtility mListenerUtility;
    private View mHeaderView;
    private ImageView mImageView;
    private FileUtil mFileUtil;
    private ObjectMapper mMapper;


    public MainActivityInilizer(MainActivity mainActivity) {
        this.mainActicity = mainActivity;
    }


    public void initiate() {
        this.setUpParam();
        this.setToolbar();
        this.setUpDrawer();
        this.setListener();
 //       this.setUpInfo();
        //this.setRecyclerAdapter();
        this.setPagerView();
    }



    private void setToolbar() {
        Toolbar toolbar = (Toolbar) this.mainActicity.findViewById(R.id.toolbar);
        this.mainActicity.setSupportActionBar(toolbar);

    }
/*
    private void setUpInfo() {

        File userFile = this.mFileUtil.getUserFile();

        try {
            UserInfo userInfo = this.mMapper.readValue(userFile,UserInfo.class);
            String headerPath=userInfo.getHeaderPhoto();
            if(headerPath == "" ){
                Log.d(TAG, "headrPath is null");
                Bitmap bitmap = BitmapFactory.decodeResource(this.mainActicity.getResources(), R.drawable.painting_1);
                Bitmap bitmapC = Util.GetBitmapClippedCircle(bitmap);
                this.mImageView.setImageBitmap(bitmapC);
            }else{
                Log.d(TAG,"header path not null");
                this.setImageBitmap(headerPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
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
    private void setUpDrawer() {
        this.mDrawLayout = (DrawerLayout) this.mainActicity.findViewById(R.id.drawer_layout);
        this.mToggle = new ActionBarDrawerToggle(this.mainActicity,this.mDrawLayout,R.string.open,R.string.close);
        this.mToggle.syncState();
        this.mDrawLayout.addDrawerListener(this.mToggle);

        this.mNavivationView = (NavigationView) this.mainActicity.findViewById(R.id.navigation_view);
        this.mHeaderView = this.mNavivationView.getHeaderView(0);

        this.mainActicity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.mNavivationView.setNavigationItemSelectedListener(this.mainActicity);
    }

    private void setListener() {
        this.mListenerUtility = new ListenerUtility(this.mainActicity);

     //   ImageView imageView = (ImageView) this.mHeaderView.findViewById(R.id.fab_photo);
      //  this.mListenerUtility.setListener(imageView, ListenerUtility.NAVIGATION_ALBUM);
       // this.mListenerUtility.setListener(imageView, ListenerUtility.NAVIGATION_PHOTO);

      //  imageView = (ImageView) this.mHeaderView.findViewById(R.id.fab_ablum);

    }


    private void setUpParam() {

        this.mFileUtil = new FileUtil();
        //this.mFileUtil.initDirs();
        //this.mMapper = new ObjectMapper();
    }


    private   String getUriPath(Uri selectedImageUri){
        String[] projection = {MediaStore.MediaColumns.DATA};
        CursorLoader cursorLoader = new CursorLoader(this.mainActicity, selectedImageUri, projection, null, null,
                null);
        Cursor cursor = cursorLoader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        cursor.moveToFirst();
        String selectedImagePath = cursor.getString(column_index);
        cursor.close();

        return selectedImagePath;

    }

    public ActionBarDrawerToggle getToggle() {
        return this.mToggle;
    }



    /*
    private void setRecyclerAdapter() {

        List<DataCardView> data = Util.GetInitialListDataCardView();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        CardViewRecyclerAdapter cardViewRecyclerAdapter = new CardViewRecyclerAdapter(this,data);
        recyclerView.setAdapter(cardViewRecyclerAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

      //  StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(linearLayoutManager);



        recyclerView.setItemAnimator(new DefaultItemAnimator());
    } */



    private void setPagerView() {
        ViewPager viewPager = (ViewPager) this.mainActicity.findViewById(R.id.view_pager);
        _PagerAdapter pagerAdapter = new _PagerAdapter(this.mainActicity.getSupportFragmentManager(),2,this.mainActicity);
        pagerAdapter.addTab(PagerFragment.class, null, "Lessions");
        pagerAdapter.addTab(PagerFragment.class, null, "News");

        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = (TabLayout) this.mainActicity.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }



    public Boolean isDrawerOpen(){
        return this.mDrawLayout.isDrawerOpen(GravityCompat.START);
    }

    public void  closeDrawer(){
        this.mDrawLayout.closeDrawer(GravityCompat.START);
    }

}
