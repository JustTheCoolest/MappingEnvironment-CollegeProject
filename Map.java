class BST{
    Node root;
    
    boolean search(Node root, int x, int y){
        if(root == null) return false;
        
        if(root.x == x && root.y == y) return true;
        
        if(root.x < x) return search(root.right, x, y);
        
        if(root.x > x) return search(root.left, x, y);
        
        if(root.y < y) return search(root.front, x, y);
        
        else return search(root.back, x, y);
        
    }
}
