package com.johnsonsoftwares.milkiyat.model;

public class Categories {
    private String name;
    private String slug;
    private String icon;

    public Categories(String name, String slug, String icon) {
        this.name = name;
        this.slug = slug;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
