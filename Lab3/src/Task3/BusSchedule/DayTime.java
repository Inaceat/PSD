package Task3.BusSchedule;

import java.io.Serializable;

public class DayTime
        implements Comparable<DayTime>,
                   Serializable
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
    
    public DayTime(int hour, int minute)
    {
        if (hour < 0 || 23 < hour ||
            minute < 0 || 59 < minute)
            throw new IllegalArgumentException();
            
        _hour = hour;
        _minute = minute;
    }
    
    public DayTime TimeFrom(DayTime previousTime)
    {
        //assuming args are correct
        var h = _hour - previousTime._hour;
        var m = _minute - previousTime._minute;
        
        if (m < 0)
        {
            m += 60;
            --h;
        }
        
        return new DayTime(h, m);
    }
    
    @Override
    public String toString()
    {
        return String.format("%02d:%02d", _hour, _minute);
    }
    
    @Override
    public int compareTo(DayTime other)
    {
        int result = _hour - other._hour;
        
        if (result != 0)
            return result;
        
        return _minute - other._minute;
    }
}
