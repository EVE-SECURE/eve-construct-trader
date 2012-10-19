package eve.construct.trader;

/**
 * Main ECTrader class.
 *
 * @author nuadi
 * @version 0.1
 */
public class ECTrader
{
  /**
   * Main execution method used to initialize watchers and main interface.
   *
   * @param args command-line arguments. None used.
   */
  public static void main(String[] args)
  {
    // Fire up a personal order watcher
    OrderWatcher orderWatcher = new OrderWatcher();
    orderWatcher.start();
  }
}