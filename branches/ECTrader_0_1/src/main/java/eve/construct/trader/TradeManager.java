package eve.construct.trader;

import eve.construct.models.Order;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Trade manager class that possesses a queue of orders as passed by the LogMonitorThread, which are subsequently removed and processed
 * @author Joseph
 */
public class TradeManager {
    public Queue<Order> orderQueue;
    
    public TradeManager()
    {
        orderQueue = new LinkedList<Order>();
    }
}