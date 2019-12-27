package Task1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayUI
{
    private int _menuSize;
    private ArrayList<String> _menuItems;

    private Scanner _consoleScanner;

    public ArrayUI(ArrayList<String> menuItems)
    {
        _menuSize = menuItems.size();
        _menuItems = menuItems;

        _consoleScanner = new Scanner(System.in);
    }

    public MenuItem AskMenuItemFromUser()
    {
        for (int i = 0; i < _menuSize; i++)
        {
            System.out.print(i);
            System.out.println(". " + _menuItems.get(i));
        }

        int userInput;

        while (true)
        {
            try
            {
                userInput = Integer.parseInt(_consoleScanner.next());

                if (0 <= userInput && userInput < _menuSize)
                    break;
                else
                    System.out.println("Unrecognized input, try again:");
            }
            catch (NumberFormatException e)
            {
                System.out.println("Unrecognized input, try again:");
            }
        }

        return MenuItem.values()[userInput];
    }

    public String ReadString()
    {
        return _consoleScanner.next();
    }

    public void Write(String string)
    {
        System.out.println(string);
    }


    public double[] ReadRealArray()
    {
        return new double[0];//TODO
    }

    public void Write(double[] realArray)
    {
        StringBuilder result = new StringBuilder();

        for (var number : realArray)
            result.append(number).append(", ");

        result.delete(result.length() - 2, result.length() - 1);

        System.out.println(result.toString());
    }
}
