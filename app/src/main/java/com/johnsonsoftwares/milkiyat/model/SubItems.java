package com.johnsonsoftwares.milkiyat.model;

public class SubItems {
   private String title;
    private int min_price;
    private int price;
   private String listing_id;
    private String created_since;
    private String updated_since;
    private String category_slug;
    private String slug;
    private String thumbnail;
    private String is_spam;
    private String is_premium;
    private String is_verified;
    private String expiry_date;
    private String offer;
    private String is_chat_allowed;
    private String is_offensive;
    private String is_auction;
    private String out_kashmir;
    private String viewers;
    private String status;
    private String locality;
    private String city;
    private String posted;
    private String in_wishlist;

    public SubItems(String title, int min_price, int price, String listing_id, String created_since, String updated_since, String category_slug, String slug, String thumbnail, String is_spam, String is_premium, String is_verified, String expiry_date, String offer, String is_chat_allowed, String is_offensive, String is_auction, String out_kashmir, String viewers, String status, String locality, String city, String posted, String in_wishlist) {
        this.title = title;
        this.min_price = min_price;
        this.price = price;
        this.listing_id = listing_id;
        this.created_since = created_since;
        this.updated_since = updated_since;
        this.category_slug = category_slug;
        this.slug = slug;
        this.thumbnail = thumbnail;
        this.is_spam = is_spam;
        this.is_premium = is_premium;
        this.is_verified = is_verified;
        this.expiry_date = expiry_date;
        this.offer = offer;
        this.is_chat_allowed = is_chat_allowed;
        this.is_offensive = is_offensive;
        this.is_auction = is_auction;
        this.out_kashmir = out_kashmir;
        this.viewers = viewers;
        this.status = status;
        this.locality = locality;
        this.city = city;
        this.posted = posted;
        this.in_wishlist = in_wishlist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMin_price() {
        return min_price;
    }

    public void setMin_price(int min_price) {
        this.min_price = min_price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getListing_id() {
        return listing_id;
    }

    public void setListing_id(String listing_id) {
        this.listing_id = listing_id;
    }

    public String getCreated_since() {
        return created_since;
    }

    public void setCreated_since(String created_since) {
        this.created_since = created_since;
    }

    public String getUpdated_since() {
        return updated_since;
    }

    public void setUpdated_since(String updated_since) {
        this.updated_since = updated_since;
    }

    public String getCategory_slug() {
        return category_slug;
    }

    public void setCategory_slug(String category_slug) {
        this.category_slug = category_slug;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getIs_spam() {
        return is_spam;
    }

    public void setIs_spam(String is_spam) {
        this.is_spam = is_spam;
    }

    public String getIs_premium() {
        return is_premium;
    }

    public void setIs_premium(String is_premium) {
        this.is_premium = is_premium;
    }

    public String getIs_verified() {
        return is_verified;
    }

    public void setIs_verified(String is_verified) {
        this.is_verified = is_verified;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getIs_chat_allowed() {
        return is_chat_allowed;
    }

    public void setIs_chat_allowed(String is_chat_allowed) {
        this.is_chat_allowed = is_chat_allowed;
    }

    public String getIs_offensive() {
        return is_offensive;
    }

    public void setIs_offensive(String is_offensive) {
        this.is_offensive = is_offensive;
    }

    public String getIs_auction() {
        return is_auction;
    }

    public void setIs_auction(String is_auction) {
        this.is_auction = is_auction;
    }

    public String getOut_kashmir() {
        return out_kashmir;
    }

    public void setOut_kashmir(String out_kashmir) {
        this.out_kashmir = out_kashmir;
    }

    public String getViewers() {
        return viewers;
    }

    public void setViewers(String viewers) {
        this.viewers = viewers;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPosted() {
        return posted;
    }

    public void setPosted(String posted) {
        this.posted = posted;
    }

    public String getIn_wishlist() {
        return in_wishlist;
    }

    public void setIn_wishlist(String in_wishlist) {
        this.in_wishlist = in_wishlist;
    }
}
