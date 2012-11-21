package eve.construct.trader;

public class ECTrader
{
    public static void main(String[] args)
    {
        System.out.println("Starting main method");
        TradeManager tradeManager = new TradeManager();
        LogMonitorThread logListener = new LogMonitorThread(tradeManager);
        logListener.start();
        System.out.println("Listening to directory...");
        try
        {
            while(true)
            {
                //Check every 5 seconds for an order, print the toString if found
                Thread.sleep(5000);
                if (!tradeManager.orderQueue.isEmpty())
                {
                    System.out.println(tradeManager.orderQueue.remove().toString());
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}