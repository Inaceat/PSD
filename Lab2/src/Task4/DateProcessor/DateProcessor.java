package Task4.DateProcessor;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateProcessor
{
    public static void main(String[] args)
            throws Exception
    {
        var groups = new ArrayList<String>();

        String  data    = "$M$Y";
        Pattern pattern = Pattern.compile("(.*?)(\\$.)(.*?)(\\$.)(.*?)(\\$.)(.*)");

        Matcher x = pattern.matcher(data);
        x.matches();

        for (int i = 0; i < 8; i++)
        {
            groups.add(x.group(i));

            System.out.println(i + ". \"" + x.group(i) + "\"");
        }



        //CultureDateInfo.AddCulture("Japan");
        //CultureDateInfo.AddCulture("Denmark");
        //CultureDateInfo.AddCulture("USA");

        /*String countryName;
        var    dateStrings = new ArrayList<Date>();

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
            {
                break;
            }


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
*/
    }
}
