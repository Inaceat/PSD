package Users;

import javax.swing.*;
import java.awt.*;

public class LoginInputDialog
{
    private JTextField _name;
    
    private Component    _parent;
    private JComponent[] _inputs;
    private int          _result;
    
    public LoginInputDialog(Component parent)
    {
        _parent = parent;
        
        _name = new JTextField();
        
        _inputs = new JComponent[]
                {
                        new JLabel("Name"), _name
                };
    }
    
    public void Ask()
    {
        _result = JOptionPane.showConfirmDialog(_parent, _inputs, "Login", JOptionPane.OK_CANCEL_OPTION);
    }
    
    public boolean OkPressed()
    {
        return JOptionPane.OK_OPTION == _result;
    }
    
    public String GetInput()
    {
        if (_name.getText().equals(""))
            return null;
        else
            return _name.getText();
    }
}
