package eve.construct.csv;

import au.com.bytecode.opencsv.CSVReader;
import eve.construct.models.Order;
import eve.construct.models.Source;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVConverter {
    
    /**
     * Creates an Order object from a market CSV
     * @param inputCSV File object containing the CSV polled from the log directory
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static Order convertMarket(File inputCSV) throws FileNotFoundException, IOException
    {
        int itemID = -1, stationID = 1;
        double sellPrice = -1, buyPrice = -1;
        
        FileReader fileReader = new FileReader(inputCSV);
        CSVReader csvReader = new CSVReader(fileReader);
        List<String[]> lines = csvReader.readAll();
        
        //Get the lowest sell order and highest buy order
        for (int i = 1; i < lines.size(); i++)
        {
            String[] line = lines.get(i);
            //True resolves to buy orders, false to sell orders
            if (Boolean.parseBoolean(line[7]))
            {
                buyPrice = Math.max(Double.parseDouble(line[0]), buyPrice);
            }
            else
            {
                if (sellPrice == -1)
                    sellPrice = Double.parseDouble(line[0]);
                else
                    sellPrice = Math.min(Double.parseDouble(line[0]), sellPrice);
            }
            //Parse column 3 for itemID
            itemID = Integer.parseInt(line[2]);
        }
        return new Order(sellPrice, buyPrice, itemID, stationID, Source.MARKET);
    }
    
    /**
     * Creates a list of Order objects from a MyOrders CSV
     * @param inputCSV File object containing the CSV polled from the log directory
     * @return
     * @throws FileNotFoundException 
     */
    public static List<Order> convertMyOrder(File inputCSV) throws FileNotFoundException, IOException
    {
        List<Order> orders = new ArrayList<Order>();
        FileReader fileReader = new FileReader(inputCSV);
        CSVReader csvReader = new CSVReader(fileReader);
        List<String[]> lines = csvReader.readAll();
        
        for (int i = 1; i < lines.size(); i++)
        {
            int itemID = -1, stationID = 1;
            double sellPrice = -1, buyPrice = -1;
            
            String[] line = lines.get(i);
            //True resolves to buy orders, false to sell orders
            if (Boolean.parseBoolean(line[9]))
            {
                buyPrice = Double.parseDouble(line[10]);
            }
            else
            {
                sellPrice = Double.parseDouble(line[10]);
            }
            //Parse column 7 for stationID
            stationID = Integer.parseInt(line[6]);
            //Parse column 2 for itemID
            itemID = Integer.parseInt(line[1]);
            Order order = new Order(sellPrice, buyPrice, itemID, stationID, Source.MYORDERS);
            orders.add(order);
        }
        return orders;
    }
}
