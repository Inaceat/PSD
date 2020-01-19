package Topic;

import Users.UserManager;

import javax.swing.table.AbstractTableModel;
import java.io.Serializable;
import java.util.ArrayList;

public class TopicsList
        extends AbstractTableModel
        implements Serializable
{
    private ArrayList<TopicData> _data;
    
    public TopicsList()
    {
        _data = new ArrayList<>();
    }
    
    void Add(TopicData subjectData)
    {
        _data.add(subjectData);
    }
    
    void RemoveAt(int topicIndex)
    {
        if (0 <= topicIndex && topicIndex < _data.size())
        {
            _data.remove(topicIndex);
        }
    }
    
    
    static private String[] columnNames =
            {
                    "Subject", "Topic",
                    "Lecture hours", "Practice hours", "Lab hours",
                    "Can be self-studied"
            };
    
    static private Class<?> [] columnDataClasses =
            {
                    String.class, String.class,
                    Integer.class, Integer.class, Integer.class,
                    Boolean.class
            };
    
    @Override
    public int getRowCount()
    {
        return _data.size();
    }
    
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }
    
    @Override
    public String getColumnName(int columnIndex)
    {
        return columnNames[columnIndex];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnDataClasses[columnIndex];
    }
    
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return UserManager.GetCurrentUser().IsTeacher() &&
               columnIndex != 0 && columnIndex != 5;
    }
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        switch (columnIndex)
        {
            case 0:
                return _data.get(rowIndex).SubjectName();
    
            case 1:
                return _data.get(rowIndex).Name();
                
            case 2:
                return _data.get(rowIndex).LectureHours();
                
            case 3:
                return _data.get(rowIndex).PracticeHours();
                
            case 4:
                return _data.get(rowIndex).LabHours();
                
            case 5:
                return _data.get(rowIndex).CanSelfStudy();
            
            default:
                return null;
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        try
        {
            switch (columnIndex)
            {
                case 1:
                    _data.get(rowIndex).SetName((String)aValue);
                    break;
        
                case 2:
                    _data.get(rowIndex).SetLectureHours((int)aValue);
                    break;
        
                case 3:
                    _data.get(rowIndex).SetPracticeHours((int)aValue);
                    break;
        
                case 4:
                    _data.get(rowIndex).SetLabHours((int)aValue);
                    break;
            }
        }
        catch (IllegalArgumentException ignored)//If new value is invalid, just ignore. Not the best way to solve problems.
        {}
        
        fireTableRowsUpdated(rowIndex, rowIndex);
    }
}
