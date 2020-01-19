package Subject;

import Users.UserManager;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

class SubjectsList
        extends AbstractTableModel
{
    private ArrayList<SubjectData> _data;
    private SubjectsSerializer _serializer;
    
    SubjectsList()
    {
        _serializer = new SubjectsSerializer();
        
        _data = _serializer.ReadSubjects();
    }
    
    void Add(SubjectData subjectData)
    {
        _data.add(subjectData);
        
        Save();
    }
    
    SubjectData At(int subjectIndex)
    {
        return _data.get(subjectIndex);
    }
    
    void RemoveAt(int subjectIndex)
    {
        if (0 <= subjectIndex && subjectIndex < _data.size())
        {
            _data.remove(subjectIndex);
            
            Save();
        }
    }
    
    
    static private String[] columnNames =
            {
                    "Subject", "Teacher",
                    "Profession", "Study year", "Term",
                    "Begin date", "End date",
                    "Lecture hours", "Practice hours", "Lab hours",
                    "Lectures per week", "Practices per week", "Labs per week"
            };
    
    static private Class<?> [] columnDataClasses =
            {
                    String.class, String.class,
                    String.class, Integer.class, Integer.class,
                    String.class, String.class,
                    Integer.class, Integer.class, Integer.class,
                    Double.class,  Double.class, Double.class
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
               columnIndex != 10 && columnIndex != 11 && columnIndex != 12;
    }
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        switch (columnIndex)
        {
            case 0:
                return _data.get(rowIndex).Name();
    
            case 1:
                return _data.get(rowIndex).TeacherName();
                
            case 2:
                return _data.get(rowIndex).Profession();
                
            case 3:
                return _data.get(rowIndex).StudyYear();
                
            case 4:
                return _data.get(rowIndex).Term();
                
            case 5:
                return String.format("%1$td.%1$tm.%1$tY", _data.get(rowIndex).BeginDate());
    
            case 6:
                return String.format("%1$td.%1$tm.%1$tY", _data.get(rowIndex).EndDate());
    
            case 7:
                return _data.get(rowIndex).LectureHours();
    
            case 8:
                return _data.get(rowIndex).PracticeHours();
    
            case 9:
                return _data.get(rowIndex).LabHours();
    
            case 10:
                return _data.get(rowIndex).LecturesPerWeek();
    
            case 11:
                return _data.get(rowIndex).PracticesPerWeek();
    
            case 12:
                return _data.get(rowIndex).LabsPerWeek();
            
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
                case 0:
                    _data.get(rowIndex).SetName((String)aValue);
        
                case 1:
                    _data.get(rowIndex).SetTeacherName((String)aValue);
                    break;
        
                case 2:
                    _data.get(rowIndex).SetProfession((String)aValue);
                    break;
        
                case 3:
                    _data.get(rowIndex).SetStudyYear((int)aValue);
                    break;
        
                case 4:
                    _data.get(rowIndex).SetTerm((int)aValue);
                    break;
        
                case 5:
                    _data.get(rowIndex).SetBeginDate((String)aValue);
                    break;
        
                case 6:
                    _data.get(rowIndex).SetEndDate((String)aValue);
                    break;
        
                case 7:
                    _data.get(rowIndex).SetLectureHours((int)aValue);
                    break;
        
                case 8:
                    _data.get(rowIndex).SetPracticeHours((int)aValue);
                    break;
        
                case 9:
                    _data.get(rowIndex).SetLabHours((int)aValue);
                    break;
            }
        }
        catch (IllegalArgumentException ignored)//If new value is invalid, just ignore. Not the best way to solve problems.
        {}
        
        fireTableRowsUpdated(rowIndex, rowIndex);
    }
    
    void Save()
    {
        _serializer.WriteSubjects(_data);
    }
}
