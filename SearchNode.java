public class SearchNode {
    Node map_node;
    SearchNode left;
    SearchNode right;

    public SearchNode(Node map_node) {
        this.map_node = map_node;
        this.left = null;
        this.right = null;
    }
}
