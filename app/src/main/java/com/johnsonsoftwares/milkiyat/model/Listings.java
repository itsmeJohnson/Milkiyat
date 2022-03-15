package com.johnsonsoftwares.milkiyat.model;

import java.util.ArrayList;

public class Listings {
    private String type;
    private String title;
    private String summary;
    private String icon;
    private String two_line;
    private ArrayList<SubItems> subItemsArrayList;

    public Listings(String type, String title, String summary, String icon, String two_line,ArrayList<SubItems> subItemsArrayList) {
        this.type = type;
        this.title = title;
        this.summary = summary;
        this.icon = icon;
        this.two_line = two_line;
        this.subItemsArrayList = subItemsArrayList;
    }

    public ArrayList<SubItems> getSubItemsArrayList() {
        return subItemsArrayList;
    }

    public void setSubItemsArrayList(ArrayList<SubItems> subItemsArrayList) {
        this.subItemsArrayList = subItemsArrayList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTwo_line() {
        return two_line;
    }

    public void setTwo_line(String two_line) {
        this.two_line = two_line;
    }
}
