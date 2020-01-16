package Task4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.DoubleFunction;

public class FunctionPlotter
        extends JFrame
{
    private JPanel _contentPane;
    
    private JLabel   _parametersHint;
    private JTextField _aParamInput;
    private JTextField _bParamInput;
    private JTextField _cParamInput;
    private JTextField _dParamInput;
    
    private JLabel   _argumentHint;
    private JTextField _minArgumentInput;
    private JTextField _maxArgumentInput;
    
    private JButton _plotButton;
    
    
    private FunctionPlotter()
    {
        super();
        setBounds(600, 300, 170, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
        _contentPane = new JPanel();
    
        _parametersHint = new JLabel("Parameters:");
        _aParamInput = new JTextField("1");
        _aParamInput.setPreferredSize(new Dimension(100, 20));
        _bParamInput = new JTextField("1");
        _bParamInput.setPreferredSize(new Dimension(100, 20));
        _cParamInput = new JTextField("1");
        _cParamInput.setPreferredSize(new Dimension(100, 20));
        _dParamInput = new JTextField("1");
        _dParamInput.setPreferredSize(new Dimension(100, 20));
    
        _argumentHint = new JLabel("Argument:");
        _minArgumentInput = new JTextField("0.8");
        _minArgumentInput.setPreferredSize(new Dimension(100, 20));
        _maxArgumentInput = new JTextField("10");
        _maxArgumentInput.setPreferredSize(new Dimension(100, 20));
    
        _plotButton = new JButton("Plot this");
        _plotButton.addActionListener(e -> OnPlotPress());
        
        _contentPane.add(_parametersHint);
        _contentPane.add(_aParamInput);
        _contentPane.add(_bParamInput);
        _contentPane.add(_cParamInput);
        _contentPane.add(_dParamInput);
    
        _contentPane.add(_argumentHint);
        _contentPane.add(_minArgumentInput);
        _contentPane.add(_maxArgumentInput);
    
        _contentPane.add(_plotButton);
    
        setContentPane(_contentPane);
    }
    
    
    private void OnPlotPress()
    {
        double aParam;
        double bParam;
        double cParam;
        double dParam;
    
        double minArgument;
        double maxArgument;
        
        try
        {
            aParam = Double.parseDouble(_aParamInput.getText());
            bParam = Double.parseDouble(_bParamInput.getText());
            cParam = Double.parseDouble(_cParamInput.getText());
            dParam = Double.parseDouble(_dParamInput.getText());
    
            minArgument = Double.parseDouble(_minArgumentInput.getText());
            maxArgument = Double.parseDouble(_maxArgumentInput.getText());
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Wrong input");
            return;
        }
    
        if (minArgument >= maxArgument)
        {
            JOptionPane.showMessageDialog(this, "Wrong input");
            return;
        }
        
        var plot = new JFrame();
        plot.setBounds(500, 200, 800, 600);
        plot.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    
        plot.add(new FunctionPlot(CreateFunction(aParam, bParam, cParam, dParam), minArgument, maxArgument));
    
        plot.setVisible(true);
    }
    
    private DoubleFunction<Double> CreateFunction(double a, double b, double c, double d)
    {
        return x ->
                a * Math.cos(b*x) + c * Math.log(d*x*x + 1);
    }
    
    
    public static void main(String[] args)
    {
        //https://www.desmos.com/calculator/nirqnvhkm9
        var mainWindow = new FunctionPlotter();
        mainWindow.setVisible(true);
    }
}
