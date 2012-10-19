package eve.construct.trader;

/**
 * Order Watcher is designed to watch the MarketLogs folder for any file exports
 * from the My Orders section of the wallet.
 *
 * @author nuadi
 * @version 0.1
 */
public class OrderWatcher extends Thread
{
  /**
   * Main execution method used to watch the MarketLogs folder and digest any
   * any new MyOrders files.
   */
  @Override
  public void run()
  {
    System.out.println("Hello!");
  }
}