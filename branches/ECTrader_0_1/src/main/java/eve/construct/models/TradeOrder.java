package eve.construct.models;

public class TradeOrder extends Order {
    
    private boolean persistent;
    
    public TradeOrder(double price, int volume, int itemID, int stationID, int minVolume) {
        super(price, volume, itemID, stationID, minVolume);
        this.persistent = false;
    }

    public boolean isPortfolio() {
        return persistent;
    }

    public void setPortfolio(boolean portfolio) {
        this.persistent = portfolio;
    }
}
