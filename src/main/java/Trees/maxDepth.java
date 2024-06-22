package Trees;

public class maxDepth {
    public int depth(TreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
    
}
