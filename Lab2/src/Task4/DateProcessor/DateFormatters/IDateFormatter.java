package Task4.DateProcessor.DateFormatters;

import Task4.DateProcessor.Date;
import Task4.DateProcessor.Exceptions.InvalidDateException;
import Task4.DateProcessor.Exceptions.InvalidDateFormatException;

public interface IDateFormatter
{
    String FormatTemplate();

    String ToString(Date date);

    Date ParseDate(String date)
            throws InvalidDateException, InvalidDateFormatException;
}
