
import java.time.LocalDate;
import java.util.*;

public final class Festival extends AbstractList<Event> implements Event{
    //field
    private final List<Event> aFestival = new ArrayList<>();
    private final String aName;
    private Location aLocation;
    private LocalDate aLocalDate;
    private Double aPrice;
    private Integer aNumTickets;

    //CONSTRUCTOR
    public Festival(String pName, Event...pEvents) {
        assert pName!= null && pEvents!= null;
        aName = pName;
        aFestival.addAll(Arrays.asList(pEvents));
    }

    public String getName() {
        return aName;
    }

    @Override
    public Optional<Location>  getLocation() {
        HashSet locations = new HashSet();
        for (Event aEvent : aFestival) {
            locations.add(aEvent.getLocation());
        }
        if (locations.size() != 1){
            aLocation = Location.Multiple;
        }else
            aLocation = (Location) locations.toArray()[0];
        return Optional.ofNullable(aLocation);
    }

    @Override
    public LocalDate getDate() {
        List<LocalDate> date = new ArrayList<>();
        for (Event e: aFestival){
            date.add(e.getDate());
        }
        aLocalDate = Collections.min(date);
        return aLocalDate;
    }

    @Override
    public Optional<Double> getPrice() {
        int price = 0;
        for (Event e : aFestival){
            price += e.getPrice().get();
        }
        aPrice = price * 0.2;
        return Optional.of(aPrice);
    }

    @Override
    public Optional<Integer> getNumTickets() {
        List<Integer> ticket = new ArrayList<>();
        for (Event e: aFestival){
            ticket.add(e.getNumTickets().get());
        }
        aNumTickets = Collections.min(ticket);
        return Optional.ofNullable(aNumTickets);
    }


    // 2 override methods to make the abstract list unmodifiable
    @Override
    public Event get(int index) {
        assert index>= 0 && index<size() ;
        return aFestival.get(index);
    }

    @Override
    public int size() {
        return aFestival.size();
    }


}
