class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class que4b {
    private TreeNode parentX;
    private TreeNode parentY;
    private int depthX;
    private int depthY;

    public boolean areBrothers(TreeNode root, int x, int y) {
        
        findNodes(root, null, 0, x, y);
        
        
        return depthX == depthY && parentX != parentY;
    }

    private void findNodes(TreeNode node, TreeNode parent, int depth, int x, int y) {
       
        if (node == null) {
            return;
        }

        
        if (node.val == x) {
            parentX = parent;
            depthX = depth;
        } else if (node.val == y) {
            parentY = parent;
            depthY = depth;
        }

        
        findNodes(node.left, node, depth + 1, x, y);
        findNodes(node.right, node, depth + 1, x, y);
    }

    public static void main(String[] args) {
       
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        
        int x = 4;
        int y = 3;

        
        que4b bt = new que4b();
        boolean result = bt.areBrothers(root, x, y);
        
       
        System.out.println(result); 
    }
}
