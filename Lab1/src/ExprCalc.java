public class ExprCalc
{
    public static void main(String args[])
    {
        if(args.length == 3)
        {
            try
            {
                double a = Double.parseDouble(args[0]);
                double b = Double.parseDouble(args[1]);
                double c = Double.parseDouble(args[2]);
                
                System.out.println( (a-b)/(2*c+1) );
            }
            catch(NumberFormatException e)
            {
                System.out.println("Parameters should be numbers");
            }
        }
        else
        {
            System.out.println("Usage: ExprCalc a b c");
        }
    }
}