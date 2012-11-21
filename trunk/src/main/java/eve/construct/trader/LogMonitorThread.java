/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eve.construct.trader;

import eve.construct.csv.MarketLogListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

public class LogMonitorThread extends Thread {
    /**
   * Main execution method used to watch the MarketLogs folder and digest any
   * any new MyOrders files.
   */
    @Override
    public void run()
    {
        // Fetch the default location for the user's My Documents folder
        JFileChooser fileChooser = new JFileChooser();
        FileSystemView fileSysView = fileChooser.getFileSystemView();
        String docsFolder = fileSysView.getDefaultDirectory().getPath();
        String marketLogsPath = docsFolder + "/EVE/logs/Marketlogs";
        File marketLogsDir = new File(marketLogsPath);
        // Add a listener that converts csv values when it finds a new file
        FileAlterationObserver fio = new FileAlterationObserver(marketLogsDir);
        fio.addListener(new MarketLogListener());
        try
        {
            FileAlterationMonitor monitor = new FileAlterationMonitor(1000);
            monitor.addObserver(fio);
            monitor.start();
            // Listen forever
            while(true) {}
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
