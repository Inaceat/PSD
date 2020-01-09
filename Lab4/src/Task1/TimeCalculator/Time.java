package Task1.TimeCalculator;


import java.util.Objects;

public class Time
        implements Comparable<Time>
{
    private int _hour;
    private int _minute;
    
    int Hour()
    {
        return _hour;
    }
    int Minute()
    {
        return _minute;
    }
    
    public Time(int hour, int minute)
    {
        if (hour < 0 || 23 < hour ||
            minute < 0 || 59 < minute)
            throw new IllegalArgumentException();
        
        _hour = hour;
        _minute = minute;
    }
    
    @Override
    public String toString()
    {
        return String.format("%02d:%02d", _hour, _minute);
    }
    
    @Override
    public int compareTo(Time other)
    {
        int result = _hour - other._hour;
        
        if (result != 0)
            return result;
        
        return _minute - other._minute;
    }
}
