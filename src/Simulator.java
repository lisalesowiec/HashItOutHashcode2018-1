import java.util.ArrayList;

public class Simulator {
    private Map map;
    private RideParser rp = new RideParser();
    private int steps = 0;
    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<Ride> rides = new ArrayList<>();

    public Simulator(){

        for(int i = 0; i < rp.getAllRides().size(); i++){
            int[] arr = (int[])rp.getAllRides().get(i);
            Location s = new Location(arr[0],arr[1]);
            Location f = new Location(arr[2],arr[3]);

            Ride r = new Ride(s,f,arr[4],arr[5],i);
            rides.add(r);
        }
        int numbOfCars = rp.getNumOfCars();

        for(int i = 0; i<numbOfCars; i++){
            Car x = new Car();
            cars.add(x);
        }


        int width = rp.getColumns();
        int depth = rp.getRows();
        makeMap(width,depth);
    }

    public static void main(String[] args) {


        Simulator sim = new Simulator();
        for(Car c: sim.cars){
            Ride r = sim.findNearByRide(c);
            c.setRide(r);
        }
        while(!sim.allRidesDone()){
            sim.act();
        }
        sim.writeCarInfo();
    }


    private void act(){

        for(Car c: cars){
            //if car has a ride and currentLoc is startLoc of currentRide
            if(c.hasRide() && c.getLocation().equals(c.getCurrentRide().getStartLoc())){
                c.moveAsRide();
            }
            //if no ride then find and assign a ride and move to it
            else if(!c.hasRide()){
                Ride r = findNearByRide(c);
                c.setRide(r);
                c.setGetToRide(new Ride(c.getLocation(), r.getStartLoc()));
                c.moveAsRide();
            } else {
                // continue on current ride
                c.moveAsRide();
            }
            c.addJourney();
            /*else{
                int x = calculateDistance(c.getLocation(),c.getCurrentRide().getStartLoc());
                c.moveToRide(x); */

        }
    }



    public void writeCarInfo()
    {
        for(Car c: cars)
        {
            System.out.println(c.getJournies());
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
        System.out.println(allDone);
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
