package eve.construct.models;

import java.util.HashSet;
import java.util.Set;

public class MyOrders {
    private Set<TradeOrder> portfolio;
    
    public MyOrders() {
        portfolio = new HashSet<TradeOrder>();
    }

    public Set<TradeOrder> getPortfolio() {
        return portfolio;
    }
    
    public boolean add(TradeOrder tradeOrder) {
        return portfolio.add(tradeOrder);
    }
}
