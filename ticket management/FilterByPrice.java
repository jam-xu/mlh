

import java.util.ArrayList;
import java.util.List;

public class FilterByPrice implements Visitor{
    double aMin, aMax;

    public FilterByPrice(double pMin, double pMax){
        aMax = pMax;
        aMin = pMin;
    }
    private List<Event> aFilteredEvents = new ArrayList<Event>();

    @Override
    public List<Event> visit(EventManagement eventManagement) {
        List<Event> allEvents = eventManagement.getHostedEvents();
        System.out.println("Filter by Price");
        for (Event e:allEvents ){
            if (!(e instanceof ComingSoon) && e.getPrice().get()>=aMin && e.getPrice().get()<=aMax){
                aFilteredEvents.add(e);
            }
        }
        return aFilteredEvents;
    }


}
