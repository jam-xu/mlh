

import java.util.List;

public interface Visitor {
    //filter result
    List<Event> visit(EventManagement eventManagement);

}
