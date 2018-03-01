public class Car {

    private Ride currentRide;
    private Location currentLocation;

    public Car() {
        currentLocation.setLocation(0, 0);
    }

    public void setRide(Ride r) {
        currentRide = r;
    }

    public Location getLocation() {
        return currentLocation;
    }

    public boolean hasRide() {
        return currentRide != null;
    }

    public Ride getCurrentRide(){return currentRide;}

    public int distanceFromFinish() {
        return currentRide.getStepsAwayFromFinish();
    }

    public void moveAsRide() {
        currentRide.step();
    }

    public void moveToRide(int x){
        if(x==0) currentLocation = currentRide.getStartLoc();
    }

    public boolean isRideComplete(){
        return currentRide.isComplete();
    }
}
