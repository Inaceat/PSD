package Task1.Work;

import java.util.Arrays;
import java.util.Random;
import java.util.function.DoublePredicate;

public class ArrayWorker
{
    private double[] _array;
    
    public void SetRandomArray(int arraySize)
    {
        _array = new double[arraySize];
    
        var generator = new Random();
        
        for (int i = 0; i < arraySize; i++)
        {
            _array[i] = generator.nextDouble() * 200 - 100;//Random double ~ from [-100; 100)
        }
    }
    
    public void SetArray(double[] array)
    {
        _array = array;
    }
    
    public double[] GetArray()
    {
        return _array;
    }
    
    //Product of elements between first and last elements X : |X - Pi| < 10^-5 (3.1415926)
    public double Do1()
    {
        int beginIndex = 0;
        int endIndex = _array.length - 1;
    
        for (; beginIndex < _array.length; ++beginIndex)
        {
            if (Math.abs(_array[beginIndex] - Math.PI) < 0.00001)
                break;
        }
    
        for (; endIndex > -1; --endIndex)
        {
            if (Math.abs(_array[endIndex] - Math.PI) < 0.00001)
                break;
        }
    
        if (beginIndex >= endIndex)
            return Double.NaN;
        
        double result = 1;
        
        for (int i = beginIndex + 1; i < endIndex; i++)
        {
            result *= _array[i];
        }
        
        return result;
    }
    
    //Remove elements which integer part has equal sums of even and odd digits
    public void Do2()
    {
        DoublePredicate criteria = ((double x) ->
        {
            var intPart = (long) Math.abs(x);
            
            var numString = new StringBuilder().append(intPart).reverse().toString();
            
            int evenSum = 0;
            int oddSum = 0;
    
            for (int i = 0; i < numString.length(); i += 2)
            {
                oddSum += numString.charAt(i) - '0';
            }
    
            for (int i = 1; i < numString.length(); i += 2)
            {
                evenSum += numString.charAt(i) - '0';
            }
            
            return evenSum != oddSum;
        });
        
        _array = Arrays.stream(_array).filter(criteria).toArray();
    }
}
