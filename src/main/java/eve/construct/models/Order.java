package eve.construct.models;

public class Order {
    private double price;
    private int volume;
    private int itemID;
    private int stationID;
    private int minVolume;
    
    public Order(double price, int volume, int itemID, int stationID, int minVolume) {
        this.price = price;
        this.volume = volume;
        this.itemID = itemID;
        this.stationID = stationID;
        this.minVolume = minVolume;
    }

    public int getMinVolume() {
        return minVolume;
    }

    public void setMinVolume(int minVolume) {
        this.minVolume = minVolume;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }
    
    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
