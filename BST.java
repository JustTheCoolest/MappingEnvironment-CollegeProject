public class BST {
    SearchNode root;
    public int max_x=-1, max_y=-1, min_x=1, min_y=1; // Caution: Will be broken if custom start provided or deletion provided

    public BST() {
        this.root = null;
    }

    public void insert(Node node) {
        root = insert(root, node);
        if (node.x > max_x) {
            max_x = node.x;
        }
        if (node.y > max_y) {
            max_y = node.y;
        }
        if (node.x < min_x) {
            min_x = node.x;
        }
        if (node.y < min_y) {
            min_y = node.y;
        }
    }
    private SearchNode insert(SearchNode root, Node node) {
        if (root == null) {
            root = new SearchNode(node);
            return root;
        }
        if (node.key() < root.map_node.key()) {
            root.left = insert(root.left, node);
        } else if (node.key() > root.map_node.key()) {
            root.right = insert(root.right, node);
        }
        return root;
    }

    public Node search(int[] coordinates) {
        return search(root, coordinates);
    }

    private Node search(SearchNode root, int[] coordinates) {
        if (root == null) {
            return null;
        }
        if (Node.key(coordinates) == root.map_node.key()) {
            return root.map_node;
        }
        if (Node.key(coordinates) < root.map_node.key()) {
            return search(root.left, coordinates);
        }
        return search(root.right, coordinates);
    }
}
