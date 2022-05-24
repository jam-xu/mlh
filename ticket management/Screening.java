
import java.time.LocalDate;
import java.util.Optional;


public class Screening extends EventClass{

    @Override
    public void setProfit(int pConcert, int pGala, int pWorkshop, int pScreening) {
        this.profit = Optional.of(pScreening);
    }

    public enum Rating{
        G, PG, PG_13, R;
    }

    private Rating aRating;


    // CONSTRUCTOR
    public Screening(String pName, Location pLocation ,LocalDate pLocalDate, double pPrice, int pNumTickets, Rating pRating) {
        super(pName, pLocation,pLocalDate,pPrice,pNumTickets);
        assert pRating != null;
        aRating = pRating;
    }


    public Rating getRating(){
        return aRating;
    }

}
