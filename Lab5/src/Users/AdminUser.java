package Users;

public class AdminUser
    extends AuthorizedUser
{
    AdminUser(String name)
    {
        super(name);
    }
    
    @Override
    public boolean IsAuthorized()
    {
        return true;
    }
    
    @Override
    public boolean IsAdmin()
    {
        return true;
    }
}
