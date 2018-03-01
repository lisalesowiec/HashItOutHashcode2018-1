public class Car {

    private Ride currentRide;
    private Location currentLocation;
    private Ride getToRide;

    public Car() {
        currentLocation.setLocation(0, 0);
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
        return currentRide != null;
    }

    public Ride getCurrentRide(){return currentRide;}

    public int distanceFromFinish() {
        return currentRide.getStepsAwayFromFinish();
    }

    public void moveAsRide() {
        if(getToRide==null){
            currentRide.step();
        } else {
            getToRide.step();
        }
    }

    public void moveToRide(int x){
        if(x==0) currentLocation = currentRide.getStartLoc();
    }

    public boolean isRideComplete(){
        return currentRide.isComplete();
    }
}
