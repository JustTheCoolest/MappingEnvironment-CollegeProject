import Bot;
import SimulatedEnvironment;
import ConfigurationConstants;

class Simulator{
    public static void simulate(Bot bot, SimulatedEnvironment env){
        int path[] = env.generateRandomPath(size: ConfigurationConstants.PATH_LENGTH);
        for(int i = 0; i < path.length/2; ++i){
            bot.move(path[i]);
        }
        SimulationEnvironment env2 = new SimulationEnvironment(env);
        Bot bot2 = new Bot();
        int coordinates[] = env.getUnvisitedCoordinates();
        env2.setStart(env.getIndices(coordinates));
        int path2[] = env.generateRandomPath(coordinates = coordinates, size = ConfigurationConstants.PATH_LENGTH - path.length/2);
        for(int i = path.length/2; i < path.length; ++i){
            bot.move(path[i]);
            bot2.move(path2[i]);
        }
        System.out.println("Simulation Complete");
    }
}

class Main{
    public static void main(String[] args){
        Bot bot = new Bot();
        SimulatedEnvironment env = new SimulatedEnvironment(); // dimensions: 2
        env.setSize(ConfigurationConstants.ENV_WIDTH, ConfigurationConstants.ENV_HEIGHT);
        bot.setEnvironment(env);
        Simulator.simulate(bot, env);
    }
}