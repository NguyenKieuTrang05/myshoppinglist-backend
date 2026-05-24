package de.htw_berlin.myshoppinglist;

public class Item {

    private String name;
    private String category;
    private String amount;
    private String shop;
    private String url;
    private double price;
    private String priority;
    private String status;
    private boolean purchased;

    public Item(String name, String category, String amount, String shop, String url, double price, String priority, String status, boolean purchased) {
        this.name = name;
        this.category = category;
        this.amount = amount;
        this.shop = shop;
        this.url = url;
        this.price = price;
        this.priority = priority;
        this.status = status;
        this.purchased = purchased;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getAmount() { return amount; }
    public void setAmount(String amount) { this.amount = amount; }

    public String getShop() { return shop; }
    public void setShop(String shop) { this.shop = shop; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public boolean isPurchased() { return purchased; }
    public void setPurchased(boolean purchased) { this.purchased = purchased; }
}