public class Car {

    private Ride currentRide;
    private Location currentLocation;

    public void setRide(Ride r) {
        currentRide = r;
    }

    public boolean hasRide(){
        return currentRide!=null;
    }

    public int distanceFromFinish(){
        currentRide.stepsAwayFromFinish();
    }
}
