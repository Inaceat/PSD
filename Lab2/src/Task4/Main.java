package Task4;


import Task4.DateProcessor.CultureInfo;
import Task4.DateProcessor.Date;
import Task4.DateProcessor.DateFormatters.IDateFormatter;
import Task4.DateProcessor.DatesProcessor;
import Task4.DateProcessor.Exceptions.InvalidCountryNameException;
import Task4.DateProcessor.Exceptions.InvalidDateException;
import Task4.DateProcessor.Exceptions.InvalidDateFormatException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main
{
    private static CultureInfo GetCultureFromConsole(BufferedReader reader)
            throws Exception
    {
        String      countryName;
        CultureInfo currentCulture;

        while (true)
        {
            System.out.println("Enter country name:");
            try
            {
                countryName = reader.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
                throw new Exception("PANIC");
            }

            try
            {
                currentCulture = new CultureInfo(countryName);
                break;
            }
            catch (InvalidCountryNameException e)
            {
                System.out.println("Wrong country name!");
            }
        }

        return currentCulture;
    }

    public static void main(String[] args)
            throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        IDateFormatter formatter = GetCultureFromConsole(reader).DateFormatter();

        //Read dates
        System.out.println("Enter dates in \"" + formatter.FormatTemplate() + "\" format:");

        var    dates = new ArrayList<Date>();
        String readDateString;
        while (true)
        {
            try
            {
                readDateString = reader.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
                throw new Exception("PANIC 2");
            }

            //Stop reading if empty string read
            if (readDateString.equals(""))
                break;

            Date readDate;
            try
            {
                //Try get date from read string
                readDate = formatter.ParseDate(readDateString);
                dates.add(readDate);
            }
            catch (InvalidDateFormatException e)
            {
                System.out.println("Wrong date format!");
            }
            catch (InvalidDateException e)
            {
                System.out.println("Wrong date value!");
            }

        }

        //Process dates
        DatesProcessor.DoStrangeThingsWithDates(dates);

        //Print processed dates
        System.out.println("Result:");
        for (var date : dates)
        {
            System.out.println(formatter.ToString(date));
        }
    }
}
