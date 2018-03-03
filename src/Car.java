import java.util.ArrayList;

public class Car {

    private Ride currentRide;
    private Location currentLocation;
    private Ride getToRide;
    ArrayList<Ride> journeyList = new ArrayList<>();

    public Car() {
        currentLocation = new Location(0, 0);
    }

    public void setRide(Ride r) {
        currentRide = r;
    }
    
    public void setGetToRide(Ride r){
        getToRide = r;
    }

    public Location getLocation() {
        return currentLocation;
    }

    public boolean hasRide() {
        if(currentRide==null){ return false;}
        else return !currentRide.isComplete();
    }

    public Ride getCurrentRide(){return currentRide;}

    public int distanceFromFinish() {
        return currentRide.getStepsAwayFromFinish();
    }

    public void moveAsRide() {
        if(getToRide ==null){

            currentRide.step();
            isRideComplete();

        } else if(getToRide.isComplete()) {
            isRideComplete();
            currentRide.step();
        }else
            {
                getToRide.step();
            }

    }
    public ArrayList getJournies()
    {
        return journeyList;
    }

    public void addJourney()
    {
        if(currentRide.isComplete()) {
            journeyList.add(currentRide);
        }
    }
    public void moveToRide(int x){
        if(x==0) currentLocation = currentRide.getStartLoc();
    }

    public boolean isRideComplete(){
        if(currentRide.isComplete())
        {
            addJourney();
            currentRide = null;
            return true;
        }
        else return false;
    }
}
