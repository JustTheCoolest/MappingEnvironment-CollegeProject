import java.util.Arrays;

public class Bot {
    private SimulatedEnvironment env;
    public Map map;
    private int coordinates[];
    private void constructor(){
    }
    public Bot(){
        this.map = new Map();
        coordinates = new int[2];
        coordinates[0] = 0;
        coordinates[1] = 0;
        constructor();
    }
    public Bot(int[] coordinates, Map map){
        this.map = map;
        this.coordinates = Arrays.copyOf(coordinates, coordinates.length);
        constructor();
    }
    public Bot(Bot bot){
        this.map = bot.map;
        this.coordinates = Arrays.copyOf(bot.coordinates, bot.coordinates.length);
        constructor();
    }
    public void setEnvironment(SimulatedEnvironment env){
        this.env = env;
        this.map.writeData(this.env.readData(coordinates), this.coordinates);
    }
    public void move(int direction){
        this.map.move(direction, this.coordinates);
        this.map.writeData(this.env.readData(coordinates), this.coordinates);
    }
}
