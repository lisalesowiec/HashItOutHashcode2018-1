import java.util.ArrayList;

public class Simulator {
    private Map map;
    private RideParser rp = new RideParser();
    private int steps = 0;
    private ArrayList<Car> cars = new ArrayList<Car>();
    private ArrayList<Ride> rides;

    public Simulator(){

        int width = rp.getColumns();
        int depth = rp.getRows();
        makeMap(width,depth);
    }

    public static void main(String[] args) {
        while (!allRidesDone()){

        }
    }
    public Ride findNearByRide(Car car){
        Location carLoc = car.getLocation();
        int shortestDist = calculateDistance(rides.get(0).getStartLoc(),car.getLocation());
        Ride closest = rides.get(0);
        for(Ride r: rides){
            if(r.isClaimed()) {
                if ((calculateDistance(r.getStartLoc(), car.getLocation())) < shortestDist) closest = r;
            }
        }
        return closest;
    }


    private boolean allRidesDone(){
        boolean allDone = true;
        for(Ride r: rides){
            if(!r.isComplete()){
                allDone = false;
            }
        }
        return allDone;
    }


    /**
     * calcualtes the distance between two locations l1, l2
     * @param l1
     * @param l2
     * @return distance
     */
    private int calculateDistance(Location l1, Location l2){
        return( Math.abs(l1.getX()- l2.getX()) + Math.abs(l1.getY()-l2.getY()));
    }

    /**
     * creates the map witht he given width and height
     * @param width
     * @param depth
     */
    private void makeMap(int width,int depth){
        map = new Map(width,depth);
    }

    public int getSteps(){return steps;}
}
