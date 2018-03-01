public class Ride {

    private Location startLoc;
    private Location finishLoc;
    private int earliestStart;
    private int latestFinish;
    private int actualStart;
    private boolean complete;

    public Ride(Location startLoc, Location finishLoc, int earliestStart, int latestFinish){
        this.startLoc = startLoc;
        this.finishLoc = finishLoc;
        this.earliestStart = earliestStart;
        this.latestFinish = latestFinish;
        complete=false;
    }
    
    public void complete(){
        complete = true;
    }
    
    public boolean isComplete(){
        return complete;
    }
    
    public Ride(){}

    public void setStartLoc(Location start){
        startLoc = start;
    }

    public Location getStartLoc(){
        return startLoc;
    }

    public void setFinishLoc(Location finish){
        finishLoc = finish;
    }

    public Location getFinishLoc(){
        return finishLoc;
    }

    public void setEarliestStart(int start){
        earliestStart = start;
    }

    public int getEarliestStart(){
        return earliestStart;
    }

    public void setLatestFinish(){
        latestFinish = latestFinish;
    }

    public int getLatestFinish(){
        return latestFinish;
    }

    public int stepsAwayFromFinish(){
       return (Math.abs(startLoc.getX()-finishLoc.getX()) + Math.abs(startLoc.getY()-finishLoc.getY()));
    }
}
