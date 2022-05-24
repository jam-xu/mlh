
import java.time.LocalDate;
import java.util.*;



public class Concert extends EventClass {
    @Override
    public void setProfit(int pConcert, int pGala, int pWorkshop, int pScreening ) {
        this.profit = Optional.of(pConcert);
    }

    //field

    private String anArtist;
    private List<VIP> aVIPs;

    // CONSTRUCTOR
    public Concert(String pName, Location pLocation, LocalDate pLocalDate, double pPrice, int pNumTickets, String pArtist, List<VIP> pVIPs) {
        super(pName, pLocation,pLocalDate,pPrice,pNumTickets);
        assert pArtist!= null && pVIPs!= null;
        anArtist = pArtist;
        aVIPs = pVIPs;
    }

    public String getAnArtist(){
        return anArtist;
    }
    private void setAnArtist(String pArtist){
        assert pArtist!=null;
        anArtist = pArtist;
    }

    public ArrayList<VIP> getaVIPs(){
        return new ArrayList<VIP>(aVIPs);
    }

}
