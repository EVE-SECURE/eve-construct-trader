package eve.construct.csv;

import au.com.bytecode.opencsv.CSVReader;
import eve.construct.models.Order;
import eve.construct.models.Source;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
            //Parse row 3 for itemID
            itemID = Integer.parseInt(line[2]);
        }
        return new Order(sellPrice, buyPrice, itemID, stationID, Source.MARKET);
    }
    
    /**
     * Creates an Order object from a MyOrders CSV
     * @param inputCSV File object containing the CSV polled from the log directory
     * @return
     * @throws FileNotFoundException 
     */
    public static Order convertMyOrder(File inputCSV) throws FileNotFoundException
    {
        //TODO: Code for MyOders files
        return null;
    }
}
