package Trees;

public class isBalanced {

    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left, right);
    }


    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);

        return Math.abs(right - left) <=1 && isBalanced(root.left) && isBalanced(root.right);

    }
    
}
