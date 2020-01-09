package Task1.TimeCalcController;

import Task1.TimeCalculator.Time;
import Task1.TimeCalculator.TimeCalculator;
import Task1.TimeCalculatorGUI.TimeCalcMainWindow;

import javax.swing.*;
import java.util.regex.Pattern;

public class TimeCalcController
{
    private TimeCalcMainWindow _calcView;
    private TimeCalculator     _calculator;
    
    public TimeCalcController(TimeCalcMainWindow mainWindow, TimeCalculator calculator)
    {
        _calcView = mainWindow;
        _calculator = calculator;
        
        _calcView.AddCalcButtonListener(e -> OnCalcButtonPressed());
    }
    
    public void Start()
    {
        _calcView.Show();
    }
    
    private void OnCalcButtonPressed()
    {
        int minutes;
        try
        {
            minutes = Integer.parseInt(_calcView.GetMinutesInput());
        }
        catch (NumberFormatException e)
        {
            _calcView.SetResult("Wrong input");
            return;
        }
        
    
        var timePattern = Pattern.compile("^(\\d*?):(\\d*?)$");
        var matcher = timePattern.matcher(_calcView.GetTimeInput());
    
        if (!matcher.matches())
        {
            _calcView.SetResult("Wrong input");
            return;
        }
        
        int timeHours;
        int timeMinutes;
        try
        {
            timeHours = Integer.parseInt(matcher.group(1));
            timeMinutes = Integer.parseInt(matcher.group(2));
        }
        catch (NumberFormatException e)
        {
            _calcView.SetResult("Wrong input");
            return;
        }
    
        Time inputTime;
        try
        {
            inputTime = new Time(timeHours, timeMinutes);
        }
        catch (IllegalArgumentException e)
        {
            _calcView.SetResult("Wrong input");
            return;
        }
        
        Time result = _calculator.Subtract(inputTime, minutes);
        
        if (0 == minutes)
            _calcView.SetResult("Same time, lol");
        else
            _calcView.SetResult(minutes > 0 ? "Before" : "After");
    
        JOptionPane.showMessageDialog(_calcView, result.toString());
    }
}
