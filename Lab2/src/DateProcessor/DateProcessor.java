package DateProcessor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DateProcessor
{
    public static void main(String[] args)
            throws Exception
    {
        //CultureDateInfo.AddCulture("Japan");
        //CultureDateInfo.AddCulture("Denmark");
        //CultureDateInfo.AddCulture("USA");

        String countryName;
        var dateStrings = new ArrayList<Date>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Read culture
        System.out.println("Enter country name:");
        countryName = reader.readLine();

        var currentCulture = new CultureDateInfo(countryName);

        //Read dates
        String readDateString;
        while (true)
        {
            readDateString = reader.readLine();

            //Stop reading if empty string read
            if (readDateString.equals(""))
                break;


            Date readDate;
            try
            {
                //Try get date from read string
                readDate = currentCulture.TryParseDate(readDateString);
                dateStrings.add(readDate);
            }
            catch (Exception e)
            {
                //If wrong format, put message
                System.out.println("Wrong date format!");
            }
        }

        //Process dates TODO

        //Print processed dates TODO

    }
}
