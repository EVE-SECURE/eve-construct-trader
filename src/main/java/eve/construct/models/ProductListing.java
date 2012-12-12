package eve.construct.models;

import java.util.Set;

public abstract class ProductListing {
    private Set<Order> buyOrders;
    private Set<Order> sellOrders;
    
    public ProductListing() {
    }

    public Set<Order> getBuyOrders() {
        return buyOrders;
    }

    public void setBuyOrders(Set<Order> buyOrders) {
        this.buyOrders = buyOrders;
    }

    public Set<Order> getSellOrders() {
        return sellOrders;
    }

    public void setSellOrders(Set<Order> sellOrders) {
        this.sellOrders = sellOrders;
    }
}
