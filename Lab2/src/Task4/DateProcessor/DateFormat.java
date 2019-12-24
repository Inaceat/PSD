package Task4.DateProcessor;

import java.util.regex.Pattern;

class DateFormat
{
    private static String[] _validDateElements = { "$D", "$M", "$Y" };
    private static Pattern _pattern;

    static
    {
        String patternString = "(.*?)" +//Beginning: some chars (or nothing)
                               "(" + _validDateElements[0] + ")" +//First date element as group
                               "(.*?)" +//Middle: some chars (or nothing)
                               "(" + _validDateElements[1] + ")" +//Second date element as group
                               "(.*?)" +//Middle: some chars (or nothing)
                               "(" + _validDateElements[2] + ")" +//Third date element as group
                               "(.*)";//Ending: some chars (or nothing)

        _pattern = Pattern.compile(patternString);
    }

    //Date in some format, $Y for year, $M for month, $D for day
    //Only one occurrence of each date element allowed.
    //For ex.: "$Y-$D-$M", "The $D of $M, $Y year."
    DateFormat(String formatString)
    {
        var matcher = _pattern.matcher(formatString);

        if (matcher.matches())
        {

        }
    }

    //Format stored in string as formattingString -- dateElement -- formattingString -- dateElement -- etc.
    //Where dateElement is some date element - day, month or year, in this case
    private String[] _formattingStrings = new String[4];
    private String[] _dateElements = new String[3];
}
