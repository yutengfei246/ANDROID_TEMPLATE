package com.example.yutengfei.android_template.Data;

/**
 * Created by yutengfei on 28/08/16.
 */
public class DataCardView {
    public DataCardView(String title, int image, String intro) {
        this.title = title;
        this.image = image;
        this.intro = intro;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;
    private String intro;
    private int image;





}
