import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.lang.NumberFormatException;

public class Runner
{
    private static final String DEFAULT_ENCODING="KOI8-R";
    private static String encoding=null;
    private static BufferedWriter writer=null;
    
    public static void out(String str) throws IOException
    {
        if(writer==null)
        {
            if(encoding==null)
            {
                encoding=DEFAULT_ENCODING;
            }
            
            writer=new BufferedWriter(new OutputStreamWriter(System.out, encoding));
        }
        writer.write(str);
        writer.flush();
    }
    
    public static void main(String args[])throws IOException
    {
        try
        {
            if(args.length > 0)
            {
                int start=0;
                if("-encoding".equals(args[0]))
                {
                    if(args.length>1)
                    {
                        encoding=args[1];
                        if(args.length>2)
                        {
                            start=2;
                        }
                        else
                        {
                            out("Программа выводит в консоль последовательность\n");
                            out("русских букв, заданных порядковыми номерами в\n");
                            out("алфавите.\n\n");
                            out("Использование:\n");
                            out("\tjava Runner [-encoding <encoding>] <numbers>\n\n");
                            out("где:\n\n");
                            out("\t-encoding <encoding>  кодировка символов,\n");
                            out("\t                      используемая при выводе в\n");
                            out("\t                      консоль\n\n");
                            out("\t<numbers>             Последовательность целых\n");
                            out("\t                      чиселв диапазоне от 1\n");
                            out("\t                      до 32. Каждое число это\n");
                            out("\t                      порядковый номер буквы в\n");
                            out("\t                      русском алфавите\n\n");
                            return;
                        }
                    }
                    else
                    {
                        out("too few parameters, try to run program\n");
                        out("without parameters to get help.\n\n");
                        return;
                    }
                }
                try
                {
                    for(int i=start; i<args.length; i++)
                    {
                        int n=Integer.parseInt(args[i]);
                        if(1<=n&&n<=32)
                        {
                            char letter=(char)('А'+n-1);
                            out(String.valueOf(letter));
                        }
                        else
                        {
                            throw new NumberFormatException();
                        }
                    }
                }
                catch(NumberFormatException e)
                {
                    out("Incorrect number. Run class without\n");
                    out("parameters to get help.\n\n");
                    out("Некорректное число. Запустите класс\n");
                    out("с параметром\n");           
                    out("-encoding <кодировка консоли>\n"); 
                    out("и без других параметров,\n");
                    out("чтобы получить справку\n\n");
                }
            }
            else
            {
                out("Program write to the console sequence of the Russian\n");
                out("letters which have been set by serial numbers in the\n");
                out("alphabet.\n\n");
                out("Usage:\n");
                out("\tjava Runner [-encoding <encoding>] <numbers>\n\n");
                out("where:\n\n");
                out("\t-encoding <encoding>  Specify character encoding\n");
                out("\t                      used by console output\n\n");
                out("\t<numbers>             Sequence of integer numbers\n");
                out("\t                      in the range from 1 to 32.\n");
                out("\t                      Each number is a serial\n");
                out("\t                      number of a letter in the\n");
                out("\t                      Russian alphabet\n\n");
            }
        }
        catch(IOException e)
        {
            System.err.println("specified encoding");
            System.err.println("is not supported");
        }
    }
}