package Task1.UI;

import java.util.ArrayList;

public enum MenuItem
{
    FillArrayRandomly,
    ReadArray,
    ShowArray,
    Do1,
    Do2,
    Exit;

    public static ArrayList<String> GetNames()
    {
        ArrayList<String> names = new ArrayList<>();

        names.add("Fill array randomly");
        names.add("Read array");
        names.add("Show array");
        names.add("Do 1");
        names.add("Do 2");
        names.add("Exit");

        return names;
    }
}
