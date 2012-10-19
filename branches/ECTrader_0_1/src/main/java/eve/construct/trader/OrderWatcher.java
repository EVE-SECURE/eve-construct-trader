package eve.construct.trader;

import java.io.File;

import javax.swing.JFileChooser;

import javax.swing.filechooser.FileSystemView;

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
    // Fetch the default location for the user's My Documents folder
    JFileChooser fileChooser = new JFileChooser();
    FileSystemView fileSysView = fileChooser.getFileSystemView();
    String docsFolder = fileSysView.getDefaultDirectory().getPath();
    // Attach to the MarketLogs folder
    String marketLogsPath = docsFolder + "/EVE/logs/MarketLogs";
    File marketLogsDir = new File(marketLogsPath);
    File[] marketLogs = marketLogsDir.listFiles();
    System.out.println(marketLogs.length + " logs detected.");
  }
}