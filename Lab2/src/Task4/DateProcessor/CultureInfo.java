package Task4.DateProcessor;

import Task4.DateProcessor.DateFormatters.*;
import Task4.DateProcessor.Exceptions.InvalidCountryNameException;

public class CultureInfo
{
    public CultureInfo(String countryName)
            throws InvalidCountryNameException
    {
        switch (countryName)
        {
            case "USA":
                _dateFormatter = new USADateFormatter();
                break;

            case "Japan":
                _dateFormatter = new JapanDateFormatter();
                break;

            case "Denmark":
                _dateFormatter = new DenmarkDateFormatter();
                break;

            default:
                throw new InvalidCountryNameException();
        }
    }

    private IDateFormatter _dateFormatter;
    public IDateFormatter DateFormatter()
    {
        return _dateFormatter;
    }
}
