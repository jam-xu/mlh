

import java.util.List;

public interface Visitable {
    List<Event> accept(Visitor visitor);
}
