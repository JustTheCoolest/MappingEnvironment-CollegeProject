import java.util.Arrays;
// import Bot;
// import SimulatedEnvironment;
// import ConfigurationConstants;

class Simulator{
    private static void move(int direction, Bot bot, SimulatedEnvironment env){
        env.move(direction, bot.terminal_colour);
        bot.move(direction);
    }
    public static void simulate(Bot bot, SimulatedEnvironment env){
        int path[] = env.generateRandomPath(ConfigurationConstants.PATH_LENGTH);
        for(int i = 0; i < path.length/2; ++i){
            move(path[i], bot, env);
        }
        // Task: Implement with disjoint map components
        // int coordinates[] = env.pickRandomPositionForBot(); // env.getUnvisitedCoordinates();
        // Bot bot2 = new Bot(coordinates, bot.map);
        // SimulatedEnvironment env2 = new SimulatedEnvironment(env.getIndices(coordinates), ConfigurationConstants.ENV_WIDTH, ConfigurationConstants.ENV_HEIGHT);
        // int path2[] = env.generateRandomPath(coordinates = coordinates, size = ConfigurationConstants.PATH_LENGTH - path.length/2);
        Bot bot2 = new Bot("\u001B[34m", bot);
        SimulatedEnvironment env2 = new SimulatedEnvironment(1, env);
        int path2[] = env2.generateRandomPath(ConfigurationConstants.PATH_LENGTH - path.length/2);
        for(int i = path.length/2; i < path.length; ++i){
            move(path[i], bot, env);
            move(path2[i-path.length/2], bot2, env2);
        }
        System.out.println("Simulation Complete");
    }


    public static void simulateOneBot(Bot bot, SimulatedEnvironment env){
        int path[] = env.generateRandomPath(ConfigurationConstants.PATH_LENGTH);
        System.out.println(Arrays.toString(path));
        for(int i = 0; i < path.length; ++i){
            move(path[i], bot, env);
        }
        System.out.println("Simulation Complete");
    }
}

class Main{
    public static void main(String[] args){
        Bot bot = new Bot("\u001B[32m");
        SimulatedEnvironment env = new SimulatedEnvironment(0, ConfigurationConstants.ENV_WIDTH, ConfigurationConstants.ENV_HEIGHT); // dimensions: 2
        bot.setEnvironment(env);
        Simulator.simulate(bot, env);
        //Simulator.simulateOneBot(bot, env);
    }
}