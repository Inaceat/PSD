package Topic;

import Subject.SubjectData;
import Users.UserManager;

import javax.swing.*;
import java.awt.*;

class TopicsTableView
        extends JPanel
{
    private SubjectData _subject;
    private TopicsList _topicsTableData;
    private JTable     _topicsTable;
    
    
    TopicsTableView(SubjectData subject)
    {
        super(new BorderLayout());
    
        _subject = subject;
        _topicsTableData = subject.TopicsList();
        _topicsTable = new JTable(_topicsTableData);
        _topicsTable.setAutoCreateRowSorter(true);
        
        var buttons = new TopicTableButtonsView();
        buttons.SetAddAction(e -> AddTopic());
        buttons.SetDeleteAction(e -> DeleteTopic());
    
        add(new JScrollPane(_topicsTable), BorderLayout.CENTER);
        add(buttons, BorderLayout.PAGE_START);
    }
    
    private void AddTopic()
    {
        if (UserManager.GetCurrentUser().IsTeacher())
        {
            TopicData newTopic;
    
            var inputDialog = new TopicInputDialog(this);
    
            while (true)
            {
                inputDialog.Ask();
        
                if (inputDialog.OkPressed())
                {
                    newTopic = inputDialog.GetInput(_subject);
            
                    if (null == newTopic)
                    {
                        JOptionPane.showMessageDialog(this, "Wrong input!");
                        continue;
                    }
            
                    _topicsTableData.Add(newTopic);
                    _topicsTableData.fireTableDataChanged();
                    
                    return;
                }
                else
                    break;
            }
        }
    }
    
    private void DeleteTopic()
    {
        if (UserManager.GetCurrentUser().IsTeacher())
        {
            var index = _topicsTable.convertRowIndexToModel(_topicsTable.getSelectionModel().getLeadSelectionIndex());
            
            _topicsTableData.RemoveAt(index);
            _topicsTableData.fireTableDataChanged();
        }
    }
}
