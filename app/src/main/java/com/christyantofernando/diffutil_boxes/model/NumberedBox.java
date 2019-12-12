package com.christyantofernando.diffutil_boxes.model;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;

public class NumberedBox {
    private int number;
    @ColorRes
    private int colorRes;
    
    public NumberedBox (int number, int colorRes) {
        this.number = number;
        this.colorRes = colorRes;
    }
    
    public int getColorRes () {
        return colorRes;
    }
    
    public void setColorRes (int colorRes) {
        this.colorRes = colorRes;
    }
    
    public NumberedBox (int number) {
        this.number = number;
    }
    
    public int getNumber () {
        return number;
    }
    
    public void setNumber (int number) {
        this.number = number;
    }
}
