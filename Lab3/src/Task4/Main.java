package Task4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main
{
    private static double CalculateRPNExpression(String expr)
    {
        var stack = new Stack<Double>();
    
        String[] tokens = expr.split(" ");
        
        for (var token : tokens)
        {
            switch (token)
            {
                case "+":
                {
                    double second = stack.pop();
                    double first  = stack.pop();
            
                    stack.push(first + second);
                    break;
                }
                case "-":
                {
                    double second = stack.pop();
                    double first  = stack.pop();
            
                    stack.push(first - second);
                    break;
                }
                case "*":
                {
                    double second = stack.pop();
                    double first  = stack.pop();
            
                    stack.push(first * second);
                    break;
                }
                case "/":
                {
                    double second = stack.pop();
                    double first  = stack.pop();
            
                    stack.push(first / second);
                    break;
                }
                default:
                    stack.push(Double.parseDouble(token));
                    break;
            }
        }
        
        return stack.pop();
    }
    
    public static void main(String[] args)
            throws IOException
    {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        
        String mode;
        do
        {
            System.out.println("Select mode: 'console' or 'file':");
            mode = reader.readLine();
        }
        while (!mode.equals("console") && !mode.equals("file"));
    
        ArrayList<String> lines = new ArrayList<>();
        if (mode.equals("console"))
        {
            System.out.println("Enter RPN strings:");
        }
        else
        {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("data/RPN.txt")));
        }
    
        while (true)
        {
            String readLine = reader.readLine();
        
            //Stop reading if empty string read
            if (null == readLine || readLine.equals(""))
                break;
        
            lines.add(readLine);
        }
        
        for (var line : lines)
        {
            System.out.printf("%s == %f%n", line, CalculateRPNExpression(line));
        }
    }
}
