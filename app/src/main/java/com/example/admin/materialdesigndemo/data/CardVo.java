package com.example.admin.materialdesigndemo.data;

/**
 * Created by 14537 on 2017/10/16.
 */

public class CardVo {
    public CardVo(int img, String name) {
        this.img = img;
        this.name = name;
    }

    private int img;
    private String name;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
