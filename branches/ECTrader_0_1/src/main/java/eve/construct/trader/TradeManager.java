package eve.construct.trader;

import eve.construct.models.ProductListing;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Trade manager class that possesses a queue of orders as passed by the LogMonitorThread, which are subsequently removed and processed
 * @author Joseph
 */
public class TradeManager {
    public Queue<ProductListing> productQueue;
    
    public TradeManager()
    {
        productQueue = new LinkedList<ProductListing>();
    }
}