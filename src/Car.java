public class Car {

    private Ride currentRide;
    private Location currentLocation;

    public Car(){
        currentLocation.setLocation(0,0);
    }
    
    public void setRide(Ride r) {
        currentRide = r;
    }

    public Location getLocation() {
        return currentLocation;
    }

    public boolean hasRide(){
        return currentRide!=null;
    }

    public int distanceFromFinish(){
        return currentRide.stepsAwayFromFinish();
    }

    public void moveStep(){
        
    }
}
