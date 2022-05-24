

import java.time.LocalDate;
import java.util.*;

public abstract class EventClass implements Event{

    //groups all the field that gala, concert, workshop, screening
    //have in common, tight encapsulation

    private final String aName;
    private Optional<Location> aLocation;
    private final LocalDate aLocalDate;
    private Optional<Double> aPrice;
    private Optional<Integer> aNumTickets;
    public Optional<Integer> profit;

    /**
     * Initialize an Event object.
     * @param pName name of the event
     * @param pLocation the location of the event
     * @param pLocalDate date of the event
     * @param pPrice price of the event
     * @param pNumTickets number of tickets of the event
     * @pre pName!= null && pLocation!=null &&  pLocalDate!=null && pPrice!= 0 && pNumTickets!= 0
     */

    //CONSTRUCTOR FOR A NEW EVENT
    public EventClass(String pName, Location pLocation ,LocalDate pLocalDate, double pPrice, int pNumTickets){
        assert pName!= null && pLocation!=null &&  pLocalDate!=null && pPrice!= 0 && pNumTickets!= 0;
        aName = pName;
        aLocation = Optional.of(pLocation);
        aLocalDate = pLocalDate;
        aPrice = Optional.of(pPrice);
        aNumTickets = Optional.of(pNumTickets);
    }
    // CONSTRUCTOR for a coming soon event, i.e. some of the attributes can be null
    public EventClass(String pName,LocalDate pLocalDate){
        //isComingSoon = true;
        aName = pName;
        aLocalDate = pLocalDate;
        aLocation = Optional.empty();
        aPrice = Optional.empty();
        aNumTickets = Optional.empty();
    }

    public void setProfit(int pConcert, int pGala, int pWorkshop, int pScreening){
        profit = Optional.empty();
    }


    public Optional<Integer> getProfit(){
        return profit;
    }

   // implemented from the event interface
    @Override
    public String getName() {
        return aName;
    }

    @Override
    public Optional <Location> getLocation() {
        return aLocation;
    }

    @Override
    public LocalDate getDate() {
        return aLocalDate;
    }

    @Override
    public Optional<Double> getPrice() {
        return aPrice;
    }

    @Override
    public Optional<Integer> getNumTickets() {
        return aNumTickets;
    }


    // override equals and hashcode
    // if same date & location = same event

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventClass event = (EventClass) o;
        return aLocation.equals(event.aLocation) && aLocalDate.equals(event.aLocalDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aLocation, aLocalDate);
    }


}


