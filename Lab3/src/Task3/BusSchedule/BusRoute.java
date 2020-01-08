package Task3.BusSchedule;

import java.io.Serializable;

public class BusRoute
        implements Serializable
{
    private DayOfWeek _dayOfWeek;
    
    private String _departurePoint;
    private String _arrivalPoint;
    
    private DayTime _departureTime;
    private DayTime _arrivalTime;
    
    
    public BusRoute(DayOfWeek dayOfWeek, String departurePoint, String arrivalPoint, DayTime departureTime, DayTime arrivalTime)
    {
        _dayOfWeek = dayOfWeek;
        
        _departurePoint = departurePoint;
        _arrivalPoint = arrivalPoint;
        
        _departureTime = departureTime;
        _arrivalTime = arrivalTime;
    }
    
    
    public DayOfWeek DayOfWeek()
    {
        return _dayOfWeek;
    }
    
    public String DeparturePoint()
    {
        return _departurePoint;
    }
    public String ArrivalPoint()
    {
        return _arrivalPoint;
    }
    
    public DayTime DepartureTime()
    {
        return _departureTime;
    }
    public DayTime ArrivalTime()
    {
        return _arrivalTime;
    }
    
    
    public DayTime GetTravelTime()
    {
        return new DayTime(_arrivalTime.Hour() - _departureTime.Hour(), _arrivalTime.Minute() - _departureTime.Minute());
    }
}
