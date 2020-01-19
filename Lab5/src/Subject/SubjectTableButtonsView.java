package Subject;

import javax.swing.*;
import java.awt.event.ActionListener;

class SubjectTableButtonsView
        extends JPanel
{
    private JButton _addButton;
    private JButton _deleteButton;
    private JButton _showTopicsButton;
    
    SubjectTableButtonsView()
    {
        _addButton = new JButton("Add");
        _deleteButton = new JButton("Delete");
        _showTopicsButton = new JButton("Show topics");
        
        add(_addButton);
        add(_deleteButton);
        add(_showTopicsButton);
    }
    
    void SetAddAction(ActionListener l)
    {
        _addButton.addActionListener(l);
    }
    
    void SetDeleteAction(ActionListener l)
    {
        _deleteButton.addActionListener(l);
    }
    
    void SetShowTopics(ActionListener l)
    {
        _showTopicsButton.addActionListener(l);
    }
}
