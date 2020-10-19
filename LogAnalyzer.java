import java.util.Arrays;
import java.util.ArrayList;
import java.util.*;
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
    private int[] dayCounts;
    private int[] monthCounts;
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
        dayCounts = new int[31];
        monthCounts = new int[12];
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
        dayCounts = new int[31];
        monthCounts = new int[12];
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
     * Analyze the daily access data from the log file.
     * @method
     */
    public void analyzeDailyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int day = entry.getDay();
            dayCounts[day]++;
        }
    }
    
    /**
     * Analyze the monthly access data from the log file.
     * @method
     */
    public void analyzeMonthlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int month = entry.getMonth();
            monthCounts[month]++;
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
     * Print the daily counts.
     * These should have been set with a prior
     * call to analyzeDailyData.
     * @method
     */
    public void printDailyCounts()
    {
        System.out.println("Day: Count");
        for(int day = 0; day < dayCounts.length; day++) {
            System.out.println(day + ": " + dayCounts[day]);
        }
    }
    
    /**
     * Print the monthly counts.
     * These should have been set with a prior
     * call to analyzeDailyData.
     * @method
     */
    public void printMonthlyCounts()
    {
        System.out.println("Month: Count");
        for(int month = 0; month < monthCounts.length; month++) {
            System.out.println(month + ": " + monthCounts[month]);
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
     * returns the number of accesses recorded in the log file
     * @method
     * @return
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
     * returns the busiest hour out of the data, will return {earliest} hour
     * @method
     * @return
     */
    public int busiestHour()
    {
        //stores for buisiest hour and busiest count to compare
        int myBusiestHour = 0; int myBusiestCount = hourCounts[0];
        for (int i = 0; i < hourCounts.length; ++i)
        {
            if (hourCounts[i]>myBusiestCount)
            {
                myBusiestCount = hourCounts[i];
                //stores index of busiest hour {current hour}
                myBusiestHour = i;
            }
        }
        return myBusiestHour;
    }
    
    /**
     * returns the quietest hour out of the data, will return {earliest} hour
     * @method
     * @return
     */
    public int quietestHour()
    {
        //stores for quietest hour and quietest count to compare
        int myQuietestHour = 0; int myQuietestCount = hourCounts[0];
        for (int i = 0; i < hourCounts.length; ++i)
        {
            if (hourCounts[i]<myQuietestCount)
            {
                myQuietestCount = hourCounts[i];
                //stores index of quietest hour {current hour}
                myQuietestHour = i;
            }
        }
        return myQuietestHour;
    }
    
    /**
     * returns first hour of busiest two hour block out of the data provided
     * @method
     * @return
     */
    public int busiestTwoHour()
    {
        System.out.println("Error, Craig has not gotten this method done");
        return 0;
    }
    
    /**
     * returns the quietest day out of the data provided, will return {earliest} day
     * @method
     * @return
     */
    public int quietestDay()
    {
        //stores for quietest day and quietest count to compare
        int myQuietestDay = 0; int myQuietestCount = dayCounts[0];
        for (int i = 0; i < dayCounts.length; ++i)
        {
            if (dayCounts[i]<myQuietestCount)
            {
                myQuietestCount = dayCounts[i];
                //stores index of quietest day {current day}
                myQuietestDay = i;
            }
        }
        return myQuietestDay;
    }
    
    /**
     * returns the busiest day out of the data, will return {earliest} day
     * @method
     * @return
     */
    public int busiestDay()
    {
        //stores for buisiest day and busiest count to compare
        int myBusiestDay = 0; int myBusiestCount = dayCounts[0];
        for (int i = 0; i < dayCounts.length; ++i)
        {
            if (dayCounts[i]>myBusiestCount)
            {
                myBusiestCount = dayCounts[i];
                //stores index of busiest day {current day}
                myBusiestDay = i;
            }
        }
        return myBusiestDay;
    }
    
    /**
     * prints total accesses per month {same as print monthly counts}
     * @method
     */
    public void totalAccessesPerMonth()
    {
        printMonthlyCounts();
    }
    
    /**
     * returns the quietest month out of the data provided, will return {earliest} month
     * @method
     * @return
     */
    public int quietestMonth()
    {
        //stores for quietest month and quietest count to compare
        int myQuietestMonth = 0; int myQuietestCount = monthCounts[0];
        for (int i = 0; i < monthCounts.length; ++i)
        {
            if (monthCounts[i]<myQuietestCount)
            {
                myQuietestCount = monthCounts[i];
                //stores index of quietest month {current month}
                myQuietestMonth = i;
            }
        }
        return myQuietestMonth;
    }
    
    /**
     * returns the busiest month out of the data, will return {earliest} month
     * @method
     * @return
     */
    public int busiestMonth()
    {
        //stores for buisiest month and busiest count to compare
        int myBusiestMonth = 0; int myBusiestCount = monthCounts[0];
        for (int i = 0; i < monthCounts.length; ++i)
        {
            if (monthCounts[i]>myBusiestCount)
            {
                myBusiestCount = monthCounts[i];
                //stores index of busiest month {current month}
                myBusiestMonth = i;
            }
        }
        return myBusiestMonth;
    }
    
    /**
     * average accesses per month
     * @method
     * @return
     */
    public int averageAccessesPerMonth()
    {
        //store a total value
        int totalValue = 0;
        //add up all the values in month counts
        for (int myCounts : monthCounts)
        totalValue += myCounts;
        //return total value divided by the amount in the month counts
        return totalValue / monthCounts.length;
    }
}
