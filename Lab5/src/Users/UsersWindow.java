package Users;

import javax.swing.*;
import java.awt.*;

public class UsersWindow
        extends JFrame
{
    private JPanel _tablePane;
    
    public UsersWindow()
    {
        _tablePane = new UsersTableView();
        
        setLayout(new BorderLayout());
        
        add(_tablePane, BorderLayout.CENTER);
        
        setBounds(350, 300, 700, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
