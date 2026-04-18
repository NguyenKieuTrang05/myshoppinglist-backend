package de.htw_berlin.myshoppinglist;

public class Item {

    private String title;
    private String category;
    private double price;
    private String url;
    private boolean purchased;

    public Item(String title, String category, double price, String url, boolean purchased) {
        this.title = title;
        this.category = category;
        this.price = price;
        this.url = url;
        this.purchased = purchased;
    }
    public Item(String title, String category) {
        this.title = title;
        this.category = category;

    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public boolean isPurchased() {
        return purchased;
    }
    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

}
