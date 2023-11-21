public class Color {
    final static int RED = 0, GREEN = 1, BLUE = 2;
    public static int pickRandom() {
        return (int) (Math.random() * 3);
    }
}