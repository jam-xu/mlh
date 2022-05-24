

import java.time.LocalDate;
import java.util.Optional;

/*
Representation of a type of Event that can exist
 */
public interface Event{
    String getName();
    Optional<Location> getLocation();
    LocalDate getDate();
    Optional<Double> getPrice();
    Optional<Integer> getNumTickets();

}
