package Task3.BusSchedule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class BusSchedule
        implements Serializable
{
    private ArrayList<BusRoute> _routes;
    private transient ScheduleSerializer  _serializer;
    
    public BusSchedule()
    {
        _serializer = new ScheduleSerializer();
        
        _routes = _serializer.ReadSchedule();
    }
    
    public int Length()
    {
        return _routes.size();
    }
    
    
    public ArrayList<BusRoute> RoutesList()
    {
        return _routes;
    }
    
    public void AddRoute(BusRoute newRoute)
    {
        _routes.add(newRoute);
        
        _serializer.WriteSchedule(this);
    }
    
    public void UpdateRoute(int routeIndex, BusRoute newRoute)
    {
        _routes.set(routeIndex - 1, newRoute);
        
        _serializer.WriteSchedule(this);
    }
    
    public void DeleteRoute(int routeIndex)
    {
        _routes.remove(routeIndex - 1);
        
        _serializer.WriteSchedule(this);
    }
    
    public ArrayList<BusRoute> SelectRoutes(String pointName, DayOfWeek dayOfWeek)
    {
        return _routes.stream()
                      .filter(route -> (pointName.equals(route.DeparturePoint()) ||
                                        pointName.equals(route.ArrivalPoint())) && dayOfWeek.equals(route.DayOfWeek()))
                      .sorted((left, right) ->
                              {
                                  //If both have same Departure Point
                                  if (left.DeparturePoint().equals(right.DeparturePoint()))
                                  {
                                      return left.DepartureTime().compareTo(right.DepartureTime());
                                  }
            
                                  //If both have same Arrival Point
                                  if (left.ArrivalPoint().equals(right.ArrivalPoint()))
                                  {
                                      return left.ArrivalTime().compareTo(right.ArrivalTime());
                                  }
            
                                  //Else, don't care
                                  return -1;
                              })
                      .collect(Collectors.toCollection(ArrayList::new));
    }
}
