

import java.time.LocalDate;
import java.util.*;

public class Gala extends EventClass{

    //field
    private List<VIP> aVIPs;

    // CONSTRUCTOR
    public Gala(String pName, Location pLocation, LocalDate pLocalDate, double pPrice, int pNumTickets, List<VIP> pVIPs) {
        super(pName, pLocation,pLocalDate,pPrice,pNumTickets);
        assert pVIPs!= null;
        aVIPs = pVIPs;
    }

    public List<VIP> getaVIPs(){
        return aVIPs;
    }

    @Override
    public void setProfit(int pConcert, int pGala, int pWorkshop, int pScreening ) {
        this.profit = Optional.of(pGala);
    }


}
