public class Ride {

    private Location startLoc;
    private Location finishLoc;
    private int earliestStart;
    private int latestFinish;
    private int actualStart;
    private boolean claimed;
    private boolean complete;
    private int stepsLeft;

    public Ride(Location startLoc, Location finishLoc, int earliestStart, int latestFinish){
        this.startLoc = startLoc;
        this.finishLoc = finishLoc;
        this.earliestStart = earliestStart;
        this.latestFinish = latestFinish;
        claimed=false;
        complete=false;
        stepsLeft=getStepsAwayFromFinish();
    }

    public Ride(){}

    public void claim(){
        claimed=true;
    }

    public void complete(){
        complete=true;
    }

    public boolean isClaimed(){
        return claimed;
    }

    public boolean isComplete(){
        return complete;
    }

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

    public int getStepsAwayFromFinish(){
        return (Math.abs(startLoc.getX()-finishLoc.getX()) + Math.abs(startLoc.getY()-finishLoc.getY()));
    }
    
    public void step(){
        stepsLeft--;
        if(stepsLeft<=0){
            complete=true;
        }
    }

}
