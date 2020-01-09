package Task1.TimeCalculator;

public class TimeCalculator
{
    private static int minutesOfDay = 24*60;
    
    public Time Subtract(Time time, int minutes)
    {
        int timeMinutes = time.Hour() * 60 + time.Minute();
        
        minutes %= minutesOfDay;
        
        timeMinutes -= minutes;
        
        if (timeMinutes < 0)
            timeMinutes += minutesOfDay;
        
        return new Time(timeMinutes / 60, timeMinutes % 60);
    }
}
