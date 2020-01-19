package Users;

import javax.swing.*;
import java.awt.*;

class UsersTableView
        extends JPanel
{
    private UsersList _userTableData;
    private JTable    _userTable;
    
    UsersTableView()
    {
        super(new BorderLayout());
        
        _userTableData = new UsersList();
        _userTable = new JTable(_userTableData);
        _userTable.setAutoCreateRowSorter(true);
        
        var buttons = new UserTableButtonsView();
        buttons.SetAddAction(e -> AddUser());
        buttons.SetDeleteAction(e -> DeleteUser());
        
        add(new JScrollPane(_userTable), BorderLayout.CENTER);
        add(buttons, BorderLayout.PAGE_START);
    }
    
    private void AddUser()
    {
        var name = new JTextField();
        var type = new JTextField();
        
        var inputs = new JComponent[]{
                new JLabel("Name"), name,
                new JLabel("Type"), type};
        
        int result = JOptionPane.showConfirmDialog(this, inputs,"New user", JOptionPane.OK_CANCEL_OPTION);
        
        if (result != JOptionPane.OK_OPTION)
            return;
        
        _userTableData.Add(name.getText(), type.getText());
        _userTableData.fireTableDataChanged();
    }
    
    private void DeleteUser()
    {
        var index = _userTable.convertRowIndexToModel(_userTable.getSelectionModel().getLeadSelectionIndex());
        
        _userTableData.RemoveAt(index);
        _userTableData.fireTableDataChanged();
    }
}
