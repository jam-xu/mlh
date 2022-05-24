
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
Controller to manage events hosted on EventBrite.
 */
public class EventManagement implements Visitable{
     private List<Event> aHostedEvents = new ArrayList<Event>();

    private boolean containsEvent(Location pLocation,LocalDate pLocalDate){
        boolean contain = false;
        for (Event e:aHostedEvents){
            if (e.getLocation().get() == pLocation && e.getDate().equals(pLocalDate)){
                 contain = true;
                 break;
            }
        }
        return contain;
    }

    /**
    Method to host a new concert event

     * @param pName name of a Concert
     * @param pLocation location of a Concert
     * @param pLocalDate date of a concert
     * @param pPrice price of a concert
     * @param pNumTickets # tickets of concert event
     * @param pArtist  artist  of concert event
     * @param pVIPs list of vips (represented as string)
     * @pre  pName!= null && pLocation!=null &&  pLocalDate!=null && pPrice!= 0 && pNumTickets!= 0 && pArtist!=null && pVIPs!=null
     */

    public void addConcertEvent(String pName, Location pLocation, LocalDate pLocalDate, double pPrice, int pNumTickets, String pArtist, List<VIP> pVIPs) {

        if (!containsEvent(pLocation,pLocalDate)){
            Concert concert = new Concert(pName, pLocation,pLocalDate,pPrice,pNumTickets, pArtist,pVIPs);
            aHostedEvents.add(concert);
        }else{
            throw new IllegalArgumentException("cannot create a duplicate event");
        }
    }


    /**
     Method to host a new Gala event
     * @param pName name of a Gala
     * @param pLocation location of a Gala
     * @param pLocalDate date of a Gala
     * @param pPrice  price of a Gala
     * @param pNumTickets # tickets of a Gala event
     * @param pVIPs list of vips (represented as string)
     * @pre  pName!= null && pLocation!=null &&  pLocalDate!=null && pPrice!= 0 && pNumTickets!= 0 && pVIPs!=null
     */

    public void addGalaEvent(String pName, Location pLocation, LocalDate pLocalDate, double pPrice, int pNumTickets, List<VIP> pVIPs) {
        assert pName!= null && pLocation!=null &&  pLocalDate!=null && pPrice!= 0 && pNumTickets!= 0 && pVIPs!=null;
//        Gala g = new Gala(pName, pLocation,pLocalDate,pPrice,pNumTickets, pVIPs);
//        if (aHostedEvents.contains(g)){
//            System.out.println(g.getName() +  " Gala already exists");
//        }else
//            //System.out.println("A new Gala: " + g.getName() +  " has been added to the event list");
//            aHostedEvents.add(g);
        if (!containsEvent(pLocation,pLocalDate)){
            Gala gala = new Gala(pName, pLocation,pLocalDate,pPrice,pNumTickets,pVIPs);
            aHostedEvents.add(gala);
        }else{
            throw new IllegalArgumentException("cannot create a duplicate event");
        }

    }

    /**
     Method to host a new Screening event
     * @param pName name of a screening
     * @param pLocation location of a screening
     * @param pLocalDate date of a screening
     * @param pPrice price of a screening
     * @param pNumTickets # tickets of a screening event
     * @param pRating rating of a screening (represented as ENUM)
     * @pre  pName!= null && pLocation!=null &&  pLocalDate!=null && pPrice!= 0 && pNumTickets!= 0 && pRating!=null
     */

    public void addScreeningEvent(String pName, Location pLocation ,LocalDate pLocalDate, double pPrice, int pNumTickets, Screening.Rating pRating){
        assert pName!= null && pLocation!=null &&  pLocalDate!=null && pPrice!= 0 && pNumTickets!= 0 && pRating!=null;
//        Screening screening = new Screening(pName, pLocation, pLocalDate, pPrice, pNumTickets, pRating);
//        if (aHostedEvents.contains(screening)){
//            //System.out.println("A new Screening: " + screening.getName() +  " has been added to the event list");
//            System.out.println(screening.getName() +  " Screening already exists");
//        }else
//            aHostedEvents.add(screening);

        if (!containsEvent(pLocation,pLocalDate)){
            Screening screening = new Screening(pName, pLocation, pLocalDate, pPrice, pNumTickets, pRating);
            aHostedEvents.add(screening);
        }else{
            throw new IllegalArgumentException("cannot create a duplicate event");
        }
    }

    /**
     Method to host a new Workshop event
     * @param pName name of a Workshop
     * @param pLocation location of a Workshop
     * @param pLocalDate date of a Workshop
     * @param pPrice price of a Workshop
     * @param pNumTickets # tickets of a Workshop event
     * @param pPrerequisites list of prerequisites of a Workshop (represented as a list of strings)
     * @pre  pName!= null && pLocation!=null &&  pLocalDate!=null && pPrice!= 0 && pNumTickets!= 0 && pPrerequisites!=null
     */
    public void addWorkshopEvent(String pName, Location pLocation, LocalDate pLocalDate, double pPrice, int pNumTickets, List<String> pPrerequisites){
        assert pName!= null && pLocation!=null &&  pLocalDate!=null && pPrice!= 0 && pNumTickets!= 0 && pPrerequisites!=null;
//        Workshop w = new Workshop(pName, pLocation,pLocalDate,pPrice,pNumTickets,pPrerequisites);
//        if (aHostedEvents.contains(w)){
//            //System.out.println("A new Screening: " + w.getName() +  " has been added to the event list");
//            System.out.println(w.getName() +  " workshop already exists");
//
//        }else
//            aHostedEvents.add(w);
        if (!containsEvent(pLocation,pLocalDate)){
            Workshop w = new Workshop(pName, pLocation,pLocalDate,pPrice,pNumTickets,pPrerequisites);
            aHostedEvents.add(w);
        }else{
            throw new IllegalArgumentException("cannot create a duplicate event");
        }


    }

    /**
     Method to host a new Festival event
     * @param pName name of a Festival
     * @param pEvents list of events that will be in the festival
     * @pre  pName!= null && pEvents!=null
     */
    public void addFestival(String pName, Event...pEvents)
            {
        assert pName!= null && pEvents!=null;
        Festival f = new Festival(pName,pEvents);
        //System.out.println("A new Screening: " + w.getName() +  " has been added to the event list");
        aHostedEvents.add(f);
    }


    /**
     Method to host a new Festival event
     * @param pName name of a Festival
     * @param pLocalDate date of a coming soon event
     * @pre  pName!= null && pLocalDate!=null
     */
    public void addComingSoonEvent(String pName, LocalDate pLocalDate){
        assert pName!= null && pLocalDate!=null;
        ComingSoon cs = new ComingSoon(pName,pLocalDate);
        //System.out.println("A new Screening: " + w.getName() +  " has been added to the event list");
        aHostedEvents.add(cs);
    }

    /**
    This method assumes that Events are immutable.
    @return  the list of hosted events on EventBrite.
     */
    public ArrayList<Event> getHostedEvents(){
        return new ArrayList<Event>(aHostedEvents);
    }

    /**
     * allow the user to call different filters
     * @param visitor different filter, profitcal, and #vips that this method can call
     * @pre visitor != null
     * @return a filtered result
     * */

    @Override
    public List<Event> accept(Visitor visitor) {
        assert visitor != null;
        return visitor.visit(this);
    }

    /**
     * calculating an Event object.
     * @param pConcertProfit the profit per ticket in percentage (i.e. 80 = 80%)
     * @param pWorkshopProfit the profit per ticket in percentage
     * @param pGalaProfit the profit per ticket in percentage
     * @param ScreeningProfit the profit per ticket in percentage
     * @pre visitor != null && pConcertProfit >=0 && pWorkshopProfit>=0 && pGalaProfit >= 0 && ScreeningProfit>=0
     * @return a double showing the total expected profit
     */

    public double aExpProfit(Visitor visitor, int pConcertProfit, int pWorkshopProfit, int pGalaProfit, int ScreeningProfit){
        assert visitor != null && pConcertProfit >=0 && pWorkshopProfit>=0 && pGalaProfit >= 0  && ScreeningProfit>=0;
        double expProfit = 0;
        List<Event> filteredEvent = accept(visitor);
        for (Event e: filteredEvent){
            ((EventClass) e).setProfit(pConcertProfit,pGalaProfit,pWorkshopProfit,ScreeningProfit);
            expProfit += ((EventClass) e).getProfit().get()*e.getPrice().get()*e.getNumTickets().get()*0.01;
        }
        return expProfit;
    }

    /**
     * calculating number of vips after filtering
     * using hashset to remove duplicate vips
     * @param visitor different filter that this method can call
     * @pre visitor != null
     * @return number of vips
     */

    public int totalVIPs(Visitor visitor){
        assert visitor != null;
        List<Event> filteredEvent = accept(visitor);
        HashSet<String> allVIPs = new HashSet<>();
        int festivalVIP = 0;

        for (Event e:filteredEvent){
            if (e instanceof Concert){
                List<VIP> vips = ((Concert) e).getaVIPs();
                for (VIP vip: vips){
                    allVIPs.add(String.valueOf(vip));
                }
            }else if (e instanceof Gala){
                List<VIP> vips = ((Gala) e).getaVIPs();
                for (VIP vip: vips){
                    allVIPs.add(String.valueOf(vip));
                }
            }else if (e instanceof Festival){
                festivalVIP =  fTotalVIPs((Festival) e);
            }
        }
        return allVIPs.size() + festivalVIP;
    }

    //helper method to calculate total vip in an event
    private int fTotalVIPs(Festival f){
        assert f!=null;
        HashSet<String> allVIPs = null;
        for (Event e:f){
            if (e instanceof Concert){
                List<VIP> vips = ((Concert) e).getaVIPs();
                for (VIP vip: vips){
                    allVIPs.add(String.valueOf(vip));
                }
            }else if (e instanceof Gala){
                List<VIP> vips = ((Gala) e).getaVIPs();
                for (VIP vip: vips){
                    allVIPs.add(String.valueOf(vip));
                }
            }
        }
        return allVIPs.size();
    }

}
