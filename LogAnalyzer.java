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
        monthCounts = new int[13];
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
        monthCounts = new int[13];
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
        for(int day = 1; day < dayCounts.length; day++) {
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
        for(int month = 1; month < monthCounts.length; month++) {
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
     * gets greatest amount
     * private method with parameter
     */
    private int getGreatest(int[] counts)
    {
        int myGreatest = 0; int myGreatestCount = counts[0];
        for (int i = 0; i < counts.length; ++i)
        {
            if (counts[i]>myGreatestCount)
            {
                myGreatestCount = counts[i];
                //stores index of greatest count {current count}
                myGreatest = i;
            }
        }
        return myGreatest;
    }
    
    /**
     * gets least amount
     * private method with parameter
     */
    private int getLeast(int[] counts)
    {
        int myLeast = 0; int myLeastCount = counts[0];
        for (int i = 0; i < counts.length; ++i)
        {
            if (counts[i]<myLeastCount)
            {
                myLeastCount = counts[i];
                //stores index of least count {current count}
                myLeast = i;
            }
        }
        return myLeast;
    }
    
    /**
     * returns the busiest hour out of the data, will return {earliest} hour
     * @method
     * @return
     */
    public int busiestHour()
    {
        return getGreatest(hourCounts);
    }
    
    /**
     * returns the quietest hour out of the data, will return {earliest} hour
     * @method
     * @return
     */
    public int quietestHour()
    {
        return getLeast(hourCounts);
    }
    
    /**
     * returns first hour of busiest two hour block out of the data provided
     * @method
     * @return
     */
    public int busiestTwoHour()
    {
        System.out.print("Error, Craig has not gotten this method");
        return 0;
    }
    
    /**
     * returns the quietest day out of the data provided, will return {earliest} day
     * @method
     * @return
     */
    public int quietestDay()
    {
        return getLeast(dayCounts);
    }
    
    /**
     * returns the busiest day out of the data, will return {earliest} day
     * @method
     * @return
     */
    public int busiestDay()
    {
        return getGreatest(dayCounts);
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
        return getLeast(monthCounts);
    }
    
    /**
     * returns the busiest month out of the data, will return {earliest} month
     * @method
     * @return
     */
    public int busiestMonth()
    {
        return getGreatest(monthCounts);
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
