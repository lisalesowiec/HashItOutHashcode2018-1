
public class Location {
    private int xCo = 0;
    private int yCo = 0;

    public Location(){

    }

    public Location(int x, int y){
        xCo = x;
        yCo = y;
    }
    public void setLocation(int x, int y){
        xCo = x;
        yCo = y;
    }

    public int getX(){
        return xCo;
    }

    public int getY(){
        return yCo;
    }
}
