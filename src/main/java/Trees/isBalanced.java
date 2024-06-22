package Trees;

public class isBalanced {

    public int height(TreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left, right);
    }


    public boolean isBalancedFinder(TreeNode<Integer> root) {
        if(root == null) {
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);

        return Math.abs(right - left) <=1 && isBalancedFinder(root.left) && isBalancedFinder(root.right);

    }
    
}
