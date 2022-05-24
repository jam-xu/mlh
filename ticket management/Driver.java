

import java.time.LocalDate;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        EventManagement ev =  new EventManagement();
        VIP v1 = new VIP("p1");
        VIP v2 = new VIP("p2");
        VIP v3 = new VIP("p3");
        ev.addConcertEvent("c1", Location.BellCentre, LocalDate.of(2022, 1, 1), 200,100,"lauv", List.of(v1,v2,v3));
        ev.addConcertEvent("c2", Location.ParcJeanDrapeau, LocalDate.of(2022, 2, 2), 200,100,"lauv", List.of(v1,v2,v3));
        ev.addGalaEvent("g3", Location.BellCentre, LocalDate.of(2022, 3, 3), 100,200, List.of(v1,v2,v3));
        ev.addGalaEvent("g4", Location.OlympicStadium, LocalDate.of(2022, 4, 4), 150,200, List.of(v1,v2,v3));
        ev.addWorkshopEvent("w5", Location.PlaceDesArts, LocalDate.of(2022, 5, 5), 50,300, List.of(new String[]{"req1", "req2", "req3"}));
        ev.addWorkshopEvent("w6", Location.OlympicStadium, LocalDate.of(2022, 6, 6), 40,300, List.of(new String[]{"req2", "req3", "req4"}));
        ev.addScreeningEvent("s7", Location.OlympicStadium, LocalDate.of(2022, 7, 7), 20,40, Screening.Rating.R);
        ev.addScreeningEvent("s8", Location.OlympicStadium, LocalDate.of(2022, 8, 8), 15,50,Screening.Rating.G);
        //ev.addConcertEvent("c9",Location.OlympicStadium, LocalDate.of(2022, 8, 8), 15,50,"lauv", List.of(new String[]{"p1", "p2", "p3"}));
        //ev.addConcertEvent("c10",Location.OlympicStadium, LocalDate.of(2022, 8, 8), 15,50,"lauv", List.of(new String[]{"p1", "p2", "p3"}));
        ev.addComingSoonEvent("coming soon",LocalDate.of(2022, 8, 8));
        System.out.println("events hosted: ");
        for (Event e: ev.getHostedEvents()){
            System.out.println(e.getName());
        }

        System.out.println("_-------------------------------------_");
        System.out.println("filtered by price: min = 10, max = 100: ");
        for (Event e: ev.accept(new FilterByPrice(10,100))) {
            System.out.println(e.getName());
        }
        System.out.println("_-------------------------------------_");
        System.out.println("filtered by location: location = bell_centre: ");
        for (Event e: ev.accept(new FilterByLocation(Location.BellCentre))){
            System.out.println(e.getName());
        }
        System.out.println("_-------------------------------------_");
        System.out.println("filtered by location and price: location = bell_centre: ");
        for (Event e: ev.accept(new FilterByPandL(Location.BellCentre,100,300))){
            System.out.println(e.getName());
        }

        System.out.println("_-------------------------------------_");
        System.out.println("After location filtering: get the profit ");

        double profit = ev.aExpProfit(new FilterByPandL((Location.OlympicStadium),10,100),60,50,30,10);
        System.out.println(" the profit is: " + profit + " $");

        System.out.println("_-------------------------------------_");
        System.out.println("get number of a vips after location filter");
        int vips = ev.totalVIPs(new FilterByLocation(Location.OlympicStadium));
        System.out.println("we have "+ vips + " vips");
        System.out.println("_-------------------------------------_");
    }
}
