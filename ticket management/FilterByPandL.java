

import java.util.ArrayList;
import java.util.List;

public class FilterByPandL implements Visitor{
    double aMin, aMax;
    Location aLocation;

    public FilterByPandL(Location pLocation, double pMin, double pMax){
        aLocation = pLocation;
        aMax = pMax;
        aMin = pMin;
    }
    private List<Event> aFilteredEvents = new ArrayList<Event>();

    @Override
    public List<Event> visit(EventManagement eventManagement) {
        List<Event> allEvents = eventManagement.getHostedEvents();
        System.out.println("Filter by Location & by Price");
        for (Event e:allEvents){
            if (!(e instanceof ComingSoon) && e.getLocation().get() == aLocation && e.getPrice().get()>=aMin && e.getPrice().get()<=aMax){
                aFilteredEvents.add(e);
            }
        }
        return aFilteredEvents;
    }




}
