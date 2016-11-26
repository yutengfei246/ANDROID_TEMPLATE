package com.example.yutengfei.android_template.Utility;

import android.app.Activity;
import android.os.Environment;
import android.util.Log;

import com.example.yutengfei.android_template.Data.Menu;
import com.example.yutengfei.android_template.Data.Restaurant;
import com.example.yutengfei.android_template.Data.UserInfo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

/**
 * Created by yutengfei on 19/04/16.
 *  used to create FileDir File
 */


public  class FileUtil extends Activity {

    public static final String APP_DIRNAME_DIR = "Easy Eat";
    public static final String APP_USER_INFO_DIR = APP_DIRNAME_DIR + File.separator +"User Information";
    public static final String APP_REST_INFO_DIR = APP_DIRNAME_DIR + File.separator + "Restaurant Information";

    public static final String APP_USER_INFO_FILE = APP_USER_INFO_DIR + File.separator + "userInfo.txt";
    public static final String APP_REST_INFO_FILE = APP_REST_INFO_DIR + File.separator + "restInfo.txt";
    public static final String APP_MEU = APP_REST_INFO_DIR + File.separator + "menuInfo.txt";

    public static final String NAME_NEW_MENU = "new menu";

    private ObjectMapper mapper ;


    public FileUtil(){
        this.mapper = new ObjectMapper();

    }

    public boolean initDirs(){
        this.createDirs(APP_DIRNAME_DIR);
        this.createDirs(APP_USER_INFO_DIR);
        this.createDirs(APP_REST_INFO_DIR);

        return true;
    }

    public File getUserFile() {

        return this.getFile(APP_USER_INFO_FILE, UserInfo.class);

    }

    public File getRestFile(){
        return this.getFile(APP_REST_INFO_FILE, Restaurant.class);
    }


    public File getMenu(){

        return this.getFile(APP_MEU, Menu.class);
    }

    private void createEmptyMenuEntry(){


        try{

            ObjectNode menus = this.mapper.createObjectNode();
            JsonNode newMenuTree = this.createEmptyEntry();
            menus.set(NAME_NEW_MENU,newMenuTree);
            this.mapper.writeValue(this.getMenu(), menus);

        }catch (IOException e){}

    }



    public void appendNewMenuEntry(){
        try {
            JsonNode newMenuTree = this.createEmptyEntry();
            JsonNode menus = this.mapper.readTree(this.getMenu());
            ((ObjectNode)menus).set(NAME_NEW_MENU,newMenuTree);
            this.mapper.writeValue(this.getMenu(), menus);
        }catch (IOException e){}

    }

    private JsonNode createEmptyEntry(){

        JsonNode newMenuTree = null;

        try{

            Menu ob = new Menu();
            String newMenuString = this.mapper.writeValueAsString(ob);
            newMenuTree = this.mapper.readTree(newMenuString);

        }catch (IOException e){}

        return newMenuTree;
    }

    private File getFile(String fileName , Class<?> cls) {
        File info = new File(Environment.getExternalStorageDirectory() + File.separator +  fileName);
        try {
            if (!info.exists()) {
                if (!info.createNewFile() ) {
                    throw new IOException();
                }
                this.initInfoFile(cls);
            } else {
            }
        }catch (IOException e){}

        return info;

    }

    private void createDirs(String FileDir){


        File mediaStorageDir = new File(Environment.getExternalStorageDirectory()
                + File.separator + FileDir);
        Log.d("FileUtil", "Dir Path" + mediaStorageDir.getPath());

        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("FileUtil", "failed to create directory");
                return ;
            }
        }else{
            Log.d("FileUtil","Dir Eixt");
        }

    }

    private boolean initInfoFile(Class<?> cls){

        ObjectMapper om = new ObjectMapper();

        if(cls == UserInfo.class) {

            try {
                UserInfo ob = new UserInfo();
                om.writeValue(this.getUserFile(), ob);
            } catch (IOException e) {
                Log.d("FileUtil", "InitInfoFile Exception");

            }
        }

        if(cls == Menu.class){
            this.createEmptyMenuEntry();
        }
        Log.d("FileUtil","InitInfoFile done");

        return  true ;
    }

}