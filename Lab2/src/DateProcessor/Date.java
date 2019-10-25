package DateProcessor;

public class Date
{
    public Date(int day, int month, int year)
    {
        _day = day;
        _month = month;
        _year = year;
    }

    public int get_day()
    {
        return _day;
    }

    public int get_month()
    {
        return _month;
    }

    public int get_year()
    {
        return _year;
    }

    private int _day;
    private int _month;
    private int _year;
}
