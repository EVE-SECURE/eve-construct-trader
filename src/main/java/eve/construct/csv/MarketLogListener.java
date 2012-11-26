package eve.construct.csv;

import eve.construct.models.Order;
import eve.construct.trader.TradeManager;
import java.io.File;
import java.util.List;
import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationObserver;

/**
 * Log listener to execute code on new file creation in the Market logs folder
 * @author Joseph
 */
public class MarketLogListener implements FileAlterationListener {
    public TradeManager tradeManager;
    
    public MarketLogListener(TradeManager tradeManager) {
        this.tradeManager = tradeManager;
    }

    public void onStart(FileAlterationObserver fao) {
        //Ignore
    }

    public void onDirectoryCreate(File file) {
        //Ignore
    }

    public void onDirectoryChange(File file) {
        //Ignore
    }

    public void onDirectoryDelete(File file) {
        //Ignore
    }

    public void onFileCreate(File file) {
        System.out.println("File created: " + file.getName());
        try
        {
            if(file.getName().contains("My Orders"))
            {
                List<Order> orders = CSVConverter.convertMyOrder(file);
                for (Order order : orders)
                {
                    tradeManager.orderQueue.add(order);
                }
            }
            else
            {
                Order order = CSVConverter.convertMarket(file);
                tradeManager.orderQueue.add(order);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void onFileChange(File file) {
        //Ignore
    }

    public void onFileDelete(File file) {
        //Ignore
    }

    public void onStop(FileAlterationObserver fao) {
        //Ignore
    }
    
}
