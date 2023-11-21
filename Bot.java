public class Bot {
    private SimulatedEnvironment env;
    public Map map;
    private int coordinates[];
    public Bot(){
        this.map = new Map();
        coordinates = new int[2];
        coordinates[0] = 0;
        coordinates[1] = 0;
    }
    public Bot(int[] coordinates, Map map){
        this.map = map;
        this.coordinates = copy(coordinates);
    }
    public void setEnvironment(SimulatedEnvironment env){
        this.env = env;
    }
    public void move(int direction){
        this.map.move(direction, this.coordinates);
        this.map.writeData(this.env.readData());
    }
}
