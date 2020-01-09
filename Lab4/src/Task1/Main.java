package Task1;

import Task1.TimeCalcController.TimeCalcController;
import Task1.TimeCalculator.TimeCalculator;
import Task1.TimeCalculatorGUI.TimeCalcMainWindow;

public class Main
{
    public static void main(String[] args)
    {
        var mainWindow = new TimeCalcMainWindow();
        var calculator = new TimeCalculator();
        
        var timeCalcController = new TimeCalcController(mainWindow, calculator);
        
        timeCalcController.Start();
    }
}
