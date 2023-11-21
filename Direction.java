public class Direction {
    public static int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3, NONE = -1;
    public static int inverse(int direction) {
        switch (direction) {
            case 0: // Move up
                return 1;
            case 1: // Move down
                return 0;
            case 2: // Move left
                return 3;
            case 3: // Move right
                return 2;
        }
        return -1;
    }
}
