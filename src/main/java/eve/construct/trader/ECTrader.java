package eve.construct.trader;

public class ECTrader
{
    public static void main(String[] args)
    {
        System.out.println("Starting main method");
        LogMonitorThread logListener = new LogMonitorThread();
        logListener.start();
        System.out.println("Listening to directory...");
        try
        {
            while(true)
            {
                //Thread.sleep(5000);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}