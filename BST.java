public class BST {
    SearchNode root;

    public BST() {
        this.root = null;
    }

    public void insert(Node node) {
        root = insert(root, node);
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
