package com.example.rabson.ea.AcademicYear;

/**
 * Created by Rabson on 10/8/2016.
 */
public class AcademicData {

    public AcademicData(int img_res,String title){
        this.setImg_res(img_res);
        this.setTitle(title);
    }
    private int img_res;
    private String title;

    public int getImg_res() {
        return img_res;
    }

    public void setImg_res(int img_res) {
        this.img_res = img_res;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
