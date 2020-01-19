package Subject;

import Topic.TopicsList;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;

public class SubjectData
        implements Serializable
{
    private String _name;
    private String _teacherName;
    
    private String _profession;
    private int _studyYear;
    private int _term;
    
    private GregorianCalendar _beginDate;
    private GregorianCalendar _endDate;
    
    private int _lectureHours;
    private int _practiceHours;
    private int _labHours;
    
    private TopicsList _topics;
    
    
    SubjectData(String name, String teacherName,
                String profession, int studyYear, int term,
                String beginDate, String endDate,
                int lectureHours, int practiceHours, int labHours)
            throws IllegalArgumentException
    {
        SetName(name);
        SetTeacherName(teacherName);
        
        SetProfession(profession);
        SetStudyYear(studyYear);
        SetTerm(term);
    
        _beginDate = new GregorianCalendar();
        SetBeginDate(beginDate);
        _endDate = new GregorianCalendar();
        SetEndDate(endDate);
    
        SetLectureHours(lectureHours);
        SetPracticeHours(practiceHours);
        SetLabHours(labHours);
    
        _topics = new TopicsList();
    }
    
    
    public String Name()
    {
        return _name;
    }
    String TeacherName()
    {
        return _teacherName;
    }
    
    String Profession()
    {
        return _profession;
    }
    int StudyYear()
    {
        return _studyYear;
    }
    int Term()
    {
        return _term;
    }
    
    GregorianCalendar BeginDate()
    {
        return _beginDate;
    }
    GregorianCalendar EndDate()
    {
        return _endDate;
    }
    
    public int LectureHours()
    {
        return _lectureHours;
    }
    public int PracticeHours()
    {
        return _practiceHours;
    }
    public int LabHours()
    {
        return _labHours;
    }
    
    double LecturesPerWeek()
    {
        var weeksCount = ChronoUnit.WEEKS.between(_beginDate.toZonedDateTime(), _endDate.toZonedDateTime());
        
        return (double)_lectureHours / (2 * weeksCount);
    }
    double PracticesPerWeek()
    {
        var weeksCount = ChronoUnit.WEEKS.between(_beginDate.toZonedDateTime(), _endDate.toZonedDateTime());
    
        return (double)_practiceHours / (2 * weeksCount);
    }
    double LabsPerWeek()
    {
        var weeksCount = ChronoUnit.WEEKS.between(_beginDate.toZonedDateTime(), _endDate.toZonedDateTime());
    
        return (double)_labHours / (2 * weeksCount);
    }
    
    public TopicsList TopicsList()
    {
        return _topics;
    }
    
    
    
    void SetName(String name)
    {
        _name = name;
    }
    void SetTeacherName(String teacherName)
    {
        _teacherName = teacherName;
    }
    
    void SetProfession(String profession)
    {
        _profession = profession;
    }
    void SetStudyYear(int studyYear)
    {
        if (studyYear < 1)
            throw new IllegalArgumentException();
            
        _studyYear = studyYear;
    }
    void SetTerm(int term)
    {
        if (term != 1 && term != 2)
            throw new IllegalArgumentException();
    
        _term = term;
    }
    
    void SetBeginDate(String beginDate)
    {
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        
        Date newDate;
        
        try
        {
            newDate = format.parse(beginDate);
        }
        catch (ParseException e)
        {
            throw new IllegalArgumentException();
        }
        
        if (_endDate != null && _endDate.getTime().before(newDate))
        {
            throw new IllegalArgumentException();
        }
        
        _beginDate.setTime(newDate);
    }
    void SetEndDate(String endDate)
    {
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    
        Date newDate;
    
        try
        {
            newDate = format.parse(endDate);
        }
        catch (ParseException e)
        {
            throw new IllegalArgumentException();
        }
    
        if (_beginDate != null && _beginDate.getTime().after(newDate))
        {
            throw new IllegalArgumentException();
        }
    
        _endDate.setTime(newDate);
    }
    
    void SetLectureHours(int lectureHours)
    {
        if (lectureHours < 1 || lectureHours % 2 != 0)
            throw new IllegalArgumentException();
        
        _lectureHours = lectureHours;
    }
    void SetPracticeHours(int practiceHours)
    {
        if (practiceHours < 0 || practiceHours % 2 != 0)
            throw new IllegalArgumentException();
    
        _practiceHours = practiceHours;
    }
    void SetLabHours(int labHours)
    {
        if (labHours < 0 || labHours % 2 != 0)
            throw new IllegalArgumentException();
        
        _labHours = labHours;
    }
}
