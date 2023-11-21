import Color;

public class SimulatedEnvironment {
    private final int data[][];
    private final int initial_position[];
    private int position[];
    private final int width, height;
    private void fillData(){
        for(int i = 0; i < width; ++i){
            for(int j = 0; j < height; ++j){
                data[i][j] = Color.pickRandom();
            }
        }
    }
    private void constructor(int position[], int width, int height){
        this.width = width;
        this.height = height;
        this.initial_position = copy(position);
        this.position = position;
        data = new int[width][height];
        fillData();
    }
    public SimulationEnvironment(int width, int height){
        position = pickRandomPosition();
        constructor(position, width, height);
    }
    public SimulationEnvironment(int position[], int width, int height){
        constructor(position, width, height);
    }
    private boolean isValidMove(int position[], int direction) {
        switch (direction) {
            case 0: // Move up
                return position[1] > 0;
            case 1: // Move down
                return position[1] < height - 1;
            case 2: // Move left
                return position[0] > 0;
            case 3: // Move right
                return position[0] < width - 1;
            default:
                return false;
        }
    }
    public int[] generateRandomPath(int size) {
        int local_position[] = copy(position);
        int path[] = new int[size];
        for (int i = 0; i < size; ++i) {
            int direction;
            do {
                direction = (int) (Math.random() * 4);
            } while (!isValidMove(local_position, direction));
            switch (direction) {
                case 0: // Move up
                    local_position[1]--;
                    break;
                case 1: // Move down
                    local_position[1]++;
                    break;
                case 2: // Move left
                    local_position[0]--;
                    break;
                case 3: // Move right
                    local_position[0]++;
                    break;
            }
            path[i] = direction;
        }
        return path;
    }
}