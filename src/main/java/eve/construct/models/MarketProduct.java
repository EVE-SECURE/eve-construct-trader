package eve.construct.models;

public class MarketProduct {
    private Order minSell;
    private Order maxBuy;
    
    public MarketProduct() {
    }
    
    public MarketProduct(Order minSell, Order maxBuy) {
        this.minSell = minSell;
        this.maxBuy = maxBuy;
    }

    /**
     * Returns a (for now) rough estimate of the profit margin for a product
     * @return profit margin as double
     */
    public double getMargin() {
        return minSell.getPrice() - maxBuy.getPrice();
    }
    
    /**
     * Returns a (for now) rough estimate of the profit margin for a product at a given stationID
     * @return profit margin as double
     */
    public double getMargin(int stationID) {
        //Unsure how to implement, minSell and maxBuy currently represent a single Order which already has a designated stationID, no available pool to select from
        return minSell.getPrice() - maxBuy.getPrice();
    }
    
    public Order getMaxBuy() {
        return maxBuy;
    }

    public void setMaxBuy(Order maxBuy) {
        this.maxBuy = maxBuy;
    }

    public Order getMinSell() {
        return minSell;
    }

    public void setMinSell(Order minSell) {
        this.minSell = minSell;
    }
}
