package com.example.yutengfei.android_template.Data;

/**
 * Created by yutengfei on 01/09/16.
 */
public class DataMenuDetial {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDiscribe() {
        return discribe;
    }

    public void setDiscribe(String discribe) {
        this.discribe = discribe;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String name;
    private String price;
    private String discribe;
    private int image;

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    private String discount;

    public DataMenuDetial(String name, String discribe, String price,String discount, int image) {
        this.name = name;
        this.discribe = discribe;
        this.price = price;
        this.discount = discount;
        this.image = image;
    }
}
