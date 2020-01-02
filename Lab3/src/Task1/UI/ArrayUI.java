package Task1.UI;

import java.util.ArrayList;
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

        int userInput = ReadInteger(0, _menuSize - 1);

        return MenuItem.values()[userInput];
    }
    
    
    public int ReadArraySize()
    {
        System.out.println("Enter array size:");
    
        return ReadInteger(1, Integer.MAX_VALUE);
    }
    
    public double[] ReadRealArray()
    {
        int size = ReadArraySize();
    
        double[] array = new double[size];
    
        for (int i = 0; i < size; i++)
        {
            array[i] = ReadDouble();
        }
        
        return array;
    }
    
    
    public void Write(String string)
    {
        System.out.println(string);
    }
    
    public void Write(double[] realArray)
    {
        StringBuilder result = new StringBuilder();

        for (var number : realArray)
            result.append(number).append(", ");

        result.delete(result.length() - 2, result.length() - 1);

        System.out.println(result.toString());
    }
    
    
    private int ReadInteger(int min, int max)
    {
        int userInput;
        while (true)
        {
            try
            {
                userInput = Integer.parseInt(_consoleScanner.next());
            
                if (min <= userInput && userInput <= max)
                    break;
                else
                    System.out.println("Wrong input, try again:");
            }
            catch (NumberFormatException e)
            {
                System.out.println("Unrecognized input, try again:");
            }
        }
        
        return userInput;
    }
    
    private double ReadDouble()
    {
        double userInput;
        while (true)
        {
            try
            {
                userInput = Double.parseDouble(_consoleScanner.next());
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Unrecognized input, try again:");
            }
        }
        
        return userInput;
    }
}
