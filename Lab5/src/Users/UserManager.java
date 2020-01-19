package Users;

import java.util.ArrayList;

public class UserManager
{
    private static User _current;
    
    
    public static void Init()
    {
        if (null == _current)
        {
            _current = new AdminUser("temp");
            AddUser("admin", "admin");
            _current = new User();
        }
    }
    
    static void AddUser(String name, String type)
    {
        if (_current.IsAdmin())
        {
            AuthorizedUser newUser;
            
            switch (type)
            {
                case "admin":
                    newUser = new AdminUser(name);
                    break;
                
                case "teacher":
                    newUser = new TeacherUser(name);
                    break;
                    
                default:
                    return;
            }
    
            var serializer = new UsersSerializer();
    
            var users = serializer.ReadUsers();
    
            if(users.stream().noneMatch(user -> user.Name().equals(name)))
            {
                users.add(newUser);
                serializer.WriteUsers(users);
            }
        }
    }
    
    static void RemoveUser(String name)
    {
        if (_current.IsAdmin())
        {
            var serializer = new UsersSerializer();
    
            ArrayList<AuthorizedUser> users = serializer.ReadUsers();
            
            if(users.stream().anyMatch(user -> user.Name().equals(name)))
            {
                users.removeIf(authorizedUser -> authorizedUser.Name().equals(name));
                serializer.WriteUsers(users);
            }
        }
    }
    
    
    public static void SetCurrentUser(String name)
    {
        if (null == name)
        {
            _current = new User();
        }
        else
        {
            var serializer = new UsersSerializer();
    
            var users = serializer.ReadUsers();
    
            var usersWithName = users.stream().filter(user -> user.Name().equals(name)).toArray();
    
            if (1 != usersWithName.length)
            {
                _current = new User();
            }
            else
            {
                _current = (AuthorizedUser) usersWithName[0];
            }
        }
    }
    
    public static User GetCurrentUser()
    {
        return _current;
    }
    
    
    static ArrayList<AuthorizedUser> GetUsersList()
    {
        var serializer = new UsersSerializer();
    
        return serializer.ReadUsers();
    }
}
