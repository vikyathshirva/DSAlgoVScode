package Trees;

public class InvertTree {


    public <T> TreeNode<T> invert(TreeNode<T> root) {
        if(root == null) {
            return null;
        }
        TreeNode<T> cur = new TreeNode<T>(root.data);
        cur.left = invert(cur.right);
        cur.right = invert(cur.left);
        return cur;
    }

}
