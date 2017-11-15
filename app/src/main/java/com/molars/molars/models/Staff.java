package com.molars.molars.models;

/**
 * Created by dennis on 11/15/17.
 */

public class Staff {
    private String staff_name;
    private String staff_title;
    private int staff_photo;

    public Staff(String staff_name, String staff_title, int staff_photo){
        this.staff_name = staff_name;
        this.staff_title = staff_title;
        this.staff_photo = staff_photo;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public String getStaff_title() {
        return staff_title;
    }

    public int getStaff_photo() {
        return staff_photo;
    }
}
