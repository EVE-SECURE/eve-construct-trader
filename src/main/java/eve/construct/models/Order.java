package eve.construct.models;

public class Order {
    private double sellPrice;
    private double buyPrice;
    private int itemID;
    private int stationID;
    
    public Order(double sellPrice, double buyPrice, int itemID, int stationID, Source source) {
        this.sellPrice = sellPrice;
        this.buyPrice = buyPrice;
        this.itemID = itemID;
        this.stationID = stationID;
        source = Source.MARKET;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }
    
    /**
     * Rough estimate of profit for a given order, to be expanded upon later
     * @return 
     */
    public double getProfit() {
        return sellPrice - buyPrice;
    }

    @Override
    public String toString() {
        return "Order{" + "sellPrice=" + sellPrice + ", buyPrice=" + buyPrice + ", itemID=" + itemID + ", stationID=" + stationID + "\nPROFIT=" + getProfit() + '}';
    }
}
