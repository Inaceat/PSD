public class CosHSeriesCalc
{
    public static void main(String args[])
    {
        if(args.length == 2)
        {
            try
            {
                double x = Double.parseDouble(args[0]);
                double eps = Double.parseDouble(args[1]);
                
                int n = 0;
                double current = 1;
                double result = current;
                
                while(Math.abs(current) > Math.abs(eps))
                {
                    n++;
                    current = current * ( x*x / ((2*n-1)*2*n) );
                    result = result + current;
                    
                    System.out.println(n + " : " + current);
                }
                
                System.out.println("\nMy cosh x =   " + result);
                System.out.println("Real cosh x = " + Math.cosh(x));
            }
            catch(NumberFormatException e)
            {
                System.out.println("Parameters should be numbers");
            }
        }
        else
        {
            System.out.println("Usage: CosHSeriesCalc x eps");
        }
    }
}