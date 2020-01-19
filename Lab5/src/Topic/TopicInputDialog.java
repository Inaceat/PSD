package Topic;

import Subject.SubjectData;

import javax.swing.*;
import java.awt.*;

class TopicInputDialog
{
    private JTextField _name;
    private JTextField _lectures;
    private JTextField _practice;
    private JTextField _labs;
    
    
    private Component    _parent;
    private JComponent[] _inputs;
    private int          _result;
    
    
    TopicInputDialog(Component parent)
    {
        _parent = parent;
        
        _name = new JTextField();
        _lectures = new JTextField();
        _practice = new JTextField();
        _labs = new JTextField();
        
        _inputs = new JComponent[]
                {
                        new JLabel("Name"), _name,
                        new JLabel("Lecture hours"), _lectures,
                        new JLabel("Practice hours"), _practice,
                        new JLabel("Lab hours"), _labs
                };
    }
    
    void Ask()
    {
        _result = JOptionPane.showConfirmDialog(_parent, _inputs, "New Topic", JOptionPane.OK_CANCEL_OPTION);
    }
    
    boolean OkPressed()
    {
        return JOptionPane.OK_OPTION == _result;
    }
    
    TopicData GetInput(SubjectData subject)
    {
        try
        {
            return new TopicData(
                    subject,
                    _name.getText(),
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
