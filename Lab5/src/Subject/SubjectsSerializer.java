package Subject;

import java.io.*;
import java.util.ArrayList;

class SubjectsSerializer
{
    private String _fileName;
    
    
    SubjectsSerializer()
    {
        _fileName = "data/subjects.dat";
    }
    
    ArrayList<SubjectData> ReadSubjects()
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
    
        ArrayList<SubjectData> readSubjects;
        try
        {
            readSubjects = (ArrayList<SubjectData>)inputStream.readObject();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
            return new ArrayList<>();
        }
        
        return readSubjects;
    }
    
    void WriteSubjects(ArrayList<SubjectData> subjects)
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
            
            outputStream.writeObject(subjects);
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
