package eve.construct.csv;

import eve.construct.models.Order;
import java.io.File;
import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationObserver;

public class MarketLogListener implements FileAlterationListener {

    public MarketLogListener() {
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
            Order order = CSVConverter.convertMarket(file);
            //TODO: Pass the order off to a TradeManager
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
