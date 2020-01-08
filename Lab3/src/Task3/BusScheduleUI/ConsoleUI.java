package Task3.BusScheduleUI;

import Task3.BusSchedule.BusRoute;
import Task3.BusSchedule.DayOfWeek;
import Task3.BusSchedule.DayTime;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUI
{
    private int _menuSize;
    private ArrayList<String> _menuItems;

    private Scanner _consoleScanner;

    public ConsoleUI(ArrayList<String> menuItems)
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
    
    
    public int ReadInteger(int min, int max)
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
    
    public String ReadString()
    {
        String userInput;
        do
        {
            userInput = _consoleScanner.next();
        }
        while (userInput.trim().isEmpty());
    
        return userInput;
    }
    
    public DayOfWeek ReadDayOfWeek()
    {
        DayOfWeek userInput;
        while (true)
        {
            try
            {
                userInput = DayOfWeek.valueOf(_consoleScanner.next());
                break;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Unrecognized input, try again:");
            }
        }
    
        return userInput;
    }
    
    public BusRoute ReadRoute()
    {
        Write("Day:");
        DayOfWeek day = ReadDayOfWeek();
        
        
        Write("Departure point:");
        String departurePoint = ReadString();
    
        Write("Arrival point:");
        String arrivalPoint = ReadString();
    
        
        Write("Departure time:");
        DayTime departureTime = ReadDayTime();
    
        Write("Arrival time:");
        DayTime arrivalTime = ReadDayTime();
        
        
        return new BusRoute(day, departurePoint, arrivalPoint, departureTime, arrivalTime);
    }
    
    private DayTime ReadDayTime()
    {
        Write("Hours:");
        int hours = ReadInteger(0, 23);
    
        Write("Minutes:");
        int minutes = ReadInteger(0, 59);
        
        return new DayTime(hours, minutes);
    }
    
    
    public void Write(ArrayList<BusRoute> routesList)
    {
        System.out.printf("%3s %-10s %15s %15s %11s %11s %11s%n", "#", "Day", "From", "To", "Departure", "Arrival", "Travel time");
    
        int index = 1;
        
        for (var route : routesList)
        {
            System.out.printf("%3d %-10s %15s %15s %11s %11s %11s%n",
                              index++,
                              route.DayOfWeek(),
                              route.DeparturePoint(),
                              route.ArrivalPoint(),
                              route.DepartureTime().toString(),
                              route.ArrivalTime().toString(),
                              route.ArrivalTime().TimeFrom(route.DepartureTime()).toString());
        }
    
        System.out.println();
    }
    
    public void Write(String string)
    {
        System.out.println(string);
    }
}
