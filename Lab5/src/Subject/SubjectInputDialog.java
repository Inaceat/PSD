package Subject;

import javax.swing.*;
import java.awt.*;

class SubjectInputDialog
{
    private JTextField _name;
    private JTextField _teacher;
    private JTextField _profession;
    private JTextField _year;
    private JTextField _term;
    private JTextField _begin;
    private JTextField _end;
    private JTextField _lectures;
    private JTextField _practice;
    private JTextField _labs;
    
    
    private Component    _parent;
    private JComponent[] _inputs;
    private int          _result;
    
    
    SubjectInputDialog(Component parent)
    {
        _parent = parent;
        
        _name = new JTextField();
        _teacher = new JTextField();
        _profession = new JTextField();
        _year = new JTextField();
        _term = new JTextField();
        _begin = new JTextField();
        _end = new JTextField();
        _lectures = new JTextField();
        _practice = new JTextField();
        _labs = new JTextField();
        
        _inputs = new JComponent[]
                {
                        new JLabel("Name"), _name,
                        new JLabel("Teacher"), _teacher,
                        new JLabel("Profession"), _profession,
                        new JLabel("Year"), _year,
                        new JLabel("Term"), _term,
                        new JLabel("Begin"), _begin,
                        new JLabel("End"), _end,
                        new JLabel("Lecture hours"), _lectures,
                        new JLabel("Practice hours"), _practice,
                        new JLabel("Lab hours"), _labs
                };
    }
    
    void Ask()
    {
        _result = JOptionPane.showConfirmDialog(_parent, _inputs, "New Subject", JOptionPane.OK_CANCEL_OPTION);
    }
    
    boolean OkPressed()
    {
        return JOptionPane.OK_OPTION == _result;
    }
    
    SubjectData GetInput()
    {
        try
        {
            return new SubjectData(
                    _name.getText(),
                    _teacher.getText(),
                    _profession.getText(),
                    Integer.parseInt(_year.getText()),
                    Integer.parseInt(_term.getText()),
                    _begin.getText(),
                    _end.getText(),
                    Integer.parseInt(_lectures.getText()),
                    Integer.parseInt(_practice.getText()),
                    Integer.parseInt(_labs.getText()));
        }
        catch (IllegalArgumentException ignored)
        {
            return null;
        }
    }
}
