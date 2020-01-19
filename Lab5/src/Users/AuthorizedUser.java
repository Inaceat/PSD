package Users;

import java.io.Serializable;

class AuthorizedUser
    extends User
        implements Serializable
{
    private String _name;
    
    AuthorizedUser(String name)
    {
        SetName(name);
    }
    
    public String Name()
    {
        return _name;
    }
    
    void SetName(String name)
    {
        _name = name;
    }
}
