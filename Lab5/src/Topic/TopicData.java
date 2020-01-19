package Topic;

import Subject.SubjectData;

import java.io.Serializable;

public class TopicData
        implements Serializable
{
    private String _name;
    
    private SubjectData _subject;
    
    private int _lectureHours;
    private int _practiceHours;
    private int _labHours;
    
    
    TopicData(SubjectData subject, String name, int lectureHours, int practiceHours, int labHours)
    {
        if (null == subject)
            throw new IllegalArgumentException();
        else
            _subject = subject;
        
        SetName(name);
    
        SetLectureHours(lectureHours);
        SetPracticeHours(practiceHours);
        SetLabHours(labHours);
    }
    
    
    public String Name()
    {
        return _name;
    }
    
    String SubjectName()
    {
        return _subject.Name();
    }
    
    int LectureHours()
    {
        return _lectureHours;
    }
    int PracticeHours()
    {
        return _practiceHours;
    }
    int LabHours()
    {
        return _labHours;
    }
    
    boolean CanSelfStudy()
    {
        return 0.15 * _subject.LectureHours() >= _lectureHours &&
               0.15 * _subject.PracticeHours() >= _practiceHours &&
               0.15 * _subject.LabHours() >= _labHours;
    }
    
    
    void SetName(String name)
    {
        _name = name;
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
