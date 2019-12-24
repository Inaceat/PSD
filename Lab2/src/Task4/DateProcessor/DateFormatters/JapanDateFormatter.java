package Task4.DateProcessor.DateFormatters;

import Task4.DateProcessor.Date;
import Task4.DateProcessor.Exceptions.InvalidDateException;
import Task4.DateProcessor.Exceptions.InvalidDateFormatException;

import java.util.regex.Pattern;

public class JapanDateFormatter
        implements IDateFormatter
{
    @Override
    public String FormatTemplate()
    {
        return "y/m/d";
    }

    @Override
    public String ToString(Date date)
    {
        StringBuilder result = new StringBuilder();

        result.append(date.Year()).append('/');
        result.append(date.Month()).append('/');
        result.append(date.Day());

        return result.toString();
    }

    @Override
    public Date ParseDate(String date)
            throws InvalidDateFormatException, InvalidDateException
    {
        var datePattern = Pattern.compile("^(\\d+)/(\\d+)/(\\d+)$");
        var match = datePattern.matcher(date);

        if (!match.find())
            throw new InvalidDateFormatException();

        int year = Integer.parseInt(match.group(1));
        int month = Integer.parseInt(match.group(2));
        int day = Integer.parseInt(match.group(3));

        return new Date(day, month, year);
    }
}
