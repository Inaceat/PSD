package Task4.DateProcessor;

import java.util.ArrayList;

class DateValidator
{
    private static ArrayList<Integer> _daysInMonthOfNonLeapYear = new ArrayList<>();
    private static ArrayList<Integer> _daysInMonthOfLeapYear    = new ArrayList<>();

    static
    {
        _daysInMonthOfNonLeapYear.add(-1);//there is no 'zero' month
        _daysInMonthOfNonLeapYear.add(31);//1
        _daysInMonthOfNonLeapYear.add(28);//2 28 days in non-leap year
        _daysInMonthOfNonLeapYear.add(31);//3
        _daysInMonthOfNonLeapYear.add(30);//4
        _daysInMonthOfNonLeapYear.add(31);//5
        _daysInMonthOfNonLeapYear.add(30);//6
        _daysInMonthOfNonLeapYear.add(31);//7
        _daysInMonthOfNonLeapYear.add(31);//8
        _daysInMonthOfNonLeapYear.add(30);//9
        _daysInMonthOfNonLeapYear.add(31);//10
        _daysInMonthOfNonLeapYear.add(30);//11
        _daysInMonthOfNonLeapYear.add(31);//12

        _daysInMonthOfLeapYear.add(-1);//there is no 'zero' month
        _daysInMonthOfLeapYear.add(31);//1
        _daysInMonthOfLeapYear.add(29);//2 29 days in leap year
        _daysInMonthOfLeapYear.add(31);//3
        _daysInMonthOfLeapYear.add(30);//4
        _daysInMonthOfLeapYear.add(31);//5
        _daysInMonthOfLeapYear.add(30);//6
        _daysInMonthOfLeapYear.add(31);//7
        _daysInMonthOfLeapYear.add(31);//8
        _daysInMonthOfLeapYear.add(30);//9
        _daysInMonthOfLeapYear.add(31);//10
        _daysInMonthOfLeapYear.add(30);//11
        _daysInMonthOfLeapYear.add(31);//12
    }

    static boolean IsValid(int day, int month, int year)
    {
        //Validate year
        if (year < 1)
            return false;

        //Validate month
        if (month < 1 || 12 < month)
            return false;

        //Validate leap year Feb. 29'th
        boolean isLeapYear = (year % 4 == 0) && (year % 100 != 0);

        if (day < 1 || (isLeapYear ? _daysInMonthOfLeapYear : _daysInMonthOfNonLeapYear).get(month) < day)
            return false;
        
        return true;
    }
}
