import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StringSorter
{
    
    public static void main(String[] args)
            throws IOException
    {
        //Reading strings
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        
        System.out.println("Enter strings:");
        
        String readString;
        var strings = new ArrayList<String>();
        
        while (true)
        {
            readString = reader.readLine();
            
            if (readString.equals(""))
                break;
            
            strings.add(readString);
        }
        
        //Sort by length
        strings.sort((s1, s2) -> s1.length() - s2.length());
        
        System.out.println("Sorted by length:");
        for (var s : strings)
            System.out.println("  " + s);
        
        //Sort by lower-case letters number
        //Assuming numbers are short enough to fit int. Or "toIntExact" will throw "ArithmeticException"
        strings.sort((s1, s2) -> Math.toIntExact(s1.chars().filter(ch -> Character.isLowerCase(ch)).count() -
                                                 s2.chars().filter(ch -> Character.isLowerCase(ch)).count()));
        
        System.out.println("Sort by lower-case letters number:");
        for (var s : strings)
            System.out.println("  " + s);
    }
}
