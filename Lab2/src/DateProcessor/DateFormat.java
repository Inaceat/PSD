package DateProcessor;

class DateFormat
{
    //Date in some format, $Y for year, $M for month, $D for day
    //Only one occurrence of each date element allowed.
    //For ex.: "$Y-$D-$M", "The $D of $M, $Y year."
    DateFormat(String format)
    {

    }

    //Date stored in string as prefix-$?-leftMiddle-$?-rightMiddle-$?-suffix
    //Where $? is some date element - day, month or year
    private String _prefix;
    private String _leftMiddle;
    private String _rightMiddle;
    private String _suffix;
}
