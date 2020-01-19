package Users;

import java.io.*;
import java.util.ArrayList;

class UsersSerializer
{
    private String _fileName;
    
    
    UsersSerializer()
    {
        _fileName = "data/users.dat";
    }
    
    ArrayList<AuthorizedUser> ReadUsers()
    {
        FileInputStream fileStream;
        try
        {
            fileStream = new FileInputStream(_fileName);
        }
        catch (FileNotFoundException e)
        {
            return new ArrayList<>();
        }
        
        ObjectInputStream inputStream;
        try
        {
            inputStream = new ObjectInputStream(fileStream);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return new ArrayList<>();
        }
        
        ArrayList<AuthorizedUser> readUsers;
        try
        {
            readUsers = (ArrayList<AuthorizedUser>)inputStream.readObject();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
            return new ArrayList<>();
        }
        
        return readUsers;
    }
    
    void WriteUsers(ArrayList<AuthorizedUser> users)
    {
        FileOutputStream fileStream = null;
        try
        {
            fileStream = new FileOutputStream(_fileName);
        }
        catch (FileNotFoundException e)
        {
            File x = new File(_fileName);
            try
            {
                x.createNewFile();
                fileStream = new FileOutputStream(_fileName);
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
                System.exit(-1);//PANIC
            }
        }
        
        ObjectOutputStream outputStream;
        try
        {
            outputStream = new ObjectOutputStream(fileStream);
            
            outputStream.writeObject(users);
            outputStream.flush();
            outputStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.exit(-1);//PANIC
        }
    }
}
