import Bot;
import SimulatedEnvironment;
import ConfigurationConstants;

class Simulator{
    private void move(int direction, Bot bot, SimulatedEnvironment env){
        env.move(direction);
        bot.move(direction);
    }
    public static void simulate(Bot bot, SimulatedEnvironment env){
        int path[] = env.generateRandomPath(size: ConfigurationConstants.PATH_LENGTH);
        for(int i = 0; i < path.length/2; ++i){
            move(path[i], bot, env);
        }
        Bot bot2 = new Bot();
        int coordinates[] = env.pickRandomPositionForBot(); // env.getUnvisitedCoordinates();
        SimulationEnvironment env2 = new SimulationEnvironment(env.getIndices(coordinates), ConfigurationConstants.ENV_WIDTH, ConfigurationConstants.ENV_HEIGHT);
        int path2[] = env.generateRandomPath(coordinates = coordinates, size = ConfigurationConstants.PATH_LENGTH - path.length/2);
        for(int i = path.length/2; i < path.length; ++i){
            move(path[i], bot, env);
            move(path2[i], bot2, env2);
        }
        System.out.println("Simulation Complete");
    }
}

class Main{
    public static void main(String[] args){
        Bot bot = new Bot();
        SimulatedEnvironment env = new SimulatedEnvironment(ConfigurationConstants.ENV_WIDTH, ConfigurationConstants.ENV_HEIGHT); // dimensions: 2
        bot.setEnvironment(env);
        Simulator.simulate(bot, env);
    }
}