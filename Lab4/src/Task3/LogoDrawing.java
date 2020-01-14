package Task3;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class LogoDrawing
        extends Canvas
{
    private Random _gen = new Random();
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        
        int shapesCount = _gen.nextInt(20) + 1;
        
        for (var i = 0; i < shapesCount; ++i)
        {
            var shapeType = _gen.nextInt(4);
            
            switch (shapeType)
            {
                case 0:
                    DrawRandomLine(g);
                    break;
    
                case 1:
                    DrawRandomRect(g);
                    break;
                    
                case 2:
                    DrawRandomOval(g);
                    break;
                    
                case 3:
                    DrawRandomPolygon(g);
                    break;
                    
                default:
                    throw new RuntimeException("PANIC!");
            }
        }
        
        g.setColor(Color.black);
        g.setFont(g.getFont().deriveFont(25f));
        
        var text1 = "Skillful shape makers";
        var text2 = "Did Somebody Say \"Shape\"?";
    
        var bounds = g.getClipBounds();
        
        g.drawString(text1, (bounds.width - g.getFontMetrics().stringWidth(text1)) / 2, 50);
        g.drawString(text2, (bounds.width - g.getFontMetrics().stringWidth(text2)) / 2, bounds.height - 30);
    }
    
    
    private void DrawRandomLine(Graphics g)
    {
        var bounds = g.getClipBounds();
        
        g.setColor(new Color((int)(Math.random() * 0x1000000)));
        g.drawLine(_gen.nextInt(bounds.width), _gen.nextInt(bounds.height), _gen.nextInt(bounds.width), _gen.nextInt(bounds.height));
    }
    
    private void DrawRandomRect(Graphics g)
    {
        var bounds = g.getClipBounds();
        
        g.setColor(new Color((int)(Math.random() * 0x1000000)));
    
        var x = _gen.nextInt(bounds.width);
        var y = _gen.nextInt(bounds.height);
        var width = _gen.nextInt(bounds.width - x);
        var height = _gen.nextInt(bounds.height - y);
        g.drawRect(x, y, width, height);
    
        g.setColor(new Color((int)(Math.random() * 0x1000000)));
        g.fillRect(x, y, width, height);
    }
    
    private void DrawRandomOval(Graphics g)
    {
        var bounds = g.getClipBounds();
        
        g.setColor(new Color((int)(Math.random() * 0x1000000)));
        
        var x = _gen.nextInt(bounds.width);
        var y = _gen.nextInt(bounds.height);
        var width = _gen.nextInt(bounds.width - x);
        var height = _gen.nextInt(bounds.height - y);
        g.drawOval(x, y, width, height);
        
        g.setColor(new Color((int)(Math.random() * 0x1000000)));
        g.fillOval(x, y, width, height);
    }
    
    private void DrawRandomPolygon(Graphics g)
    {
        var bounds = g.getClipBounds();
        
        
        var pointsCount = _gen.nextInt(5) + 3;
        
        var pointsX = new int[pointsCount];
        var pointsY = new int[pointsCount];
    
        for (int i = 0; i < pointsCount; ++i)
        {
            pointsX[i] = _gen.nextInt(bounds.width);
            pointsY[i] = _gen.nextInt(bounds.height);
        }
        
        g.setColor(new Color((int)(Math.random() * 0x1000000)));
        g.drawPolygon(pointsX, pointsY, pointsCount);
    
        g.setColor(new Color((int)(Math.random() * 0x1000000)));
        g.fillPolygon(pointsX, pointsY, pointsCount);
    }
    
    
    public static void main(String[] args)
    {
        var window = new JFrame();
        window.setBounds(500, 200, 800, 600);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        window.add(new LogoDrawing());
        
        window.setVisible(true);
    }
}
