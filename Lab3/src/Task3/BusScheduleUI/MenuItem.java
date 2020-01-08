package Task3.BusScheduleUI;

import java.util.ArrayList;

public enum MenuItem
{
    Exit,
    ShowAllRoutes,
    CreateRoute,
    UpdateRoute,
    DeleteRoute,
    ShowSpecificRoute;

    public static ArrayList<String> GetNames()
    {
        ArrayList<String> names = new ArrayList<>();
    
        names.add("Exit");
        names.add("Show all routes");
        names.add("Create route");
        names.add("Update route");
        names.add("Delete route");
        names.add("Show specific route");
        
        return names;
    }
}
