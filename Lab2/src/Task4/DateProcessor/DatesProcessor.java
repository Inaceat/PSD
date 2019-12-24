package Task4.DateProcessor;

import java.util.ArrayList;

public class DatesProcessor
{
    public static void DoStrangeThingsWithDates(ArrayList<Date> dates)
    {
        //Assuming dates has no equal elements
        int daysToSubtract;

        for (int currentDateIndex = 0; currentDateIndex < dates.size(); ++currentDateIndex)
        {
            daysToSubtract = 0;

            for (var date : dates)
            {
                if (!dates.get(currentDateIndex).IsAfter(date))
                    ++daysToSubtract;
            }

            dates.get(currentDateIndex).SubtractDays(daysToSubtract);
        }
    }
}
