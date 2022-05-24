
import java.util.ArrayList;
import java.util.List;

public class FilterByLocation implements Visitor{
    Location aLocation;
    Concert c;
    int pConcertProfit;
    Gala gala;
    int pGalaProfit;
    Workshop w;
    int pWorkshopProfit;
    Screening screening;
    int pScreeningProfit;


    public FilterByLocation(Location pLocation){
        aLocation = pLocation;
    }


    private List<Event> aFilteredEvents = new ArrayList<Event>();

    @Override
    public List<Event> visit(EventManagement eventManagement) {
        List<Event> allEvents = eventManagement.getHostedEvents();
        System.out.println("Filter by Location");
        for (Event e:allEvents){
            if (!(e instanceof ComingSoon) && e.getLocation().get() == aLocation){
                aFilteredEvents.add(e);
            }
        }
        return aFilteredEvents;
    }



}
