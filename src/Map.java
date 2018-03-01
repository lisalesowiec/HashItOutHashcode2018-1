public class Map {
    private int depth, width;
    private Object[][] map;

    public Map(int depth, int width){
        this.depth = depth;
        this.width = width;
        map = new Object[depth][width];

    }

    public void placeVehicle(Object car, Location l){
        map[l.getX()][l.getY()] = car;
    }

    public Object getObjectAt(int x, int y){
        return map[x][y];
    }
}
