package Task1.TimeCalcGUI;

import javax.swing.*;
import java.awt.*;

public class TimeCalcMainWindow
        extends JFrame
{
    private JPanel _contentPane;
    
    private JTextField _timeInput;
    private JTextField _minutesInput;
    private JTextField _timeOutput;
    
    private JButton _calculateButton;
    
    public TimeCalcMainWindow()
    {
        super("Time calculator");
    
        _contentPane = new JPanel();
        
        _timeInput = new JTextField();
        _timeInput.setText("time");
        _timeInput.setHorizontalAlignment(SwingConstants.RIGHT);
        _timeInput.setPreferredSize(new Dimension(100, 30));
    
        _minutesInput = new JTextField();
        _minutesInput.setText("minutes");
        _minutesInput.setHorizontalAlignment(SwingConstants.RIGHT);
        _minutesInput.setPreferredSize(new Dimension(100, 30));
    
        _timeOutput = new JTextField();
        _timeOutput.setText("");
        _timeOutput.setHorizontalAlignment(SwingConstants.RIGHT);
        _timeOutput.setPreferredSize(new Dimension(100, 30));
        _timeOutput.setEnabled(false);
    
        _calculateButton = new JButton("Calc");
        
        _contentPane.add(_timeInput);
        _contentPane.add(_minutesInput);
        _contentPane.add(_calculateButton);
        _contentPane.add(_timeOutput);
        
        setContentPane(_contentPane);
        setBounds(600, 300, 400, 200);
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
