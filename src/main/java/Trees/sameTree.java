package Trees;

public class sameTree {
    

    public boolean isSameTree(TreeNode a, TreeNode b) {
        if(a == null && b == null){
            return true;
        }

        if(a == null || b== null) {
            return false;
        }

        if(a.data != b.data) {
            return false;
        }

        boolean left = isSameTree(a.left, b.left);
        boolean right = isSameTree(a.right, b.right);

        return left && right;
    }
}
