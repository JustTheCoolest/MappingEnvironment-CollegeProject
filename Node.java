public class Node {
    int x;
    int y;
    Node adjacent[] = new Node[4];
    int data;

    public Node(int coordinates[]) {
        this.x = coordinates[0];
        this.y = coordinates[1];
        
        // Initialize adjacent array to null values
        for (int i = 0; i < adjacent.length; i++) {
            adjacent[i] = null;
        }
    }

    int key() {
        /* Task: Any alg that works on infinite data size
        key = max(len(x), len(y)) as num string len
        */
        return Node.key(new int[]{x, y});
    }

    static int key(int coordinates[]){
        return coordinates[0] * 1000 + coordinates[1];
    }
}
