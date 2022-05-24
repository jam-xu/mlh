
import java.time.LocalDate;
import java.util.*;

public class Workshop extends EventClass{
    private final List<String> aPrerequisites;

    @Override
    public void setProfit(int pConcert, int pGala, int pWorkshop, int pScreening ) {
        this.profit = Optional.of(pWorkshop);
    }

    // CONSTRUCTOR
    public Workshop(String pName, Location pLocation, LocalDate pLocalDate, double pPrice, int pNumTickets, List<String> pPrerequisites) {
        super(pName, pLocation,pLocalDate,pPrice,pNumTickets);
        assert pPrerequisites != null;
        aPrerequisites = pPrerequisites;
    }

    public List<String> getaPrerequisites(){
        return aPrerequisites;
    }


}
