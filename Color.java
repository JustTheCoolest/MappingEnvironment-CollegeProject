public class Color {
    final static int RED = 0, GREEN = 1, BLUE = 2;
    public static int pickRandom() {
        return (int) (Math.random() * 3);
    }
    public static String toString(int color) {
        switch (color) {
            case 0:
                return "R";
            case 1:
                return "G";
            case 2:
                return "B";
        }
        return "N";
    }
}