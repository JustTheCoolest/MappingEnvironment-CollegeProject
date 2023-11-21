import java.io.ObjectInputFilter.Config;

import Bot;
import SimulatedEnvironment;
import ConfigurationConstants;

class Simulator{
    public static void simulate(Bot bot, SimulatedEnvironment env){
        int path[] = env.generateRandomPath(size: ConfigurationConstants.PATH_LENGTH); 
        bot.setPath(path);
        for(int i = 0; i < path.length/2; ++i){
            bot.move(path[i]);
        }
        Bot bot2 = new Bot(bot);
        int path2[] = env.generateRandomPath(size: ConfigurationConstants.PATH_LENGTH - path.length/2);
        bot2.setPath(path2);
        for(int i = path.length/2; i < path.length; ++i){
            bot.move(path[i]);
            bot2.move(path[i]);
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