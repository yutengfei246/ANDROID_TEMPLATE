package com.example.yutengfei.android_template.Data;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;

/**
 * Created by yutengfei on 27/08/16.
 */
public class Util {


    /*Create a circular bitmap*/
    public static Bitmap GetBitmapClippedCircle(Bitmap bitmap) {

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap outputBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        Path path = new Path();
        path.addCircle(
                (float) (width / 2)
                , (float) (height / 2)
                , (float) Math.min(width, (height / 2))
                , Path.Direction.CCW);

        Canvas canvas = new Canvas(outputBitmap);
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap, 0, 0, null);
        return outputBitmap;
    }


    /*Create a list of the data of using in Main card view*/
    /*
    public static List<DataCardView> GetInitialListDataCardView(){

        List<DataCardView> list = new ArrayList<>();

        String[] title = {"ANTIPASTI", "PRIMI PIATTI", "SECONDI PIATTI", "DOLCI" ,"BEVENTA","FAST FOOD"};
        String[] intro = {"the first eat", "the scond eat", "main", "desert" ,"beventry", "fastfood"};
        int[] inmage = {R.drawable.antipasti1,R.drawable.primi,R.drawable.secondi,R.drawable.dolci,
                R.drawable.b,R.drawable.pizza};

        for(int i=0; i<title.length;i++){
            DataCardView dataCardView = new DataCardView(title[i],inmage[i],intro[i]);
            list.add(dataCardView);
        }

        return list;

    }

    */

    /*Create a list of the data of using in Main card view*/
    /*
    public static List<DataMenuDetial> GetInitialListMenuDetial(){

        List<DataMenuDetial> list = new ArrayList<>();

        String[] name ={"First","Second","First","Second","First","Second"};
        String[] price={"10","20","10","20","10","20"};
        String[] describe={"Good","Good","Good","Good","Good","Good"};
        int[] images={R.drawable.painting_1};

        for(int i=0; i<name.length;i++){
            DataMenuDetial dataMenuDetial = new DataMenuDetial(name[i],price[i],describe[i],describe[i],images[0]);
            list.add(dataMenuDetial);
        }

        return list;

    }
    */

}
