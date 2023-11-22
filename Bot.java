import java.util.Arrays;

public class Bot {
    SimulatedEnvironment env;
    public Map map;
    private int coordinates[];
    String terminal_colour;
    private void constructor(){
    }
    public Bot(String terminal_colour){
        this.map = new Map();
        coordinates = new int[2];
        coordinates[0] = 0;
        coordinates[1] = 0;
        this.terminal_colour = terminal_colour;
        constructor();
    }
    public Bot(String terminal_colour, int[] coordinates, Map map){
        this.map = map;
        this.coordinates = Arrays.copyOf(coordinates, coordinates.length);
        this.terminal_colour = terminal_colour;
        constructor();
    }
    public Bot(String terminal_colour, Bot bot){
        this.map = bot.map;
        this.coordinates = Arrays.copyOf(bot.coordinates, bot.coordinates.length);
        this.terminal_colour = terminal_colour;
        this.env = bot.env;
        constructor();
    }
    public void setEnvironment(SimulatedEnvironment env){
        this.env = env;
        this.map.writeData(this.env.readData(coordinates), terminal_colour, this.coordinates);
    }
    public void move(int direction){
        this.map.move(direction, this.coordinates);
        this.map.writeData(this.env.readData(coordinates), terminal_colour, this.coordinates);
    }
}
