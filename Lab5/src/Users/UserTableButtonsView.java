package Users;

import javax.swing.*;
import java.awt.event.ActionListener;

class UserTableButtonsView
        extends JPanel
{
    private JButton _addButton;
    private JButton _deleteButton;
    
    UserTableButtonsView()
    {
        _addButton = new JButton("Add");
        _deleteButton = new JButton("Delete");
        
        add(_addButton);
        add(_deleteButton);
    }
    
    void SetAddAction(ActionListener l)
    {
        _addButton.addActionListener(l);
    }
    
    void SetDeleteAction(ActionListener l)
    {
        _deleteButton.addActionListener(l);
    }
}
