package Task3;

import by.vsu.mf.ai.ssd.strings.Job;
import by.vsu.mf.ai.ssd.strings.Manager;

import java.util.regex.Pattern;

public class AnotherStringChanger implements Job
{
    public static void main(String[] args)
    {
        Manager.createWindow(new AnotherStringChanger());
    }
    
    @Override
    public void perform(StringBuilder stringBuilder)
    {
        /*
        (
            (                   number from 0 to 255:
                [0-9] |             0 to 9
                [1-9][0-9] |        10 to 99
                1[0-9]{2} |         100 to 199
                2[0-4][0-9] |       200 to 249
                25[0-5]             250 to 255
            ) \.                then dot
        ){3}                    3 times
        (                       number from 0 to 255 again
            [0-9] |
            [1-9][0-9] |
            1[0-9]{2} |
            2[0-4][0-9] |
            25[0-5]
        )
        (
            [^0-9] |            not a number
            $                   or end of line
        )
        */
        var ipPattern = Pattern.compile(
                "(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])([^0-9]|$)");
        
        stringBuilder.replace(0, stringBuilder.length(), ipPattern.matcher(stringBuilder).replaceAll("\\${$0}"));
    }
}
