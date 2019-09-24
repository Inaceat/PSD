import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class HashCode
{
    public static String md5(String string)
    {
        MessageDigest digest;
        try
        {
            digest = MessageDigest.getInstance("md5");             
            digest.reset();             
            digest.update(string.getBytes()); 
            byte hash[] = digest.digest();             
            Formatter formatter = new Formatter(); 
            
            for(int i = 0; i < hash.length; i++)
            {
                formatter.format("%02X", hash[i]);             
            }

            String md5summ = formatter.toString();             
            formatter.close(); 
            return md5summ;         
        }
        catch(NoSuchAlgorithmException e) 
        {
            return null;
        }
    }
}