package Task3;

import Task3.BusSchedule.BusSchedule;
import Task3.BusSchedule.DayOfWeek;
import Task3.BusScheduleUI.*;

class BusScheduleController
{
    private ConsoleUI   _ui;
    private BusSchedule _schedule;
    
    BusScheduleController()
    {
        _ui = new ConsoleUI(MenuItem.GetNames());
        _schedule = new BusSchedule();
    }
    
    void Work()
    {
        int routeIndex;
        
        while (true)
        {
            switch (_ui.AskMenuItemFromUser())
            {
                case Exit:
                    return;
                    
                case ShowAllRoutes:
                    _ui.Write(_schedule.RoutesList());
                    break;
                    
                case CreateRoute:
                    _schedule.AddRoute(_ui.ReadRoute());
                    break;
                    
                case UpdateRoute:
                    _ui.Write("Enter index of route to update:");
                    routeIndex = _ui.ReadInteger(1, _schedule.Length());
                    
                    _schedule.UpdateRoute(routeIndex, _ui.ReadRoute());
                    break;
                    
                case DeleteRoute:
                    _ui.Write("Enter index of route to delete:");
                    routeIndex = _ui.ReadInteger(1, _schedule.Length());
    
                    _schedule.DeleteRoute(routeIndex);
                    break;
                    
                case ShowSpecificRoute:
                    _ui.Write("Enter departure/arrival point:");
                    String pointName = _ui.ReadString();
    
                    _ui.Write("Enter day of week:");
                    DayOfWeek day = _ui.ReadDayOfWeek();
                    
                    _ui.Write(_schedule.SelectRoutes(pointName, day));
                    break;
            }
        }
    }
}
