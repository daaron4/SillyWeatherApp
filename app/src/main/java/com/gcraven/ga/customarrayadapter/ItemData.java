package com.gcraven.ga.customarrayadapter;

public class ItemData {

    private String day;
    private String high;
    private String low;
    private int img;

    public ItemData(String day, String high, String low, int img) {
        this.day = day;
        this.high = high;
        this.low = low;
        this.img = img;
    }

    public String getDay() {
        return day;
    }

    public String getHigh() {
        return high;
    }

    public String getLow() {
        return low;
    }

    public int getImg() {
        return img;
    }
}
