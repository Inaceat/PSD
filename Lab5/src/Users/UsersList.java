package Users;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

class UsersList
        extends AbstractTableModel
{
    private ArrayList<AuthorizedUser> _data;
    
    UsersList()
    {
        _data = UserManager.GetUsersList();
    }
    
    
    void Add(String name, String type)
    {
        if (type.equals("admin") || type.equals("teacher"))
        {
            UserManager.AddUser(name, type);
            Update();
        }
    }
    
    void RemoveAt(int index)
    {
        UserManager.RemoveUser(_data.get(index).Name());
        Update();
    }
    
    private void Update()
    {
        _data = UserManager.GetUsersList();
    }
    
    
    static private String[] columnNames =
            {
                    "User name", "Type"
            };
    
    static private Class<?> [] columnDataClasses =
            {
                    String.class, String.class
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
        return UserManager.GetCurrentUser().IsAdmin() && columnIndex != 1;
    }
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        if (0 == columnIndex)
            return _data.get(rowIndex).Name();
        else
            return _data.get(rowIndex).getClass().getCanonicalName();
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        _data.get(rowIndex).SetName((String)aValue);
        
        fireTableRowsUpdated(rowIndex, rowIndex);
    }
}
