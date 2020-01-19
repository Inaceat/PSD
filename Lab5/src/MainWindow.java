import Subject.SubjectsTableView;
import Users.LoginInputDialog;
import Users.UserManager;
import Users.UsersWindow;

import javax.swing.*;
import java.awt.*;

class MainWindow
        extends JFrame
{
    private JButton _loginButton;
    private JButton _logoutButton;
    
    private JButton _showUsersButton;
    
    private JPanel _tablePane;
    
    private MainWindow()
    {
        _loginButton = new JButton("Login");
        _loginButton.addActionListener(e -> Login());
        
        _logoutButton = new JButton("Logout");
        _logoutButton.addActionListener(e -> Logout());
        
        _showUsersButton = new JButton("Users");
        _showUsersButton.addActionListener(e -> ShowUsers());
        
        
        UserManager.Init();
        UserManager.SetCurrentUser(null);
        
        
        _tablePane = new SubjectsTableView();
        
        setLayout(new BorderLayout());
        
        add(_loginButton, BorderLayout.PAGE_START);
        add(_showUsersButton, BorderLayout.EAST);
        add(_tablePane, BorderLayout.CENTER);
        
        
        setBounds(50, 300, 1400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private void ShowUsers()
    {
        if (UserManager.GetCurrentUser().IsAdmin())
        {
            var topicsWindow = new UsersWindow();
        }
    }
    
    private void Login()
    {
        String login;
        
        var loginInput = new LoginInputDialog(this);
        while (true)
        {
            loginInput.Ask();
            if (loginInput.OkPressed())
            {
                login = loginInput.GetInput();
    
                if (null == login)
                {
                    JOptionPane.showMessageDialog(this, "Wrong input!");
                    continue;
                }
    
                break;
            }
            else
            {
                return;
            }
        }
        
        UserManager.SetCurrentUser(login);
        
        if (UserManager.GetCurrentUser().IsAuthorized())
        {
            remove(_loginButton);
            add(_logoutButton, BorderLayout.PAGE_START);
            getContentPane().validate();
            getContentPane().repaint();
        }
    }
    
    private void Logout()
    {
        UserManager.SetCurrentUser(null);
        
        remove(_logoutButton);
        add(_loginButton, BorderLayout.PAGE_START);
        getContentPane().validate();
        getContentPane().repaint();
    }
    
    
    public static void main(String[] args)
    {
        var mainWindow = new MainWindow();
    }
}
