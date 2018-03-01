public class Ride {

    private Location startLoc;
    private Location finishLoc;
    private int earliestStart;
    private int latestFinish;

    public void setStart(Location start){
        startLoc = start;
    }

    public Location getStart(){
        return start;
    }

    public void setFinish(Location finish){
        finishLoc = finish;
    }

    public Location getFinish(){
        return finishLoc;
    }

    public void setEarliestStart(int start){
        earliestStart = start;
    }

    public int getEarliestStart(){
        return earliestStart;
    }

    public void setLatestFinish(){
        latestFinish = finish;
    }

    public int getLatestFinish(){
        return latestFinish;
    }
}
