package DateProcessor;

import java.util.HashMap;

class CultureDateInfo
{
    private static HashMap<String, DateFormat> _availableCultures;

    static void AddCulture(String countryName, DateFormat dateFormat)
    {
        _availableCultures.put(countryName, dateFormat);
    }


    private String _currentCultureCountryName;

    CultureDateInfo(String countryName)
            throws Exception
    {
        if (!_availableCultures.containsKey(countryName))
            throw new Exception("AAAAA");//TODO here

        _currentCultureCountryName = countryName;
    }


    Date TryParseDate(String readDateString)
            //throws Exception
    {
        return new Date(1, 1, 1);//TODO
    }
}
