public class Map {
    private BST nodes;
    public Map() {
        nodes = new BST();
    }
    public void show() {
        System.out.println("Map:");
        int max_x = nodes.max_x;
        int max_y = nodes.max_y;
        int min_x = nodes.min_x;
        int min_y = nodes.min_y;
        for (int i = min_y; i <= max_y; ++i) {
            for (int j = min_x; j <= max_x; ++j) {
                Node current = nodes.search(new int[] {j, i});
                if (current == null) {
                    System.out.print("0 ");
                } else {
                    System.out.print(Color.toString(current.data) + " ");
                }
            }
            System.out.println();
        }
    }
    // Task : Switch to a previous_node as parameter system instead of coordinates as parameter for better efficiency
    void move(int direction, int[] coordinates) {
        show();
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
        current.adjacent[direction] = next;
        next.adjacent[Direction.inverse(direction)] = current;
    }
    void writeData(int data, int[] coordinates) {
        nodes.search(coordinates).data = data;
    }
}
