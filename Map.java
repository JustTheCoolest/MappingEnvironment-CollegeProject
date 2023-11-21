public class Map {
    private BST nodes;
    public Map() {
        nodes = new BST();
    }
    // Task : Switch to a previous_node as parameter system instead of coordinates as parameter for better efficiency
    void move(int direction, int[] coordinates) {
        Node current = nodes.search(coordinates);
        switch (direction) {
            case 0: // Move up
                coordinates[1]--;
                break;
            case 1: // Move down
                coordinates[1]++;
                break;
            case 2: // Move left
                coordinates[0]--;
                break;
            case 3: // Move right
                coordinates[0]++;
                break;
        }
        Node next = nodes.search(coordinates);
        if (next == null) {
            next = new Node(coordinates);
            nodes.insert(next);
        }
        current[direction] = next;
        next[Direction.inverse(direction)] = current;
    }
    void writeData(int data, int[] coordinates) {
        nodes.search(coordinates).data = data;
    }
}
