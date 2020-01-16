package Task4;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.DoubleFunction;

class FunctionPlot
        extends Canvas
{
    private DoubleFunction<Double> _function;
    private double                 _minX;
    private double                 _maxX;
    
    FunctionPlot(DoubleFunction<Double> foo, double minArgument, double maxArgument)
    {
        super();
        
        _function = foo;
        
        _minX = minArgument;
        _maxX = maxArgument;
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        
        var bounds = g.getClipBounds();
        
        g.drawLine(20, bounds.height - 20, bounds.width - 20, bounds.height - 20);
        g.drawLine(20, bounds.height - 20, 20, 20);
        
        int dotsCount = bounds.width - 40;
        double deltaX = (_maxX - _minX) / dotsCount;
    
        double[] values = new double[dotsCount];
        for (int i = 0; i < dotsCount; i++)
        {
            values[i] = _function.apply(_minX + deltaX * i);
        }
        
        double minY = Arrays.stream(values).min().getAsDouble();
        double maxY = Arrays.stream(values).max().getAsDouble();
    
        int[] args = new int[dotsCount];
        int[] vals = new int[dotsCount];
        
        double p1 = (bounds.height - 40) / (maxY - minY);
        
        for (int i = 0; i < dotsCount; i++)
        {
            args[i] = 20 + i;
    
            vals[i] = bounds.height - 20 - (int)(p1 * (values[i] - minY));
        }
        
        g.drawPolyline(args, vals, dotsCount);
        
        g.drawString(String.valueOf(_minX),20, bounds.height - 5);
        g.drawString(String.valueOf(_maxX),bounds.width - 50, bounds.height - 5);
    
        g.drawString(String.valueOf(minY),0, bounds.height - 20);
        g.drawString(String.valueOf(maxY),0, 20);
    }
}
