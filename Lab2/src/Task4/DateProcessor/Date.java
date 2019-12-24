package Task4.DateProcessor;

import Task4.DateProcessor.Exceptions.InvalidDateException;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date
{
    public Date(int day, int month, int year)
            throws InvalidDateException
    {
        if (DateValidator.IsValid(day, month, year))
        {
            _day = day;
            _month = month;
            _year = year;
        }
        else
            throw new InvalidDateException();
    }


    void SubtractDays(int daysCount)
    {
        var c = new GregorianCalendar(_year, _month - 1, _day);

        c.add(Calendar.DAY_OF_MONTH, (-1) * daysCount);

        _day = c.get(Calendar.DAY_OF_MONTH);
        _month = c.get(Calendar.MONTH) + 1;
        _year = c.get(Calendar.YEAR);
    }


    boolean IsAfter(Date other)
    {
        if (_year != other._year)
            return _year > other._year;

        if (_month != other._month)
            return _month > other._month;

        return _day > other._day;
    }


    public int Day()
    {
        return _day;
    }

    public int Month()
    {
        return _month;
    }

    public int Year()
    {
        return _year;
    }

    private int _day;
    private int _month;
    private int _year;
}
