package com.molars.molars.models;

/**
 * Created by dennis on 11/14/17.
 */

public class Menu {
    private int menu_icon;
    private String menu_title;

    public Menu(int menu_icon, String menu_title){
        this.menu_icon = menu_icon;
        this.menu_title = menu_title;
    }

    public int getMenu_icon() {
        return menu_icon;
    }

    public String getMenu_title() {
        return menu_title;
    }
}
