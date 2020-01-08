package Task3.BusSchedule;

import java.io.*;
import java.util.ArrayList;

class ScheduleSerializer
{
    private String _fileName;
    
    
    ScheduleSerializer()
    {
        _fileName = "data/schedule.dat";
    }
    
    ArrayList<BusRoute> ReadSchedule()
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
    
        BusSchedule readSchedule;
        try
        {
            readSchedule = (BusSchedule)inputStream.readObject();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
            return new ArrayList<>();
        }
    
        return readSchedule.RoutesList();
    }
    
    void WriteSchedule(BusSchedule schedule)
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
            
            outputStream.writeObject(schedule);
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
