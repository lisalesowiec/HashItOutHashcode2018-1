public class Map {
    private int depth, width;

    private Object[][] map;

    public Map(int depth, int width){
        this.depth = depth;
        this.width = width;
        map = new Object[depth][width];

    }

    public void placeVehicle(Object vehicle, Location l){
        map[l.getX()][l.getY()] = vehicle;
    }
}
