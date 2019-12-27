package Task1;

import java.util.ArrayList;

public enum MenuItem
{
    Exit,
    PrintHello,
    Echo;

    public static ArrayList<String> GetNames()
    {
        ArrayList<String> names = new ArrayList<>();

        names.add("Exit");
        names.add("Print Hello");
        names.add("Echo");

        return names;
    }
}
