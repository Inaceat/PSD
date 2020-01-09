package Task1.TimeCalculatorGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TimeCalcMainWindow
        extends JFrame
{
    private JPanel _contentPane;
    
    private JTextField _timeInput;
    private JTextField _minutesInput;
    private JTextField _timeResult;
    
    private JButton _calculateButton;
    
    public TimeCalcMainWindow()
    {
        super("Time calculator: subtract minutes");
    
        _contentPane = new JPanel();
        
        _timeInput = new JTextField();
        _timeInput.setText("time");
        _timeInput.setHorizontalAlignment(SwingConstants.RIGHT);
        _timeInput.setPreferredSize(new Dimension(100, 30));
    
        _minutesInput = new JTextField();
        _minutesInput.setText("minutes");
        _minutesInput.setHorizontalAlignment(SwingConstants.RIGHT);
        _minutesInput.setPreferredSize(new Dimension(100, 30));
    
        _timeResult = new JTextField();
        _timeResult.setText("");
        _timeResult.setHorizontalAlignment(SwingConstants.RIGHT);
        _timeResult.setPreferredSize(new Dimension(100, 30));
        _timeResult.setEnabled(false);
    
        _calculateButton = new JButton("Calc");
        
        _contentPane.add(_timeInput);
        _contentPane.add(_minutesInput);
        _contentPane.add(_calculateButton);
        _contentPane.add(_timeResult);
        
        setContentPane(_contentPane);
        setBounds(600, 300, 400, 200);
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void Show()
    {
        setVisible(true);
    }
    public void AddCalcButtonListener(ActionListener listener)
    {
        _calculateButton.addActionListener(listener);
    }
    
    
    public String GetTimeInput()
    {
        return _timeInput.getText();
    }
    public String GetMinutesInput()
    {
        return _minutesInput.getText();
    }
    
    public void SetResult(String s)
    {
        _timeResult.setText(s);
    }
}
