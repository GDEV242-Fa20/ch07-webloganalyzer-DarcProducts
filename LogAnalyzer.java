import java.util.Arrays;
/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author Craig Hussey
 * @version    2020.10.17
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader("demo.log");
    }
    
    /**
     * Create an object to analyze hourly web accesses with string parameter
     * @constructor
     * @param
     */
    public LogAnalyzer(String fileName)
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader(fileName);
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
    
    /**
     * @method
     * @return the number of accesses recorded in the log file
     */
    public int numberOfAccesses()
    {
        //create int store and start at 0
        int total = 0;
        //add each count to total
        for (int i = 0; i < hourCounts.length; ++i)
        total += hourCounts[i];
        //return total counts
        return total;
    }
    
    /**
     * @method
     * @return the busiest hour out of the data, will return {earliest} hour
     */
    public int busiestHour()
    {
        //stores for buisiest hour and busiest count to compare
        int myBusiestHour = 0; int myBusiestCount = 0;
        for (int i = 0; i < hourCounts.length; ++i)
        {
            if (hourCounts[i]>myBusiestCount)
            {
                myBusiestCount = hourCounts[i];
                myBusiestHour = i;
            }
        }
        return myBusiestHour;
    }
    
    /**
     * @method
     * @return the quietest hour out of the data, will return {latest} hour
     */
    public int quietesttHour()
    {
        //stores for quietest hour and quietest count to compare
        int myQuietestHour = 0; int myQuietestCount = 1;
        for (int i = 0; i < hourCounts.length; ++i)
        {
            if (hourCounts[i]<myQuietestCount)
            {
                hourCounts[i] = myQuietestCount;
                myQuietestHour = i;
            }
        }
        return myQuietestHour;
    }
    
    /**
     * @method
     * @return first hour of busiest two hour block
     */
    public void busiestTwoHour()
    {
        for (int i = 0; i < hourCounts.length; ++i)
        {
            
        }
    }
}
