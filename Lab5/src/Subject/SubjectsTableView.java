package Subject;


import Topic.TopicsWindow;
import Users.UserManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class SubjectsTableView
        extends JPanel
        implements WindowListener
{
    private SubjectsList _subjectsTableData;
    private JTable       _subjectsTable;
    
    public SubjectsTableView()
    {
        super(new BorderLayout());
        
        _subjectsTableData = new SubjectsList();
        _subjectsTable = new JTable(_subjectsTableData);
        _subjectsTable.setAutoCreateRowSorter(true);
    
        SubjectTableButtonsView buttons = new SubjectTableButtonsView();
        buttons.SetAddAction(e -> AddSubject());
        buttons.SetDeleteAction(e -> DeleteSubject());
        buttons.SetShowTopics(e -> ShowSubjectTopics());
        
        add(new JScrollPane(_subjectsTable), BorderLayout.CENTER);
        add(buttons, BorderLayout.PAGE_START);
    }
    
    private void AddSubject()
    {
        if (UserManager.GetCurrentUser().IsTeacher())
        {
            SubjectData newSubject;
    
            var inputDialog = new SubjectInputDialog(this);
    
            while (true)
            {
                inputDialog.Ask();
        
                if (inputDialog.OkPressed())
                {
                    newSubject = inputDialog.GetInput();
            
                    if (null == newSubject)
                    {
                        JOptionPane.showMessageDialog(this, "Wrong input!");
                        continue;
                    }
            
                    _subjectsTableData.Add(newSubject);
                    _subjectsTableData.fireTableDataChanged();
                    return;
                }
                else
                    break;
            }
        }
    }
    
    private void DeleteSubject()
    {
        if (UserManager.GetCurrentUser().IsTeacher())
        {
            var index = _subjectsTable.convertRowIndexToModel(_subjectsTable.getSelectionModel().getLeadSelectionIndex());
            
            _subjectsTableData.RemoveAt(index);
            _subjectsTableData.fireTableDataChanged();
        }
    }
    
    private void ShowSubjectTopics()
    {
        var index = _subjectsTable.convertRowIndexToModel(_subjectsTable.getSelectionModel().getLeadSelectionIndex());
    
        SubjectData subject;
        try
        {
            subject = _subjectsTableData.At(index);
        }
        catch (IndexOutOfBoundsException ignored)
        {
            return;
        }
        
        var topicsWindow = new TopicsWindow(subject);
        
        topicsWindow.addWindowListener(this);
    }
    
    @Override
    public void windowOpened(WindowEvent e)
    {
    
    }
    
    @Override
    public void windowClosing(WindowEvent e)
    {
    
    }
    
    @Override
    public void windowClosed(WindowEvent e)
    {
        _subjectsTableData.Save();
    }
    
    @Override
    public void windowIconified(WindowEvent e)
    {
    
    }
    
    @Override
    public void windowDeiconified(WindowEvent e)
    {
    
    }
    
    @Override
    public void windowActivated(WindowEvent e)
    {
    
    }
    
    @Override
    public void windowDeactivated(WindowEvent e)
    {
    
    }
}
