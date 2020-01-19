package Users;

public class TeacherUser
    extends AuthorizedUser
{
    TeacherUser(String name)
    {
        super(name);
    }
    
    @Override
    public boolean IsAuthorized()
    {
        return true;
    }
    
    @Override
    public boolean IsTeacher()
    {
        return true;
    }
}
