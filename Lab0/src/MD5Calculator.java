public class MD5Calculator
{
    public static void main(String args[])
    {
        for(String arg : args)
        {
            System.out.println("\"" + arg + "\" => " + HashCode.md5(arg));
        }
    }
} 