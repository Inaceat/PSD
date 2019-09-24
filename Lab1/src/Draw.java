
import by.vsu.mf.ai.ssd.painting.Painter;

public class Draw
{
    static double f1(double fi)
    {
        return fi/(Math.PI*2);
    }
    
    static double f2(double fi)
    {
        var cosFi = Math.cos(fi);
        
        return (cosFi*cosFi + 1) / 2;
    }
    
    
    public static void main(String args[])
    {        
        if(args.length == 1)
        {
            double min = 0;
            double max = 2*Math.PI;
            double delta = Double.parseDouble(args[0]);
            
            int size = (int)Math.floor(max / delta);
            
            var coords = new double[size][2][2];
            for(int i = 0; i < size; ++i)
            {
                //begin, x,y
                coords[i][0][0] = f1(min + delta*i)*Math.cos(min + delta*i);
                coords[i][0][1] = f1(min + delta*i)*Math.sin(min + delta*i);
                
                //end, x,y
                coords[i][1][0] = f2(min + delta*i)*Math.cos(min + delta*i);
                coords[i][1][1] = f2(min + delta*i)*Math.sin(min + delta*i);
            }
            
            var colors = new short[size][3];
            for(int i = 0; i < size; ++i)
                {
                    colors[i][0] = (short)((min + delta*i)*255/(2*Math.PI));   //R
                    colors[i][1] = (short)((min + delta*i)*255/(2*Math.PI)); //G
                    colors[i][2] = (short)((min + delta*i)*255/(2*Math.PI));   //B
                }
            
            
            Painter.paint(600,400, coords, colors);
        }
        else
        {
            System.out.println("Usage: Draw delta");
        }
    }
}